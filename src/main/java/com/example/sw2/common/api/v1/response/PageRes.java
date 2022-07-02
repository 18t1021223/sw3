package com.example.sw2.common.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRes<T> {
    private Long total;
    private Integer limit;
    private Integer totalPage;
    private Integer page;
    private List<T> records;

    public PageRes(List<T> data) {
        records = data;
        limit = 100;
        totalPage = 100;
        total = (long) data.size();
        page = 1;
    }
}
