package com.item.service;

import com.item.entity.Template;
import com.item.inner.base.service.BaseService;
import com.item.inner.dto.Page;

public interface TemplateService extends BaseService<Template>{
	public Page<Template> getTemplatePage(Template template, Page<Template> page);

	public int count(Template template);
}
