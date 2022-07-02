package com.example.sw2.api.v1.user.request;

import com.example.sw2.util.UserEnum;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;

/**
 * @author NhatPA
 * @since 12/06/2022 - 20:16
 */
@Getter
@Setter
public class SearchUserDto {

    private String search;

    @Parameter()
    private UserEnum.UserStatus status;
}
