package com.zjh.tomato.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuJson implements Comparable<MenuJson> {

    private Long menuId;
    private String menuName;
    private Long parentId;
    private String menuType;
    private String url;
    private String perms;
    private Integer sort;
    private Integer status;

    private List<MenuJson> children = new ArrayList<MenuJson>();

    @Override
    public int compareTo(MenuJson o) {
        return this.sort-o.getSort();
    }
}
