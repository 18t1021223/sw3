package com.example.sw2.common.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ErrorRes {
    private int code;
    private String message;

    public static ErrorRes bad(String message) {
        return new ErrorRes(HttpStatus.BAD_REQUEST.value(), message);
    }
}
