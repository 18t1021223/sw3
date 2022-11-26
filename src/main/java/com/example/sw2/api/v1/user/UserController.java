package com.example.sw2.api.v1.user;

import com.example.sw2.api.v1.user.request.SearchUserDto;
import com.example.sw2.api.v1.user.response.UserDto;
import com.example.sw2.common.api.v1.response.DataResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author NhatPA
 * @since 12/06/2022 - 20:10
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class UserController {

    private final List<UserDto> users;

    @PreAuthorize(value = "hasAnyAuthority('ADMIN', 'SUB_ADMIN')")
    @Operation(description = "- TopDev việc làm IT hàng đầu\n" +
            "  - Cộng sự đắc lực hỗ trợ doanh nghiệp tuyển dụng\n" +
            "  - Người bạn đồng hành giúp các Developer tìm được công việc mơ ước")
    @GetMapping
    DataResponse<SearchUserDto> getUsers(@ParameterObject SearchUserDto request) {
        log.info("{}", request);
//        return DataResponse.ok(new PageRes<>(users));
        return DataResponse.ok(request);
    }


    @PostMapping("/{userId}")
    DataResponse<String> deleteUser(@PathVariable String userId) {
        return DataResponse.ok();
    }
}
