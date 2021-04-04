package org.softbrain.books.dtos;

import java.time.LocalDateTime;
import java.util.Set;

public class AuthorDto {
    private String fullName;
    private LocalDateTime dob;
    private String description;
    private Set<BookDto> books;

    public AuthorDto(String fullName,
                     LocalDateTime dob,
                     String description,
                     Set<BookDto> books) {
        this.fullName = fullName;
        this.dob = dob;
        this.description = description;
        this.books = books;
    }

    public AuthorDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<BookDto> getBooks() {
        return books;
    }

    public void setBooks(Set<BookDto> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", description='" + description + '\'' +
                ", books=" + books +
                '}';
    }
}
