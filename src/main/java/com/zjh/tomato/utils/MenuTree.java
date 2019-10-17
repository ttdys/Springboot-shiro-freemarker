package com.zjh.tomato.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class MenuTree implements Comparable<MenuTree> {


    private Integer menuId;

    private String text;

    private Integer parentId;

    private String menuType;

    private String href;

    private String perms;

    private Integer sort;

    private Integer status;

    private List<MenuTree> nodes = new ArrayList<MenuTree>();




    @Override
    public int compareTo(MenuTree o) {
        return this.sort  -o.getSort();
    }
}
