package com.zjh.tomato.service.impl;

import com.zjh.tomato.dao.SysActionLogMapper;
import com.zjh.tomato.dao.SysLoginLogMapper;
import com.zjh.tomato.model.SysActionLog;
import com.zjh.tomato.model.SysLoginLog;
import com.zjh.tomato.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日志Service实现类
 *
 * @author zjh on 2019/10/9
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysActionLogMapper actionLogMapper;

    @Autowired
    private SysLoginLogMapper loginLogMapper;
    @Override
    public void addActionLog(SysActionLog actionLog) {
        actionLogMapper.insertSelective(actionLog);
    }

    @Override
    public void addLoginLog(SysLoginLog loginLog) {
        loginLogMapper.insertSelective(loginLog);
    }

    @Override
    public List<SysActionLog> getAllActionLog() {
        return actionLogMapper.getAllActionLog();
    }

    @Override
    public List<SysLoginLog> getAllLoginLog() {
        return loginLogMapper.getAllLoginLog();
    }

    @Override
    public void deleteActionLogById(Integer actionId) {
        actionLogMapper.deleteByPrimaryKey(actionId);
    }

    @Override
    public void deleteLoginLogById(Integer loginId) {
        loginLogMapper.deleteByPrimaryKey(loginId);
    }


}