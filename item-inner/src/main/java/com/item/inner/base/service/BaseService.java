package com.item.inner.base.service;

import java.util.List;

import com.item.base.entity.Example;


public interface BaseService<E> {
	
	int countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(String uuid);

    int insert(E record);

    int insertSelective(E record);

    List<E> selectByExample(Example example);

    E selectByPrimaryKey(String uuid);

    int updateByExampleSelective(E record, Example example);

    int updateByExample(E record, Example example);

    int updateByPrimaryKeySelective(E record);

    int updateByPrimaryKey(E record);
}
