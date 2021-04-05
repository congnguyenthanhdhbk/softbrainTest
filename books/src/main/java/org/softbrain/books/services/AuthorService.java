package org.softbrain.books.services;

import org.softbrain.books.dtos.AppResponse;
import org.softbrain.books.dtos.AuthorDto;
import org.softbrain.books.models.Author;
import org.springframework.data.domain.Page;

/**
 * Class provided all of services to run business of author
 */
public interface AuthorService {
    /**
     * Service support for create new author
     * @param author AuthorDto
     * @return AppResponse of author
     */
    AppResponse<Author> addAuthor(final AuthorDto author);

    /**
     * The service support for getting all data by paginating
     * @param pageNumber Integer
     * @param pageSize Integer
     * @return List of author
     */
    AppResponse<Page<Author>> findAllAuthor(final Integer pageNumber, final Integer pageSize);

    /**
     * Getting book base on author id
     * @param authorId Integer
     * @return Object of author
     */
    AppResponse<Author> findAuthorById(final Integer authorId);

    /**
     * Service support for updating a author
     * @param authorId Integer
     * @param authorDto AuthorDto
     * @return state for updating false or true
     */
    AppResponse<Boolean> updateAuthor(final Integer authorId, final AuthorDto authorDto);
}
