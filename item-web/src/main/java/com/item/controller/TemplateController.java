package com.item.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.entity.Template;
import com.item.inner.base.service.BaseService;
import com.item.inner.dto.Page;
import com.item.service.TemplateService;

@Controller
@RequestMapping(value = "/item/template")
public class TemplateController extends BaseController<BaseService<Template>, Template>{

	@Autowired
	private TemplateService templateService;
	
	@RequestMapping(value = "/index.do")
	private String index(Model model,Template template,HttpSession session){
		model.addAttribute("page", templateService.getTemplatePage(template, new Page<Template>()));
		return "template/list";
	}

	@RequestMapping(value = "/getTemplatePage.do")
	private String getTemplatePage(Template template, Page<Template> page,Model model,HttpSession session){
		model.addAttribute("page", templateService.getTemplatePage(template, page));
		model.addAttribute("model", template);
		return "template/list";
	}
}
