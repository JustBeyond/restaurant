package com.furseal.restaurant.common.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private int code;
    private String msg;
    private Long count;
    private List<T> data;
}
