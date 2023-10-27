package com.assign.entity.common;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description:
 * Author wangyang209
 * CreateTime: 2023/9/12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long totalNum;

    private List<T> data;

    public static <T, R> PageResult<R> from(PageInfo<T> pageInfo, Function<T, R> function) {
        List<T> list = pageInfo.getList();

        return PageResult.<R>builder()
                .data(list.stream().map(function).collect(Collectors.toList()))
                .totalNum(pageInfo.getTotal())
                .build();
    }

    public static <T> PageResult<T> from(PageInfo<T> pageInfo) {

        return PageResult.<T>builder()
                .data(pageInfo.getList())
                .totalNum(pageInfo.getTotal())
                .build();
    }

}
