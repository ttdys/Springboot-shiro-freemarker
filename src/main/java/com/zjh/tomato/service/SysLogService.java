package com.zjh.tomato.service;

import com.zjh.tomato.model.SysActionLog;
import com.zjh.tomato.model.SysLoginLog;

import java.util.List;

/**
 * @author zjh on  2019/10/9
 */
public interface SysLogService {

    /**
     *
     * @param actionLog
     */
    void addActionLog(SysActionLog actionLog);
    void addLoginLog(SysLoginLog loginLog);
    public List<SysActionLog> getAllActionLog();
    public List<SysLoginLog> getAllLoginLog();

    void deleteActionLogById(Integer actionId);

    void deleteLoginLogById(Integer loginId);
}
