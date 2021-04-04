package org.softbrain.books.repositories;

import org.softbrain.books.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends JpaRepository<Book, Integer>,
        PagingAndSortingRepository<Book, Integer> {
    Page<Book> findAll(Pageable pageable);
}
