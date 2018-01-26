package com.item.service.impl;

import org.springframework.stereotype.Service;

import com.item.entity.Users;
import com.item.inner.base.serviceimpl.BaseServiceImpl;
import com.item.mapper.UsersMapper;
import com.item.service.UsersService;

@Service
public class UsersServiceImpl extends BaseServiceImpl<Users,UsersMapper> implements UsersService{

}
