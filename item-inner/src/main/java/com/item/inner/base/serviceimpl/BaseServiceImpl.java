package com.item.inner.base.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.item.base.entity.Example;
import com.item.inner.base.mapper.BaseMapper;
import com.item.inner.base.service.BaseService;


public class BaseServiceImpl<E,K extends BaseMapper<E>> implements BaseService<E>{

	@Autowired
	private K mapper;
	
	@Override
	public int countByExample(Example example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(Example example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String uuid) {
		return mapper.deleteByPrimaryKey(uuid);
	}

	@Override
	public int insert(E record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(E record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<E> selectByExample(Example example) {
		return mapper.selectByExample(example);
	}

	@Override
	public E selectByPrimaryKey(String uuid) {
		return mapper.selectByPrimaryKey(uuid);
	}

	@Override
	public int updateByExampleSelective(E record, Example example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(E record, Example example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(E record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(E record) {
		return mapper.updateByPrimaryKey(record);
	}

}
