package com.item.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.entity.SysInfo;
import com.item.inner.base.mapper.BaseMapper;
import com.item.inner.dto.Page;

public interface SysInfoMapper extends BaseMapper<SysInfo>{
	public List<SysInfo> getSysInfoPage(@Param("sysInfo") SysInfo sysInfo, @Param("page")Page<SysInfo> page);

	public int count(SysInfo sysInfo);
}