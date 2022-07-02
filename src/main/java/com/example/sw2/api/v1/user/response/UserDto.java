package com.example.sw2.api.v1.user.response;

import com.example.sw2.util.UserEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author NhatPA
 * @since 12/06/2022 - 20:41
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;

    private String name;

    private String address;

    private UserEnum.UserStatus userStatus;
}
