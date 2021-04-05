package org.softbrain.books.repositories;

import org.softbrain.books.models.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer>,
        PagingAndSortingRepository<Author, Integer> {
    @Query("from Author auth where auth.isDeleted = false")
    Page<Author> findAll(Pageable pageable);

    @Query("from Author auth where auth.id = ?1 and auth.isDeleted = ?2")
    Author findAuthorByIdAndAndDeleted(Integer authorId, Boolean isDeleted);
}
