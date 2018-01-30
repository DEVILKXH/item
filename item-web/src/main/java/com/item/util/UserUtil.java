package com.item.util;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.entity.SysLoginLog;
import com.item.entity.Users;
import com.item.service.SysLoginLogService;
import com.item.service.UsersService;


@Component
public class UserUtil {

	@Autowired
	private SysLoginLogService sysLoginLogService;
	
	@Autowired
	private UsersService userService;
	
	public void addLoginLog(HttpServletRequest request,HttpSession session,Users user){
		SysLoginLog log = new SysLoginLog();
		log.setLogId(UUID.randomUUID().toString());
		log.setIp(request.getRemoteAddr());
		log.setUserId(user.getUserName());
		log.setUserName(user.getUserName());
		log.setSessionId(session.getId());
		log.setState("online");
		log.setLastestLoginTime(new Date());
		log.setCreateTime(new Date());
		session.setAttribute("logId", log.getLogId());
		sysLoginLogService.insertSelective(log);
	}
	
	public Users getUser(HttpSession session){
		Users user = (Users) session.getAttribute("user");
		if(null == user){
			return  null;
		}
		return userService.selectByPrimaryKey(user.getId());
	}
	
	public void setUser(HttpSession session,Users user){
		session.setAttribute("user", user);
	}
}
