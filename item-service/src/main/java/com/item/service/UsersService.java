package com.item.service;

import java.util.List;

import com.item.entity.Users;
import com.item.inner.base.service.BaseService;
import com.item.inner.dto.Page;

public interface UsersService extends BaseService<Users>{
	public Page<Users> getUserPage(Users user, Page<Users> page);
	
	public List<Users> getUserList(Users user);

	public int count(Users user);
}
