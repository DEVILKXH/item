package com.item.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.entity.SysLoginLog;
import com.item.entity.SysLoginLogExample;

public interface SysLoginLogMapper {
    int countByExample(SysLoginLogExample example);

    int deleteByExample(SysLoginLogExample example);

    int deleteByPrimaryKey(String logId);

    int insert(SysLoginLog record);

    int insertSelective(SysLoginLog record);

    List<SysLoginLog> selectByExample(SysLoginLogExample example);

    SysLoginLog selectByPrimaryKey(String logId);

    int updateByExampleSelective(@Param("record") SysLoginLog record, @Param("example") SysLoginLogExample example);

    int updateByExample(@Param("record") SysLoginLog record, @Param("example") SysLoginLogExample example);

    int updateByPrimaryKeySelective(SysLoginLog record);

    int updateByPrimaryKey(SysLoginLog record);
}