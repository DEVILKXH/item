package com.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.item.service.UsersService;

@Controller(value = "/item/info")
public class InfoController {

	@Autowired
	private UsersService usersService;
	
	public String getUserInfo(String userName){
		usersService.selectByPrimaryKey(userName);
		
		return "";
	}
}
