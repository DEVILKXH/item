package com.item.inner.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.base.entity.Example;


public interface BaseMapper<E> {
	int countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(String uuid);

    int insert(E record);

    int insertSelective(E record);

    List<E> selectByExample(Example example);

    E selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") E record, @Param("example") Example example);

    int updateByExample(@Param("record") E record, @Param("example") Example example);

    int updateByPrimaryKeySelective(E record);

    int updateByPrimaryKey(E record);
}
