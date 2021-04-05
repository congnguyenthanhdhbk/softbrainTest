package org.softbrain.books.services.impl;

import org.softbrain.books.converter.AuthorConverter;
import org.softbrain.books.dtos.AppResponse;
import org.softbrain.books.dtos.AuthorDto;
import org.softbrain.books.enums.AppMessageEnum;
import org.softbrain.books.enums.LogicMessageEnum;
import org.softbrain.books.models.Author;
import org.softbrain.books.repositories.AuthorRepository;
import org.softbrain.books.services.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    private AuthorConverter authorConverter;

    public AuthorServiceImpl(AuthorRepository authorRepository,
                             AuthorConverter authorConverter) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
    }

    /**
     * @see {@link AuthorService#addAuthor(AuthorDto)}
     * @param author AuthorDto
     * @return
     */
    @Override
    public AppResponse<Author> addAuthor(AuthorDto author) {
        final Author newAuthor = this.authorConverter.convertToAuthor(author);
        return new AppResponse<>(
                AppMessageEnum.SAVED_AUTHOR_SUCCESS.getCode(),
                AppMessageEnum.SAVED_AUTHOR_SUCCESS.getMessage(),
                this.authorRepository.save(newAuthor)
        );
    }

    /**
     * @see {@link AuthorService#findAllAuthor(Integer, Integer)}
     * @param pageNumber Integer
     * @param pageSize Integer
     * @return
     */
    @Override
    public AppResponse<Page<Author>> findAllAuthor(Integer pageNumber, Integer pageSize) {
        if (Objects.isNull(pageNumber)) {
            throw new IllegalArgumentException(LogicMessageEnum.PAGE_NUMBER_IS_NULL.getMessage());
        }

        if (Objects.isNull(pageSize)) {
            throw new IllegalArgumentException(LogicMessageEnum.PAGE_SIZE_IS_NULL.getMessage());
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return new AppResponse<>(
                AppMessageEnum.FIND_ALL_AUTHOR_SUCCESS.getCode(),
                AppMessageEnum.FIND_ALL_AUTHOR_SUCCESS.getMessage(),
                this.authorRepository.findAll(pageable)
        );
    }

    /**
     * @see {@link AuthorService#findAuthorById(Integer)}
     * @param authorId Integer
     * @return
     */
    @Override
    public AppResponse<Author> findAuthorById(Integer authorId) {
        return new AppResponse<>(
                AppMessageEnum.FIND_AUTHOR_BY_ID_SUCCESS.getCode(),
                AppMessageEnum.FIND_AUTHOR_BY_ID_SUCCESS.getMessage(),
                this.authorRepository.findById(authorId).get()
        );
    }

    /**
     * @see {@link AuthorService#updateAuthor(Integer, AuthorDto)}
     * @param authorId Integer
     * @param authorDto AuthorDto
     * @return
     */
    @Override
    public AppResponse<Boolean> updateAuthor(Integer authorId, AuthorDto authorDto) {
        if (Objects.isNull(authorId)) {
            throw new IllegalArgumentException(LogicMessageEnum.AUTHOR_ID_IS_NULL.getMessage());
        }

        if (Objects.isNull(authorDto)) {
            throw new IllegalArgumentException(LogicMessageEnum.UPDATED_AUTHOR_IS_NULL.getMessage());
        }

        final Optional<Author> author = this.authorRepository.findById(authorId);
        if (!author.isPresent()) {
            throw new IllegalArgumentException(LogicMessageEnum.NOT_FOUND_AUTHOR.getMessage());
        }
        author.get().setDescription(authorDto.getDescription());
        author.get().setDob(authorDto.getDob());
        author.get().setFullName(authorDto.getFullName());
        return new AppResponse<>(
                AppMessageEnum.UPDATED_AUTHOR_SUCCESS.getCode(),
                AppMessageEnum.UPDATED_BOOK_SUCCESS.getMessage(),
                true
        );
    }

    /**
     * @see {@link AuthorService#deleteAuthor(Integer)}
     * @param authorId Integer
     * @return
     */
    @Override
    public AppResponse<Boolean> deleteAuthor(Integer authorId) {
        final Optional<Author> author = this.authorRepository.findById(authorId);
        if (author.isPresent()) {
            return new AppResponse<>(
                    AppMessageEnum.UPDATED_BOOK_SUCCESS.getCode(),
                    AppMessageEnum.UPDATED_BOOK_SUCCESS.getMessage(),
                    true);
        }
        return new AppResponse<>(
                AppMessageEnum.DELETE_AUTHOR_FAILED.getCode(),
                AppMessageEnum.DELETE_AUTHOR_FAILED.getMessage(),
                false
        );
    }
}
