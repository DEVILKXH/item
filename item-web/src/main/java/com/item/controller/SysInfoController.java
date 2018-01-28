package com.item.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.entity.SysInfo;
import com.item.entity.Users;
import com.item.inner.base.service.BaseService;
import com.item.inner.dto.Page;
import com.item.service.SysInfoService;
import com.item.util.UserUtil;
import com.item.utils.StringUtil;

@Controller
@RequestMapping(value = "/item/sysInfo")
public class SysInfoController extends BaseController<BaseService<SysInfo>, SysInfo>{
	
	@Autowired
	private SysInfoService sysInfoService;
	
	@Autowired
	private UserUtil userUtil;
	
	@RequestMapping(value = "/index.do")
	private String index(Model model,SysInfo sysInfo,HttpSession session){
		Users user = userUtil.getUser(session);
		sysInfo.setDocCreatorId(user.getId());
		if(StringUtil.isNull(sysInfo.getReadFlag())){
			sysInfo.setReadFlag("0");
		}
		model.addAttribute("page", sysInfoService.getSysInfoPage(new SysInfo(), new Page<SysInfo>()));
		return "sysInfo/list";
	}

	@RequestMapping(value = "/getSysInfoPage.do")
	private String getSysInfoPage(SysInfo sysInfo, Page<SysInfo> page,Model model,HttpSession session){
		Users user = userUtil.getUser(session);
		sysInfo.setDocCreatorId(user.getId());
		if(StringUtil.isNull(sysInfo.getReadFlag())){
			sysInfo.setReadFlag("0");
		}
		model.addAttribute("page", sysInfoService.getSysInfoPage(sysInfo, page));
		model.addAttribute("model", sysInfo);
		return "sysInfo/list";
	}
	
	@RequestMapping(value = "/view.do")
	@Override
	public String view(String id,Model model){
		SysInfo sysInfo = sysInfoService.selectByPrimaryKey(id);
		sysInfo.setReadFlag("1");
		sysInfoService.updateByPrimaryKeySelective(sysInfo);
		model.addAttribute("model", sysInfo);
		return "sysInfo/view";
	}
}
