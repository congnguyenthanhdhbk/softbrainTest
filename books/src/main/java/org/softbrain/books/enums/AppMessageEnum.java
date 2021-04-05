package org.softbrain.books.enums;

import org.springframework.http.HttpStatus;

/**
 * Enum to define all system message
 */
public enum AppMessageEnum {
    // Message to handle proceed database
    SAVED_BOOK_SUCCESS(HttpStatus.CREATED.value(), "Added Book is success"),
    FIND_BOOK_BY_ID_SUCCEED(HttpStatus.OK.value(), "Finding book is success"),
    FIND_BOOK_BY_ID_FAILED(HttpStatus.NOT_FOUND.value(), "Book is not found"),
    UPDATED_BOOK_SUCCESS(HttpStatus.OK.value(), "Updated book is success"),
    FIND_ALL_BOOK_SUCCESS(HttpStatus.OK.value(), "Found book is success"),
    DELETE_BOOK_SUCCESS(HttpStatus.OK.value(), "Book has been deleted successfully"),
    DELETE_BOOK_FAILED(HttpStatus.NOT_FOUND.value(), "Book is not found"),
    SAVED_AUTHOR_SUCCESS(HttpStatus.CREATED.value(), "Added author is success"),
    FIND_AUTHOR_BY_ID_SUCCESS(HttpStatus.OK.value(), "Finding author is success"),
    UPDATED_AUTHOR_SUCCESS(HttpStatus.OK.value(), "Updated author is success"),
    FIND_ALL_AUTHOR_SUCCESS(HttpStatus.OK.value(), "Found author is success"),
    DELETE_AUTHOR_SUCCESS(HttpStatus.OK.value(), "Author has been deleted successfully"),
    DELETE_AUTHOR_FAILED(HttpStatus.NOT_FOUND.value(), "Author is not found");


    private int code;
    private String message;
    AppMessageEnum(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
