package com.item.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.item.base.dto.TemplateStep;
import com.item.entity.Template;
import com.item.entity.Users;
import com.item.inner.base.service.BaseService;
import com.item.inner.dto.Page;
import com.item.service.TemplateService;
import com.item.util.UserUtil;
import com.item.utils.ExampleUtil;

@Controller
@RequestMapping(value = "/item/template")
public class TemplateController extends BaseController<BaseService<Template>, Template>{

	@Autowired
	private TemplateService templateService;

	@Autowired
	private UserUtil userUtil;
	
	@Autowired
	private ExampleUtil exampleUtil;
	
	@RequestMapping(value = "/index.do")
	private String index(Model model,Template template,HttpSession session){
		model.addAttribute("page", templateService.getTemplatePage(template, new Page<Template>()));
		return "template/list";
	}

	@RequestMapping(value = "/getTemplatePage.do")
	private String getTemplatePage(String myDoc,Template template, Page<Template> page,Model model,HttpSession session){
		model.addAttribute("page", templateService.getTemplatePage(template, page));
		model.addAttribute("model", template);
		return "template/list";
	}
	
	@RequestMapping(value = "/getTemplateList.do")
	private String getTemplateList(Template template,Model model){
		model.addAttribute("list", templateService.selectByExample(exampleUtil.getExample(template)));
		model.addAttribute("model", template);
		return "template/dialogList";
	}
	
	@RequestMapping(value = "/view.do")
	public String view(String id,Model model){
		Template e = templateService.selectByPrimaryKey(id);
		List<TemplateStep> ti = JSONArray.parseArray(e.getTemplateInfo(), TemplateStep.class);
		model.addAttribute("tStep", ti);
		model.addAttribute("model", e);
		return "template/view";
	}
	
	@RequestMapping(value = "/edit.do")
	public String edit(String id,Model model){
		Template e = templateService.selectByPrimaryKey(id);
		List<TemplateStep> ti = JSONArray.parseArray(e.getTemplateInfo(), TemplateStep.class);
		model.addAttribute("tStep", ti);
		model.addAttribute("model", e);
		return  "template/edit";
	}
	
	@RequestMapping(value = "/add.do")
	public String add(Model model,Template template,HttpSession session){
		Users user = userUtil.getUser(session);
		template.setDocCreatorId(user.getId());
		template.setDocCreatorName(user.getNickName());
		template.setDocCreatime(new Date());
		model.addAttribute("model", template);
		model.addAttribute("method", "add");
		return "template/edit";
	}
}
