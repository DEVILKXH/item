/**
 * @author kexiaohong
 * @version 1.0 2017年12月16日
 *
 */
package com.item.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.item.constant.Constant;
import com.item.entity.Users;
import com.item.inner.dto.Page;
import com.item.inner.tree.entity.TreeNode;
import com.item.service.UsersService;
import com.item.util.UserUtil;
import com.item.utils.StringUtil;


@Controller
@RequestMapping(value = "/item/user")
public class UserController extends BaseController<UsersService,Users>{

	@Autowired
	private UsersService userService;

	@Autowired
	private UserUtil userUtil;
	
	@RequestMapping("/index.do")
	public String index(HttpSession session,Model model){
		Users user = userUtil.getUser(session);
		if(null == user){
			return Constant.LOGIN;
		}
		model.addAttribute("user", user);
		return Constant.INDEX;
	}
	
	@RequestMapping(value = "/changePassword.do")
	public String changePassword(String id){
		return "user/changePassword";
	}
	
	@RequestMapping(value = "/doChangePassword.do")
	public String doChangePassword(@RequestBody Users user,Model model){
		if(StringUtil.isNull(user.getPassWord()) || StringUtil.isNull(user.getPassword2()) || StringUtil.isNull(user.getPassword3())){
			model.addAttribute("message", "请填写密码");
			return Constant.FAIL;
		}
		if(!user.getPassword2().equals(user.getPassword3())){
			model.addAttribute("message", "两次密码不一样");
			return Constant.FAIL;
		}
		Users _user = userService.selectByPrimaryKey(user.getId());
		if(!_user.getPassWord().equals(user.getPassWord())){
			model.addAttribute("message", "密码错误");
			return Constant.FAIL;
		}
		user.setPassWord(user.getPassword2());
		userService.updateByPrimaryKeySelective(user);
		return Constant.SUCCESS;
	}
	
	@RequestMapping(value = "/view2.do")
	public String view2(String id,HttpServletRequest request){
		return "user/view2";
	}
	
	@RequestMapping(value = "/getUserPage1.do")
	public String getUserPage1(Users user,Page<Users> page,Model model){
		model.addAttribute("page", userService.getUserPage(user, page));
		model.addAttribute("user", user);
		return "user/userList";
	}
	
	@RequestMapping(value = "/getUserPage.do")
	public String getUserPage(Users user,Page<Users> page,Model model){
		model.addAttribute("page", userService.getUserPage(user, page));
		model.addAttribute("user", user);
		return "user/userPage";
	}
	
	@RequestMapping(value = "/getUserList.do")
	public String getUserList(Users user,Model model){
		model.addAttribute("list", userService.getUserList(user));
		return "user/dialogList";
	}
	
	@RequestMapping(value = "/getUserTree.do")
	@ResponseBody
	public List<TreeNode> getUserTree(Users user) throws Exception{
		return null;
	}
	
	@RequestMapping(value = "/add.do")
	public String add(Model model,Users _user,HttpSession session){
		_user.setDocCreateTime(new Date());
		model.addAttribute("model", _user);
		model.addAttribute("method", "add");
		return "user/edit";
	}
}
