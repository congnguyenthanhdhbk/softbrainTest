package org.softbrain.books.apis;

import org.softbrain.books.dtos.AppResponse;
import org.softbrain.books.dtos.AuthorDto;
import org.softbrain.books.models.Author;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class to expose api of Author
 */
@RestController
@RequestMapping(name = "api/v1")
public interface AuthorApi {
    /**
     * Expose API to add new author
     * @param authorDto AuthorDto
     * @return AppResponse of author
     */
    @PostMapping(name = "/author")
    AppResponse<Author> addAuthor(@RequestBody final AuthorDto authorDto);

    /**
     * Expose API for fet all author. Its required pagination
     * @param pageSize Integer
     * @param pageNumber Integer
     * @return List all Author
     */
    @GetMapping(name = "/author")
    AppResponse<Page<Author>> findAllAuthor(@RequestParam(name = "pageSize", required = false) final Integer pageSize,
                                        @RequestParam(name = "pageNumber", required = false) final Integer pageNumber);

    /**
     * Expose API to update author
     * @param authorId Integer
     * @param authorDto AuthorDto
     * @return Status of updating author
     */
    @PutMapping(name = "/author/{authorId}")
    AppResponse<Boolean> updateAuthor(
            @PathVariable(name = "authorId") final Integer authorId,
            @RequestBody final AuthorDto authorDto);

    /**
     * Expose API to query Author by ID
     * @param authorId Integer
     * @return Object of author
     */
    @GetMapping(name = "/author/{authorId}")
    AppResponse<Author> findAuthorById(@PathVariable(name = "authorId") final Integer authorId);

    /**
     * Expose API to delete logical author
     * @param authorId Integer
     * @return Status of deleting
     */
    @DeleteMapping(name = "/author/{authorId}")
    AppResponse<Boolean> deleteAuthor(@PathVariable(name = "authorId") final Integer authorId);
}
