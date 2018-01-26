package com.item.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.item.base.entity.Example;
import com.item.entity.Users;
import com.item.inner.dto.AjaxResult;
import com.item.service.UsersService;
import com.item.util.UserUtil;
import com.item.utils.StringUtil;

@Controller
public class LoginController{

	@Autowired
	private UsersService userService;
	
	
	@Autowired
	private UserUtil userUtil;
	
	@RequestMapping("/index.do")
	public String index(HttpSession session,Model model){
		Users user = userUtil.getUser(session);
		if(null == user){
			return "login";
		}
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpSession session){
		Users user = userUtil.getUser(session);
		if(null == user){
			return "login";
		}
		return "index";
	}
	
	@RequestMapping(value = "/doLogin.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<Users> doLogin(@RequestBody Users user,HttpServletRequest request,HttpSession session){
		AjaxResult<Users> result = new AjaxResult<Users>();
		if(StringUtil.isNull(user.getUserName()) || StringUtil.isNull(user.getPassWord())){
			result.setStatus("404");
			result.setMessage("帐号或密码不能为空");
			return result;
		}
		Example example = new Example();
		example.createCriteria().andEqualTo("USER_NAME", user.getUserName());
		List<Users> users = userService.selectByExample(example);
		if(null == users || users.size() == 0){
			result.setStatus("404");
			result.setMessage("帐号不存在");
			return result;
		}
		Users _user = users.get(0);
		String password = _user.getPassWord();
		if(password.equals(user.getPassWord())){
			result.setStatus("200");
			result.setMessage("登录成功");
			session.setAttribute("user", _user);
			userUtil.setUser(session, user);
		}else{
			result.setStatus("500");
			result.setMessage("账号或密码错误");
		}
		return result;
	}
	
	@RequestMapping(value = "/logout.do")
	public String doLogout(HttpSession session){
		session.invalidate();
		return "login";
	}
	
	@RequestMapping(value = "/register.do")
	public String register(HttpSession session){
		session.invalidate();
		return "register";
	}
	
	@RequestMapping(value = "/doRegister.do",method = {RequestMethod.POST})
	@ResponseBody
	public AjaxResult<Users> doRegister(@RequestBody Users user,HttpServletRequest request,HttpSession session){
		AjaxResult<Users> result = new AjaxResult<Users>();
		if(StringUtil.isNull(user.getUserName()) || StringUtil.isNull(user.getPassWord()) || StringUtil.isNull(user.getPassword2())){
			result.setStatus("404");
			result.setMessage("帐号或密码不能为空");
			return result;
		}
		Example example = new Example();
		example.createCriteria().andEqualTo("USER_NAME", user.getUserName());
		List<Users> users = userService.selectByExample(example);
		if(null != users && users.size() > 0){
			result.setStatus("500");
			result.setMessage("帐号已存在");
			return result;
		}
		if(user.getPassWord().length() < 6){
			result.setStatus("500");
			result.setMessage("密码长度不小于6为");
			return result;
		}
		if(!user.getPassWord().equals(user.getPassword2())){
			result.setStatus("500");
			result.setMessage("两次密码不一样");
			return result;
		}
		example.createCriteria().andEqualTo("USER_NAME", user.getUserName());
		List<Users> list = userService.selectByExample(example);
		if(null != list && list.size() > 0){
			result.setStatus("500");
			result.setMessage("该用户名已存在");
			return result;
		}
		user.setId(UUID.randomUUID().toString());
		int flag = userService.insertSelective(user);
		if(flag == 0){
			result.setStatus("500");
			result.setMessage("插入失败");
		}else{
			result.setStatus("200");
			result.setMessage("插入成功");
			result.setObject(userService.selectByPrimaryKey(user.getId()));
		}
		userUtil.addLoginLog(request, session, user);
		userUtil.setUser(session, user);
		return result;
	}
	
	@RequestMapping(value = "/init.do")
	@ResponseBody
	public AjaxResult<String> init(){
		AjaxResult<String> result = new AjaxResult<String>();
		//user
		List<Users> users = new ArrayList<Users>();
		for(int i = 0; i < 100; i++){
			Users user = new Users();
			user.setId(UUID.randomUUID().toString());
			user.setUserName(getRandom());
			user.setPassWord("123456");
			userService.insertSelective(user);
			users.add(user);
		}
		
		result.setStatus("200");
		result.setMessage("初始化数据成功");
		return result;
	}

	private String getRandom() {
		String str = "QWERTYUIOPASDFGHJKLZXCVBNM";
		char []rand = new char[6];
		Random random = new Random();
		for(int i = 0; i < rand.length; i++){
			int index = random.nextInt(25);
			char c = str.charAt(index);
			rand[i] = c;
		}
		return String.valueOf(rand);
	}
}
