/**
 *
 */
package org.softbrain.books.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "title")
    private String title;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "status")
    private String status;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    public Book(String isbn,
                String title,
                String publisher,
                String status,
                Set<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.status = status;
        this.authors = authors;
    }

    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getStatus() {
        return status;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", status='" + status + '\'' +
                ", authors=" + authors +
                '}';
    }
}
