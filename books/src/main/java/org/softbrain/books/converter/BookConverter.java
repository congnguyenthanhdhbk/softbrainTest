package org.softbrain.books.converter;

import org.softbrain.books.dtos.BookDto;
import org.softbrain.books.models.Author;
import org.softbrain.books.models.Book;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service to convert bookdto to book object
 */
@Service
public class BookConverter {
    /**
     * convert BookDto to Book
     * @param book BookDto of Object
     * @return Book of object
     */
    public Book convertToBook(final BookDto book) {
        final Set<Author> authors = book
                .getAuthors()
                .stream()
                .map(authorDto -> {
                    final Author author = new Author();
                    author.setDescription(authorDto.getDescription());
                    author.setDob(authorDto.getDob());
                    author.setFullName(authorDto.getFullName());
                    return author;
                }).collect(Collectors.toSet());
        return new Book(
                book.getIsbn(),
                book.getTitle(),
                book.getPublisher(),
                book.getStatus(),
                authors);
    }
}
