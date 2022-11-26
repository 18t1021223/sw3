package com.example.sw2.api.v1.user.request;

import com.example.sw2.util.UserEnum;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.*;

/**
 * @author NhatPA
 * @since 12/06/2022 - 20:16
 */
@Getter
@Setter
@ToString
public class SearchUserDto {

    private String search;

    @Parameter()
    private UserEnum.UserStatus status;

    /**
     * <a href="https://www.rfc-editor.org/rfc/rfc3339#section-5.6">detail</a>
     */
    @Schema(example = "America/New_York", type = "string", format = "time-offset")
    private ZoneId zoneId;

    @Schema(example = "2022-12", type = "string")
    private YearMonth yearMonth;

    @Schema(type = "integer", format = "int32")
    private Year year;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;

    @Schema(defaultValue = "2018-05-12T20:30:00Z")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Instant instant;
}
