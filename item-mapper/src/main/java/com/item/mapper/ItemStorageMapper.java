package com.item.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.entity.ItemStorage;
import com.item.inner.base.mapper.BaseMapper;
import com.item.inner.dto.Page;

public interface ItemStorageMapper extends BaseMapper<ItemStorage>{
	public List<ItemStorage> getStoragePage(@Param("storage") ItemStorage storage, @Param("page")Page<ItemStorage> page);

	public int count(ItemStorage storage);
}