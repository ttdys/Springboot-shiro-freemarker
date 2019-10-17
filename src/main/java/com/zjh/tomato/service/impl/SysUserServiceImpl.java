package com.zjh.tomato.service.impl;

import com.zjh.tomato.dao.SysUserMapper;
import com.zjh.tomato.model.SysUser;
import com.zjh.tomato.model.SysUserExample;
import com.zjh.tomato.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户service实现类
 *
 * @author zjh on 2019/10/9
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser getSysUserByUsername(String username) {

        return sysUserMapper.getSysUserByUsername(username);

    }

    @Override
    public void deleteUser(Integer userId) {
        sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void updateUser(SysUser sysUser) {
sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public void addUser(SysUser sysUser) {
sysUserMapper.insertSelective(sysUser);
    }

    @Override
    public List<SysUser> getAllUser() {
        return sysUserMapper.selectByExample(new SysUserExample());
    }
}