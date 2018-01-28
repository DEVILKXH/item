package com.item.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.item.entity.Template;
import com.item.inner.base.mapper.BaseMapper;
import com.item.inner.dto.Page;

public interface TemplateMapper extends BaseMapper<Template>{
	public List<Template> getTemplatePage(@Param("template") Template template, @Param("page")Page<Template> page);

	public int count(Template template);
}