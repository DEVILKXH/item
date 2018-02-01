package com.item.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.entity.ItemMain;
import com.item.entity.MainTemplate;
import com.item.inner.base.mapper.BaseMapper;
import com.item.inner.dto.Page;

public interface ItemMainMapper extends BaseMapper<ItemMain>{
	public List<ItemMain> getMainPage(@Param("main") ItemMain main, @Param("page")Page<ItemMain> page);

	public List<ItemMain> getMyDocMainPage(@Param("main") ItemMain main, @Param("page")Page<ItemMain> page, @Param("list")List<MainTemplate> temp);

	public int count(ItemMain main);
	
	public int myDocCount(@Param("main")ItemMain main,@Param("list")List<MainTemplate> temp);
}