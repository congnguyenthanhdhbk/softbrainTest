package org.softbrain.books.repositories;

import org.softbrain.books.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends JpaRepository<Book, Integer>,
        PagingAndSortingRepository<Book, Integer> {

    @Query("from Book b where b.isDeleted = false ")
    Page<Book> findAll(Pageable pageable);

    @Query("from Book b where b.id = ?1 and b.isDeleted = ?2")
    Book findBookByIdAndDeleted(Integer bookId, Boolean isDeleted);
}
