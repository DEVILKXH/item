package com.item.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.entity.Users;
import com.item.inner.base.mapper.BaseMapper;
import com.item.inner.dto.Page;

public interface UsersMapper extends BaseMapper<Users>{

	public List<Users> getUserPage(@Param("user") Users user, @Param("page")Page<Users> page);

	public int count(Users user);

	public List<Users> getUserList(Users user);

}