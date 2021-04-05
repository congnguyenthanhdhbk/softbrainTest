package org.softbrain.books.converter;

import org.softbrain.books.dtos.AuthorDto;
import org.softbrain.books.enums.LogicMessageEnum;
import org.softbrain.books.models.Author;
import org.softbrain.books.models.Book;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Class to convert dto object to model object
 */
@Service
public class AuthorConverter {
    /**
     * Convert dto to model
     * @param authorDto AuthorDto
     * @return Author of object
     */
    public Author convertToAuthor(final AuthorDto authorDto) {
        if (Objects.isNull(authorDto)) {
            throw new IllegalArgumentException(LogicMessageEnum.AUTHOR_DTO_IS_NULL.getMessage());
        }
        return new Author(
                authorDto.getFullName(),
                authorDto.getDob(),
                authorDto.getDescription(),
                authorDto
                        .getBooks()
                        .stream()
                .map(bookDto -> {
                    final Book newBook = new Book();
                    newBook.setIsbn(bookDto.getIsbn());
                    newBook.setPublisher(bookDto.getPublisher());
                    newBook.setTitle(bookDto.getTitle());
                    newBook.setStatus(bookDto.getStatus());
                    return newBook;
                }).collect(Collectors.toSet())
        );
    }
}
