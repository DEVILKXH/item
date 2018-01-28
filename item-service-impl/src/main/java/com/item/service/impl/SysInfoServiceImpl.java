package com.item.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.entity.SysInfo;
import com.item.inner.base.mapper.BaseMapper;
import com.item.inner.base.serviceimpl.BaseServiceImpl;
import com.item.inner.dto.Page;
import com.item.inner.util.PageUtil;
import com.item.mapper.SysInfoMapper;
import com.item.service.SysInfoService;

@Service
public class SysInfoServiceImpl extends BaseServiceImpl<SysInfo, BaseMapper<SysInfo>> implements SysInfoService{

	@Autowired
	private SysInfoMapper sysInfoMapper;
	
	@Override
	public Page<SysInfo> getSysInfoPage(SysInfo sysInfo, Page<SysInfo> page) {
		page.setStartAndEnd();
		List<SysInfo> users = sysInfoMapper.getSysInfoPage(sysInfo, page);
		int count = sysInfoMapper.count(sysInfo);
		page.setList(users);
		page.setCount(count);
		page.setPageResultCount(count);
		PageUtil.getInterval(page);
		return page;
	}

	@Override
	public int count(SysInfo sysInfo) {
		return sysInfoMapper.count(sysInfo);
	}

}
