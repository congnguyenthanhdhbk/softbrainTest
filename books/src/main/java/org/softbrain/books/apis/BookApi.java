package org.softbrain.books.apis;

import org.softbrain.books.dtos.AppResponse;
import org.softbrain.books.dtos.BookDto;
import org.softbrain.books.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "api/v1")
public interface BookApi {
    @PostMapping(name = "/book")
    AppResponse<Book> addBook(@RequestBody final BookDto bookDto);

    @GetMapping(name = "/books")
    AppResponse<Page<Book>> findAllBook(@RequestParam(name = "pageSize", required = false) final Integer pageSize,
                                        @RequestParam(name = "pageNumber", required = false) final Integer pageNumber);

    @PutMapping(name = "/book/{bookId}")
    AppResponse<Boolean> updateBook(
            @PathVariable(name = "bookId", required = true) final Integer bookId,
            @RequestBody final BookDto bookDto);
    @GetMapping(name = "/book/{bookId}")
    AppResponse<Book> findBookById(@PathVariable(name = "bookId") final Integer bookId);

    @DeleteMapping(name = "/book/{bookId}")
    AppResponse<Boolean> deleteBook(@PathVariable(name = "bookId") final Integer bookId);
}
