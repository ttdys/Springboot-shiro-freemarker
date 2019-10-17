package com.zjh.tomato.service;

import com.zjh.tomato.model.SysRole;

import java.util.List;

/**
 * @author zjh on  2019/10/9
 */
public interface SysRoleService {
    /**
     *  获取指定用户的角色
     * @param username
     * @return
     */
    List<SysRole> getSysRoleByUsername(String username);

    /**
     *  删除置定role
     * @param roleId
     */
    void deleteRole(Integer roleId);

    /**
     * 更新指定的role
     * @param sysRole
     */
    void updateRole(SysRole sysRole);

    /**
     *  增加role
     * @param sysRole
     */
    void addRole(SysRole sysRole);

    /**
     * 获取所有的role
     * @return
     */
    List<SysRole> getAllRole();

   void  insertRoleMenu(Integer roleId, Integer menuId);
}
