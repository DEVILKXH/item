/**
 * @author kexiaohong
 * @version 1.0 2017年12月16日
 *
 */
package com.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.item.entity.Users;
import com.item.inner.tree.entity.TreeNode;
import com.item.service.UsersService;


@Controller
@RequestMapping(value = "/item/user")
public class UserController extends BaseController<UsersService,Users>{

	@Autowired
	private UsersService userService;
	
	@RequestMapping(value = "index.do")
	public String index(){
		return "user/index";
	}
	
	
	@RequestMapping(value = "/getUserTree.do")
	@ResponseBody
	public List<TreeNode> getUserTree(Users user) throws Exception{
		return null;
	}
}
