package org.softbrain.books.dtos;

import java.util.Set;

public class BookDto {
    private String isbn;
    private String title;
    private String publisher;
    // Status have four type as INITIAL, REVIEWED, APPROVED, PUBLISHED
    private String status;
    private Set<AuthorDto> authors;

    public BookDto(String isbn,
                   String title,
                   String publisher,
                   String status,
                   Set<AuthorDto> authors) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.status = status;
        this.authors = authors;
    }

    public BookDto() {
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

    public Set<AuthorDto> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", status='" + status + '\'' +
                ", authors=" + authors +
                '}';
    }
}
