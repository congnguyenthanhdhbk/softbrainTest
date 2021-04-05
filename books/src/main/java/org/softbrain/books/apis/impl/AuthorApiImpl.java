package org.softbrain.books.apis.impl;

import org.softbrain.books.apis.AuthorApi;
import org.softbrain.books.dtos.AppResponse;
import org.softbrain.books.dtos.AuthorDto;
import org.softbrain.books.models.Author;
import org.softbrain.books.services.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorApiImpl implements AuthorApi {
    private AuthorService authorService;

    public AuthorApiImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * @see {@link AuthorApi#addAuthor(AuthorDto)}
     * @param authorDto AuthorDto
     * @return AppResponse
     */
    @Override
    public AppResponse<Author> addAuthor(AuthorDto authorDto) {
        try {
            return this.authorService.addAuthor(authorDto);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new AppResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    illegalArgumentException.getMessage(),
                    null
            );
        }
    }

    /**
     * @see {@link AuthorApi#findAllAuthor(Integer, Integer)}
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @Override
    public AppResponse<Page<Author>> findAllAuthor(Integer pageSize, Integer pageNumber) {
        try {
            return this.authorService.findAllAuthor(pageNumber, pageSize);
        } catch (IllegalArgumentException e) {
            return new AppResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    null);
        }
    }

    /**
     * @see {@link AuthorApi#updateAuthor(Integer, AuthorDto)}
     * @param authorId
     * @param authorDto
     * @return
     */
    @Override
    public AppResponse<Boolean> updateAuthor(Integer authorId, AuthorDto authorDto) {
        try {
            return this.authorService.updateAuthor(authorId, authorDto);
        } catch (IllegalArgumentException e) {
            return new AppResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    false);
        }
    }

    /**
     * @see {@link AuthorApi#findAuthorById(Integer)}
     * @param authorId
     * @return
     */
    @Override
    public AppResponse<Author> findAuthorById(Integer authorId) {
        try {
            return this.authorService.findAuthorById(authorId);
        } catch (IllegalArgumentException e) {
            return new AppResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    null);
        }
    }

    /**
     * @see {@link AuthorApi#deleteAuthor(Integer)}
     * @param authorId
     * @return
     */
    @Override
    public AppResponse<Boolean> deleteAuthor(Integer authorId) {
        try {
            return this.authorService.deleteAuthor(authorId);
        } catch (IllegalArgumentException e) {
            return new AppResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    false);
        }
    }
}
