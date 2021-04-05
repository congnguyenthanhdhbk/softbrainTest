package org.softbrain.books.apis;

import org.softbrain.books.dtos.AppResponse;
import org.softbrain.books.dtos.AuthorDto;
import org.softbrain.books.models.Author;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "api/v1")
public interface AuthorApi {
    @PostMapping(name = "/author")
    AppResponse<Author> addAuthor(@RequestBody final AuthorDto authorDto);

    @GetMapping(name = "/author")
    AppResponse<Page<Author>> findAllAuthor(@RequestParam(name = "pageSize", required = false) final Integer pageSize,
                                        @RequestParam(name = "pageNumber", required = false) final Integer pageNumber);

    @PutMapping(name = "/author/{authorId}")
    AppResponse<Boolean> updateAuthor(
            @PathVariable(name = "authorId", required = true) final Integer authorId,
            @RequestBody final AuthorDto authorDto);

    @GetMapping(name = "/author/{authorId}")
    AppResponse<Author> findAuthorById(@PathVariable(name = "authorId") final Integer authorId);

    @DeleteMapping(name = "/author/{authorId}")
    AppResponse<Boolean> deleteAuthor(@PathVariable(name = "authorId") final Integer authorId);
}
