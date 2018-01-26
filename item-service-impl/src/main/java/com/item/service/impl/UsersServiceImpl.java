package com.item.service.impl;

import java.util.List;

import javax.swing.plaf.ListUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.entity.Users;
import com.item.inner.base.serviceimpl.BaseServiceImpl;
import com.item.inner.dto.Page;
import com.item.inner.util.PageUtil;
import com.item.mapper.UsersMapper;
import com.item.service.UsersService;

@Service
public class UsersServiceImpl extends BaseServiceImpl<Users,UsersMapper> implements UsersService{

	@Autowired
	private UsersMapper userMapper;
	
	@Override
	public Page<Users> getUserPage(Users user, Page<Users> page) {
		page.setStartAndEnd();
		List<Users> users = userMapper.getUserPage(user, page);
		int count = userMapper.count(user);
		page.setList(users);
		page.setCount(count);
		page.setPageResultCount(count);
		PageUtil.getInterval(page);
		return page;
	}

	@Override
	public int count(Users user) {
		return userMapper.count(user);
	}

	@Override
	public List<Users> getUserList(Users user) {
		return null;
	}

	
}
