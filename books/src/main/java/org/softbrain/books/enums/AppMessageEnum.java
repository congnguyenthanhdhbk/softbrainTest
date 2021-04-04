package org.softbrain.books.enums;

import org.springframework.http.HttpStatus;

/**
 * Enum to define all system message
 */
public enum AppMessageEnum {
    SAVED_BOOK_SUCCESS(HttpStatus.OK.value(), "Saved Book is success"),
    FIND_BOOK_BY_ID_SUCCEED(HttpStatus.OK.value(), "Finding book is success"),
    UPDATED_BOOK_SUCCESS(HttpStatus.OK.value(), "Updated book is success"),
    FIND_ALL_BOOK_SUCCESS(HttpStatus.OK.value(), "Found book is success");
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
