package com.zjh.tomato.dao;

import com.zjh.tomato.model.SysActionLog;
import com.zjh.tomato.model.SysActionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysActionLogMapper {
    int countByExample(SysActionLogExample example);

    int deleteByExample(SysActionLogExample example);

    int deleteByPrimaryKey(Integer actionId);

    int insert(SysActionLog record);

    int insertSelective(SysActionLog record);

    List<SysActionLog> selectByExample(SysActionLogExample example);

    SysActionLog selectByPrimaryKey(Integer actionId);

    int updateByExampleSelective(@Param("record") SysActionLog record, @Param("example") SysActionLogExample example);

    int updateByExample(@Param("record") SysActionLog record, @Param("example") SysActionLogExample example);

    int updateByPrimaryKeySelective(SysActionLog record);

    int updateByPrimaryKey(SysActionLog record);

    List<SysActionLog> getAllActionLog();
}