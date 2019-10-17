package com.zjh.tomato;

import com.zjh.tomato.dao.SysMenuMapper;
import com.zjh.tomato.dao.SysRoleMapper;
import com.zjh.tomato.model.SysMenu;
import com.zjh.tomato.model.SysMenuExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * ceshi
 *
 * @author zjh on 2019/10/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertDataTest {

    @Autowired
    private SysMenuMapper menuMapper;
    @Autowired
    private SysRoleMapper roleMapper;
    /*@Test*/
    public void test() {
        List<SysMenu> admin = menuMapper.selectByExample(new SysMenuExample());
        List<Integer> list = new ArrayList<>();
        admin.forEach(menu->{
            list.add(menu.getMenuId());
        });
        for (Integer integer : list) {
            roleMapper.insertRoleMenu(1,integer);
        }

     /*   list.forEach(i-> {
            roleMapper.insertRoleMenu(1,list.get(i-1));
        });*/
    }
}