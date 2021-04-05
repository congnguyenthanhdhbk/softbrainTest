package org.softbrain.books.apis.impl;

import org.softbrain.books.apis.BookApi;
import org.softbrain.books.dtos.AppResponse;
import org.softbrain.books.dtos.BookDto;
import org.softbrain.books.models.Book;
import org.softbrain.books.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class to expose api for client or 3rd
 */
@RestController
public class BookApiImpl implements BookApi {
    private final BookService bookService;

    public BookApiImpl(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * @see {@link BookApi#addBook(BookDto)}
     * @param bookDto
     * @return
     */
    @Override
    public AppResponse<Book> addBook(BookDto bookDto) {
        try {
            return this.bookService.addBook(bookDto);
        } catch (IllegalArgumentException e) {
            return new AppResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    null);
        }
    }

    /**
     * @see {@link BookApi#findAllBook(Integer, Integer)}
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @Override
    public AppResponse<Page<Book>> findAllBook(Integer pageSize,
                                               Integer pageNumber) {
        try {
            return this.bookService.findAllBook(pageNumber, pageSize);
        } catch (IllegalArgumentException e) {
            return new AppResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    null);
        }
    }

    /**
     * @see {@link BookApi#updateBook(Integer, BookDto)}
     * @param bookId
     * @param bookDto
     * @return
     */
    @Override
    public AppResponse<Boolean> updateBook(Integer bookId,
                                           BookDto bookDto) {
        try {
            return this.bookService.updateBook(bookId, bookDto);
        } catch (IllegalArgumentException e) {
            return new AppResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    false);
        }
    }

    /**
     * @see {@link BookApi#findBookById(Integer)}
     * @param bookId
     * @return
     */
    @Override
    public AppResponse<Book> findBookById(Integer bookId) {
        try {
            return this.bookService.findBookById(bookId);
        } catch (IllegalArgumentException e) {
            return new AppResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    null);
        }
    }

    /**
     * @see {@link BookApi#deleteBook(Integer)}
     * @param bookId
     * @return
     */
    @Override
    public AppResponse<Boolean> deleteBook(Integer bookId) {
        try {
            return this.bookService.delete(bookId);
        } catch (IllegalArgumentException e) {
            return new AppResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    false);
        }
    }
}
