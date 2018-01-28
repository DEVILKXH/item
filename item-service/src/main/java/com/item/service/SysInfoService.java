package com.item.service;

import com.item.entity.SysInfo;
import com.item.inner.base.service.BaseService;
import com.item.inner.dto.Page;

public interface SysInfoService extends BaseService<SysInfo>{

	public Page<SysInfo> getSysInfoPage(SysInfo sysInfo,Page<SysInfo> page);

	public int count(SysInfo sysInfo);
}
