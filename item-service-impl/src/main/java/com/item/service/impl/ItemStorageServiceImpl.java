/**
 * @author kexiaohong
 * @version 1.0 2018年1月29日
 *
 */
package com.item.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.entity.ItemStorage;
import com.item.inner.base.mapper.BaseMapper;
import com.item.inner.base.serviceimpl.BaseServiceImpl;
import com.item.inner.dto.Page;
import com.item.inner.util.PageUtil;
import com.item.mapper.ItemStorageMapper;
import com.item.service.ItemStorageService;

@Service
public class ItemStorageServiceImpl extends BaseServiceImpl<ItemStorage, BaseMapper<ItemStorage>> implements ItemStorageService{

	@Autowired
	private ItemStorageMapper itemStorageMapper;
	
	@Override
	public Page<ItemStorage> getStoragePage(ItemStorage storage, Page<ItemStorage> page) {
		page.setStartAndEnd();
		List<ItemStorage> users = itemStorageMapper.getStoragePage(storage, page);
		int count = itemStorageMapper.count(storage);
		page.setList(users);
		page.setCount(count);
		page.setPageResultCount(count);
		PageUtil.getInterval(page);
		return page;
	}

	@Override
	public int count(ItemStorage storage) {
		return itemStorageMapper.count(storage);
	}

}
