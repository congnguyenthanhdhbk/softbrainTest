package org.softbrain.books.dtos;

public class AppResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public AppResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "AppResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}