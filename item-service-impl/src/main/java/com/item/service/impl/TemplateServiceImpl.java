package com.item.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.entity.Template;
import com.item.inner.base.mapper.BaseMapper;
import com.item.inner.base.serviceimpl.BaseServiceImpl;
import com.item.inner.dto.Page;
import com.item.inner.util.PageUtil;
import com.item.mapper.TemplateMapper;
import com.item.service.TemplateService;

@Service
public class TemplateServiceImpl extends BaseServiceImpl<Template, BaseMapper<Template>> implements TemplateService{

	@Autowired
	private TemplateMapper templateMapper;
	
	@Override
	public Page<Template> getTemplatePage(Template template, Page<Template> page) {
		page.setStartAndEnd();
		List<Template> users = templateMapper.getTemplatePage(template, page);
		int count = templateMapper.count(template);
		page.setList(users);
		page.setCount(count);
		page.setPageResultCount(count);
		PageUtil.getInterval(page);
		return page;
	}

	@Override
	public int count(Template template) {
		return templateMapper.count(template);
	}

}
