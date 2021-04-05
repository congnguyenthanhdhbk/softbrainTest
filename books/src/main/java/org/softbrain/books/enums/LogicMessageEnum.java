package org.softbrain.books.enums;

public enum LogicMessageEnum {
    AUTHOR_DTO_IS_NULL("Author Dto must not be null or empty"),
    PAGE_NUMBER_IS_NULL("Page number must not be null or empty"),
    PAGE_SIZE_IS_NULL("Page size must not be null or empty"),
    AUTHOR_ID_IS_NULL("Author ID must not be null or empty"),
    UPDATED_AUTHOR_IS_NULL("Updated author must not be null or empty"),
    NOT_FOUND_AUTHOR("Author is not found");

    private final String message;
    LogicMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
