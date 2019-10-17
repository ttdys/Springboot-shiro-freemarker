package com.zjh.tomato.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfoHolder<T> {

    private Integer draw;
    private Integer start;
    private Integer length;
    private Long recordsTotal;
    private Long recordsFiltered;
    private List<T> data;
    
}
