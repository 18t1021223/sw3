package com.example.sw2.util.paging;

import com.example.sw2.common.api.v1.request.PageRequest;
import com.example.sw2.common.api.v1.response.PageRes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PaginationUtils {

    private static final int DEFAULT_RECORD_PER_PAGE = 5;
    private static final int DEFAULT_CURRENT_PAGE = 0;
    private static final int MAX_LIMIT_SIZE = 100;

    public static final String DEFAULT_SORT_PROPERTY = "id";
    public static final String ASC = "asc";
    public static final String SPLIT = "-";

    public static <T> PageRes<T> buildPageRes(final List<T> page) {
        PageRes<T> res = new PageRes<>();
        res.setRecords(page);
        res.setPage(100);
        res.setLimit(100);
        res.setTotal((long) page.size());
        res.setTotalPage(100);
        return res;
    }

    private static Integer getPage(final String currentPage) {
        if (StringUtils.isBlank(currentPage)) {
            return DEFAULT_CURRENT_PAGE;
        }
        int page;
        try {
            page = Integer.parseInt(currentPage);
            page = page > 0 ? page - 1 : DEFAULT_CURRENT_PAGE;
        } catch (NumberFormatException e) {
            page = DEFAULT_CURRENT_PAGE;
        }

        return page;
    }

    /**
     * Convert to {@link PageRequest}
     *
     * @param dto {@link jp.meta.horse.dto.v1.request.PageRequest}
     * @return {@link PageRequest}
     */
//    public static PageRequest build(PageRequest dto) {
//        return PageRequest.of(
//                getPage(dto.getPage()),
//                getLimit(dto.getLimit()),
//                getSort(dto.getSort(), FormatType._1)
//        );
//    }

    /**
     * Convert to {@link PageRequest}
     *
     * @param dto {@link jp.meta.horse.dto.v1.request.PageRequest}
     * @return {@link PageRequest}
     */
//    public static PageRequest build(jp.meta.horse.dto.v1.request.PageRequest dto, FormatType formatType) {
//        return PageRequest.of(
//                getPage(dto.getPage()),
//                getLimit(dto.getLimit()),
//                getSort(dto.getSort(), formatType)
//        );
//    }

    private static int getPage(Integer page) {
        if (page == null) {
            return DEFAULT_CURRENT_PAGE;
        }
        return page > 0 ? page - 1 : DEFAULT_CURRENT_PAGE;
    }

    private static int getLimit(Integer limit) {
        if (limit == null || limit <= 0) {
            return DEFAULT_RECORD_PER_PAGE;
        }
        return limit <= MAX_LIMIT_SIZE ? limit : MAX_LIMIT_SIZE;
    }

//    private static Sort getSort(String[] sort, FormatType formatType) {
//        if (sort == null || sort.length == 0) {
//            sort = new String[]{DEFAULT_SORT_PROPERTY};
//        }
//        List<Sort.Order> list = new ArrayList<>(sort.length);
//        String[] e;
//        for (String item : sort) {
//            e = item.split(SPLIT);
//            if (e.length == 1) {
//                list.add(new Sort.Order(Direction.ASC, toFormat(formatType, e[0])));
//            } else if (e.length >= 2) {
//                list.add(new Sort.Order(toDirection(e[1]), toFormat(formatType, e[0])));
//            }
//        }
//        return Sort.by(list);
//    }

//    private static Direction toDirection(String v) {
//        return ASC.equalsIgnoreCase(v) ? Direction.ASC : Direction.DESC;
//    }
//
//    private static String toFormat(FormatType formatType, String v) {
//        return formatType.getCaseFormat().to(formatType.getTo(), v);
//    }
//
//    @Getter
//    @RequiredArgsConstructor
//    public enum FormatType {
//        _1(CaseFormat.LOWER_UNDERSCORE, CaseFormat.LOWER_CAMEL),
//        _2(CaseFormat.LOWER_CAMEL, CaseFormat.LOWER_UNDERSCORE);
//        private final CaseFormat caseFormat;
//        private final CaseFormat to;
//    }
}
