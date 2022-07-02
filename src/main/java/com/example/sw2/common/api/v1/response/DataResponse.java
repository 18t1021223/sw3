package com.example.sw2.common.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author NhatPA
 * @since 23/03/2022 - 08:14
 */
@Getter
@Setter
@AllArgsConstructor
public class DataResponse<T> {

    private int code;

    private T data;

    public static <T> DataResponse<T> build(HttpStatus status, T data) {
        return new DataResponse<>(status.value(), data);
    }

    public static <T> DataResponse<T> ok() {
        return build(HttpStatus.OK, null);
    }

    public static <T> DataResponse<T> ok(T data) {
        return build(HttpStatus.OK, data);
    }

    public static <T> DataResponse<T> bad(T data) {
        return build(HttpStatus.BAD_REQUEST, data);
    }
}
