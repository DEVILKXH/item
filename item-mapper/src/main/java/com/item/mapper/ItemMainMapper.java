package com.item.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.entity.ItemMain;
import com.item.inner.base.mapper.BaseMapper;
import com.item.inner.dto.Page;

public interface ItemMainMapper extends BaseMapper<ItemMain>{
	public List<ItemMain> getMainPage(@Param("main") ItemMain main, @Param("page")Page<ItemMain> page);

	public int count(ItemMain main);
}