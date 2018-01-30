/**
 * @author kexiaohong
 * @version 1.0 2018年1月30日
 *
 */
package com.item.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.entity.ItemMain;
import com.item.inner.base.mapper.BaseMapper;
import com.item.inner.base.serviceimpl.BaseServiceImpl;
import com.item.inner.dto.Page;
import com.item.inner.util.PageUtil;
import com.item.mapper.ItemMainMapper;
import com.item.service.ItemMainService;

@Service
public class ItemMainServiceImpl extends BaseServiceImpl<ItemMain, BaseMapper<ItemMain>> implements ItemMainService{

	@Autowired
	private ItemMainMapper itemMainMapper;
	
	@Override
	public Page<ItemMain> getMainPage(ItemMain main, Page<ItemMain> page) {
		page.setStartAndEnd();
		List<ItemMain> users = itemMainMapper.getMainPage(main, page);
		int count = itemMainMapper.count(main);
		page.setList(users);
		page.setCount(count);
		page.setPageResultCount(count);
		PageUtil.getInterval(page);
		return page;
	}

	@Override
	public int count(ItemMain main) {
		return itemMainMapper.count(main);
	}

}
