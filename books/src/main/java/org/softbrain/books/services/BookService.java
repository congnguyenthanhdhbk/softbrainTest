package org.softbrain.books.services;

import org.softbrain.books.dtos.AppResponse;
import org.softbrain.books.dtos.BookDto;
import org.softbrain.books.models.Book;
import org.springframework.data.domain.Page;

/**
 * Class working on the project as service to provide some sevice
 * for getting boo in system. Some populate features as find by id
 * , get all booking as well as creating a book.
 */
public interface BookService {
    /**
     * Service support for adding new booking in the system.
     * @param book BookDto
     * @return after saving successfully then returning
     */
    AppResponse<Book> addBook(final BookDto book);

    /**
     * The service support for getting all data by paginating
     * @param pageNumber Integer
     * @param pageSize Integer
     * @return List of Book
     */
    AppResponse<Page<Book>> findAllBook(final Integer pageNumber, final Integer pageSize);

    /**
     * Getting book base on bookinf id
     * @param bookId Integer
     * @return Object of book
     */
    AppResponse<Book> findBookById(final Integer bookId);

    /**
     * Service support for updating a book
     * @param bookId Integer
     * @param updatedBookDto BookDto
     * @return state for updating false or true
     */
    AppResponse<Boolean> updateBook(final Integer bookId, final BookDto updatedBookDto);

    /**
     * Support for delete a book
     * @param bookId Integer
     * @return Boolean to notification that book has just deleted
     */
    AppResponse<Boolean> delete(final Integer bookId);
}
