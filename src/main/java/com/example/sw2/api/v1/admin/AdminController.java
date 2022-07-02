package com.example.sw2.api.v1.admin;

import com.example.sw2.common.api.v1.response.DataResponse;
import com.example.sw2.common.api.v1.response.PageRes;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author NhatPA
 * @since 12/06/2022 - 22:23
 */
@RestController
@RequestMapping("/api/v1/admins")
@FieldDefaults(level = AccessLevel.PUBLIC)
public class AdminController {

    @GetMapping
    DataResponse<PageRes<String>> getUsers(@RequestParam String email) {
        return DataResponse.ok(new PageRes<>(
                Arrays.asList("a@.gmail.com", "a@.gmail.com", "a@.gmail.com")
        ));
    }
}
