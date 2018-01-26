/**
 * @author kexiaohong
 * @version 1.0 2017年12月16日
 *
 */
package com.item.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.base.entity.Example;
import com.item.entity.SysLoginLog;
import com.item.mapper.SysLoginLogMapper;
import com.item.service.SysLoginLogService;


@Service("sysLoginLogService")
public class SysLoginLogServiceImpl implements SysLoginLogService{

	@Autowired
	private SysLoginLogMapper sysLoginLogMapper;
	
	@Override
	public int countByExample(Example example) {
		return sysLoginLogMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(Example example) {
		return sysLoginLogMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String logId) {
		return sysLoginLogMapper.deleteByPrimaryKey(logId);
	}

	@Override
	public int insert(SysLoginLog record) {
		return sysLoginLogMapper.insert(record);
	}

	@Override
	public int insertSelective(SysLoginLog record) {
		return sysLoginLogMapper.insertSelective(record);
	}

	@Override
	public List<SysLoginLog> selectByExample(Example example) {
		return sysLoginLogMapper.selectByExample(example);
	}

	@Override
	public SysLoginLog selectByPrimaryKey(String logId) {
		return sysLoginLogMapper.selectByPrimaryKey(logId);
	}

	@Override
	public int updateByExampleSelective(SysLoginLog record, Example example) {
		return sysLoginLogMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysLoginLog record, Example example) {
		return sysLoginLogMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysLoginLog record) {
		return sysLoginLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysLoginLog record) {
		return sysLoginLogMapper.updateByPrimaryKey(record);
	}

}
