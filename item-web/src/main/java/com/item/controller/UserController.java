/**
 * @author kexiaohong
 * @version 1.0 2017年12月16日
 *
 */
package com.item.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.item.entity.Users;
import com.item.entity.UsersExample;
import com.item.inner.tree.entity.TreeNode;
import com.item.inner.tree.util.TreeUtil;
import com.item.service.UsersService;


@Controller
@RequestMapping(value = "/item/user")
public class UserController extends BaseController<UsersService,UsersExample,Users>{

	@Autowired
	private UsersService userService;
	
	@RequestMapping(value = "index.do")
	public String index(){
		return "user/index";
	}
	
	
	@RequestMapping(value = "/getUserTree.do")
	@ResponseBody
	public List<TreeNode> getUserTree(Users user) throws Exception{
		List<Users> users = userService.selectByExample(user.getExample());
		if(null == users || users.isEmpty()){
			return new ArrayList<TreeNode>();
		}
		TreeNode temp = new TreeNode();
		temp.setId("uuid");
		temp.setFdName("userName");
		temp.setFdParentId("parentUserId");
		List<TreeNode> tree = TreeUtil.coverToTreeNode(users, temp);
		return tree;
	}
	
	@Override
	public UsersExample getExample(Users user){
		return user.getExample();
	}
}
