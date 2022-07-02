package com.example.sw2.configuration;

import com.example.sw2.api.v1.user.response.UserDto;
import com.example.sw2.util.UserEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author NhatPA
 * @since 12/06/2022 - 20:57
 */
@Configuration
public class BeanConfiguration {

    /**
     * Fake data {@link UserDto}
     */
    @Bean
    public List<UserDto> fakeData() {
        return Arrays.asList(
                new UserDto(1, "ABC", "37a", UserEnum.UserStatus.ACTIVE),
                new UserDto(2, "ABC2", "37a", UserEnum.UserStatus.INACTIVE),
                new UserDto(3, "ABC3", "37a", UserEnum.UserStatus.ACTIVE)
        );
    }
}
