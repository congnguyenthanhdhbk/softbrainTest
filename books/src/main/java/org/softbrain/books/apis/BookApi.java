package org.softbrain.books.apis;

import org.softbrain.books.dtos.AppResponse;
import org.softbrain.books.dtos.BookDto;
import org.softbrain.books.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class to expose API for client and 3rd etc to manipulate
 * Book resource by using restfull service
 */
@RestController
@RequestMapping(value = "api/v1")
public interface BookApi {
    /**
     * Expose API to add new Book
     * @param bookDto BookDto
     * @return Object of Book
     */
    @PostMapping(value = "/book")
    AppResponse<Book> addBook(@RequestBody final BookDto bookDto);

    /**
     * Expose API to get all book resources. Its apply paginate to avoid get alls
     * data for one time query.
     * @param pageSize Integer
     * @param pageNumber Integer
     * @return List of book using paginate
     */
    @GetMapping(value = "/books")
    AppResponse<Page<Book>> findAllBook(@RequestParam(name = "pageSize", required = false) final Integer pageSize,
                                        @RequestParam(name = "pageNumber", required = false) final Integer pageNumber);

    /**
     * Expose API to update author resource via restfull service
     * @param bookId Integer
     * @param bookDto BookDto
     * @return Status of updating
     */
    @PutMapping(value = "/book/{bookId}")
    AppResponse<Boolean> updateBook(
            @PathVariable(name = "bookId", required = true) final Integer bookId,
            @RequestBody final BookDto bookDto);

    /**
     * Expose API to get author by id
     * @param bookId Integer
     * @return Object of the book
     */
    @GetMapping(value = "/book/{bookId}")
    AppResponse<Book> findBookById(@PathVariable(name = "bookId") final Integer bookId);

    /**
     * Expose API to delete Book resource
     * @param bookId Integer
     * @return status of deleting
     */
    @DeleteMapping(value = "/book/{bookId}")
    AppResponse<Boolean> deleteBook(@PathVariable(name = "bookId") final Integer bookId);
}
