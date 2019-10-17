package com.zjh.tomato.service;

import com.zjh.tomato.model.SysUser;

import java.util.List;

/**
 * @author zjh on  2019/10/9
 */
public interface SysUserService {
    SysUser getSysUserByUsername(String username);

    void deleteUser(Integer userId);

    void updateUser(SysUser sysUser);

    void addUser(SysUser sysUser);

    List<SysUser> getAllUser();
}
