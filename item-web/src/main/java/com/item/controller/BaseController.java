package com.item.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.item.base.entity.BaseEntity;
import com.item.base.entity.Example;
import com.item.constant.Constant;
import com.item.entity.Users;
import com.item.inner.base.service.BaseService;
import com.item.service.UsersService;
import com.item.utils.ExampleUtil;



public class BaseController<S extends BaseService<E>, E> {
	
	@Autowired
	private S service;
	
	@Autowired
	private ExampleUtil exampleUtil;
	
	
	@RequestMapping(value = "/view.do")
	public String view(String id,Model model){
		E e = service.selectByPrimaryKey(id);
		if(null == e){
			model.addAttribute("message", "未找到该文档");
			return Constant.FAIL;
		}
		RequestMapping reqm = this.getClass().getAnnotation(RequestMapping.class);
		String[] value = reqm.value();
		int index  = value[0].lastIndexOf("/");
		String moduleName = value[0].substring(index + 1);
		model.addAttribute("model", e);
		model.addAttribute("method", "view");
		return moduleName + "/view";
	}
	
	@RequestMapping(value = "/edit.do")
	public String edit(String id,Model model){
		E e = service.selectByPrimaryKey(id);
		if(null == e){
			model.addAttribute("message", "未找到该文档");
			return Constant.FAIL;
		}
		RequestMapping reqm = this.getClass().getAnnotation(RequestMapping.class);
		String[] value = reqm.value();
		int index  = value[0].lastIndexOf("/");
		String moduleName = value[0].substring(index + 1);
		model.addAttribute("model", e);
		model.addAttribute("method", "edit");
		return moduleName + "/edit";
	}
	
	@RequestMapping(value = "/insertSelective.do",method={RequestMethod.POST})
	public String insertSelective(E record,Model model){
		if(record.getClass()  == Users.class){
			Users user = (Users)record;
			Example example = new Example();
			example.createCriteria().andEqualTo("USER_NAME",user.getUserName());
			UsersService userService = (UsersService) service;
			List<Users> list = userService.selectByExample(example);
			if(null != list && list.size() > 0){
				model.addAttribute("message", "该用户名已存在");
				return Constant.FAIL;
			}
		}
		BaseEntity baseEntity = (BaseEntity)record;
		baseEntity.setId(UUID.randomUUID().toString());
		int flag = service.insertSelective(record);
		if(flag == 0){
			return Constant.FAIL;
		}else{
			return Constant.SUCCESS;
		}
	}
	
	@RequestMapping(value = "/insert.do",method={RequestMethod.POST})
	public String insert(E record, Model model){
		if(record.getClass()  == Users.class){
			Users user = (Users)record;
			Example example = new Example();
			example.createCriteria().andEqualTo("USER_NAME", user.getUserName());
			UsersService userService = (UsersService) service;
			List<Users> list = userService.selectByExample(example);
			if(null != list && list.size() > 0){
				model.addAttribute("message", "该用户名已存在");
				return Constant.FAIL;
			}
		}
		BaseEntity baseEntity = (BaseEntity)record;
		baseEntity.setId(UUID.randomUUID().toString());
		int flag = service.insert(record);
		if(flag == 0){
			return Constant.FAIL;
		}else{
			return Constant.SUCCESS;
		}
	}
	
	@RequestMapping(value = "/selectOne.do",method={RequestMethod.POST})
	@ResponseBody
	public E selectOne(E record){
		Example example =  getExample(record);
		List<E> records = service.selectByExample(example);
		if(null == records || records.size() == 0 ){
			return null;
		}
		return records.get(0);
	}

	@RequestMapping(value = "/updateSelective.do",method={RequestMethod.POST})
	public String updateSelective(E record){
		int flag = service.updateByPrimaryKeySelective(record);
		if(flag == 0){
			return Constant.FAIL;
		}else{
			return Constant.SUCCESS;
		}
	}
	
	@RequestMapping(value = "/update.do",method={RequestMethod.POST})
	public String update(E record){
		int flag = service.updateByPrimaryKey(record);
		if(flag == 0){
			return Constant.FAIL;
		}else{
			return Constant.SUCCESS;
		}
	}
	
	@RequestMapping(value = "/delete.do")
	public String delete(E record){
		BaseEntity baseEntity = (BaseEntity) record;
		int flag = service.deleteByPrimaryKey(baseEntity.getId());
		if(flag == 0){
			return Constant.FAIL;
		}else{
			return Constant.SUCCESS;
		}
	}
	
	public Example getExample(E record) {
		return exampleUtil.getExample(record);
	}
}
