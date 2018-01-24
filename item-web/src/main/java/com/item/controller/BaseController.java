package com.item.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.item.base.entity.BaseEntity;
import com.item.entity.Users;
import com.item.entity.UsersExample;
import com.item.inner.base.service.BaseService;
import com.item.inner.dto.AjaxResult;
import com.item.service.UsersService;



public class BaseController<S extends BaseService<T,E>, T, E> {
	
	@Autowired
	private S service;
	
	@RequestMapping(value = "/insertSelective.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<E> insertSelective(E record){
		AjaxResult<E> ajax = new AjaxResult<E>();
		if(record.getClass()  == Users.class){
			Users user = (Users)record;
			UsersExample example = new UsersExample();
			example.createCriteria().andUserNameEqualTo(user.getUserName());
			UsersService userService = (UsersService) service;
			List<Users> list = userService.selectByExample(example);
			if(null != list && list.size() > 0){
				ajax.setStatus("500");
				ajax.setMessage("该用户名已存在");
				return ajax;
			}
		}
		BaseEntity baseEntity = (BaseEntity)record;
		baseEntity.setUuid(UUID.randomUUID().toString());
		int flag = service.insertSelective(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("插入失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("插入成功");
			ajax.setObject(service.selectByPrimaryKey(baseEntity.getUuid()));
		}
		return ajax;
	}
	
	@RequestMapping(value = "/insert.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<E> insert(E record){
		AjaxResult<E> ajax = new AjaxResult<E>();
		if(record.getClass()  == Users.class){
			Users user = (Users)record;
			UsersExample example = new UsersExample();
			example.createCriteria().andUserNameEqualTo(user.getUserName());
			UsersService userService = (UsersService) service;
			List<Users> list = userService.selectByExample(example);
			if(null != list && list.size() > 0){
				ajax.setStatus("500");
				ajax.setMessage("该用户名已存在");
				return ajax;
			}
		}
		BaseEntity baseEntity = (BaseEntity)record;
		baseEntity.setUuid(UUID.randomUUID().toString());
		int flag = service.insert(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("插入失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("插入成功");
			ajax.setObject(service.selectByPrimaryKey(baseEntity.getUuid()));
		}
		return ajax;
	}
	
	@RequestMapping(value = "/selectOne.do",method={RequestMethod.POST})
	@ResponseBody
	public E selectOne(E record){
		T example =  getExample(record);
		List<E> records = service.selectByExample(example);
		if(null == records || records.size() == 0 ){
			return null;
		}
		return records.get(0);
	}
	
	@RequestMapping(value = "/updateSelective.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<E> updateSelective(E record){
		BaseEntity baseEntity = (BaseEntity) record;
		AjaxResult<E> ajax = new AjaxResult<E>();
		int flag = service.updateByPrimaryKeySelective(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("更新失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("更新成功");
			ajax.setObject(service.selectByPrimaryKey(baseEntity.getUuid()));
		}
		return ajax;
	}
	
	@RequestMapping(value = "/update.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<E> update(E record){
		BaseEntity baseEntity = (BaseEntity) record;
		AjaxResult<E> ajax = new AjaxResult<E>();
		int flag = service.updateByPrimaryKey(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("更新失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("更新成功");
			ajax.setObject(service.selectByPrimaryKey(baseEntity.getUuid()));
		}
		return ajax;
	}
	
	@RequestMapping(value = "/delete.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<E> delete(E record){
		AjaxResult<E> ajax = new AjaxResult<E>();
		BaseEntity baseEntity = (BaseEntity) record;
		int flag = service.deleteByPrimaryKey(baseEntity.getUuid());
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("删除失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("删除成功");
		}
		return ajax;
	}
	
	public T getExample(E record){
		return null;
	}
}
