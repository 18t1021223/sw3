package com.example.sw2.common.api.v1.request;

import lombok.Data;

/**
 * @author NhatPA
 * @since 05/04/2022 - 23:37
 */
@Data
public class PageRequest {

    private Integer page;

    private Integer limit;

    /**
     * ex: sort=created_at-desc&sort=name
     */
    private String[] sort;
}
