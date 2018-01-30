/**
 * @author kexiaohong
 * @version 1.0 2018年1月29日
 *
 */
package com.item.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.entity.ItemStorage;
import com.item.entity.Users;
import com.item.inner.base.service.BaseService;
import com.item.inner.dto.Page;
import com.item.service.ItemStorageService;
import com.item.util.UserUtil;

@Controller
@RequestMapping(value = "/item/storage")
public class ItemStorageController extends BaseController<BaseService<ItemStorage>, ItemStorage>{

	@Autowired
	private ItemStorageService storageService;
	
	@Autowired
	private UserUtil userUtil;
	
	@RequestMapping(value = "/index.do")
	private String index(Model model){
		model.addAttribute("page", storageService.getStoragePage(new ItemStorage(), new Page<ItemStorage>()));
		return "storage/list";
	}

	@RequestMapping(value = "/add.do")
	public String add(Model model,ItemStorage storage,HttpSession session){
		Users user = userUtil.getUser(session);
		storage.setDocCreateId(user.getId());
		storage.setDocCreateName(user.getUserName());
		storage.setDocCreateTime(new Date());
		model.addAttribute("model", storage);
		model.addAttribute("method", "add");
		return "storage/edit";
	}
	
	@RequestMapping(value = "/getStoragePage.do")
	private String getSysInfoPage(ItemStorage storage, Page<ItemStorage> page,Model model){
		model.addAttribute("page", storageService.getStoragePage(storage, page));
		model.addAttribute("model", storage);
		return "storage/list";
	}
	
	@RequestMapping(value = "/selectStoragePage.do")
	private String selectStoragePage(ItemStorage storage, Page<ItemStorage> page,Model model){
		storage.setItemStaus("1");
		model.addAttribute("page", storageService.getStoragePage(storage, page));
		model.addAttribute("model", storage);
		return "storage/dialogList";
	}
	
	
}
