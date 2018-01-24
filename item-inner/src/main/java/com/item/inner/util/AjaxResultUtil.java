package com.item.inner.util;

import org.springframework.stereotype.Component;

import com.item.inner.dto.AjaxResult;


@Component
public class AjaxResultUtil {

	public <T> AjaxResult<T> getAjaxResult(Class<T> T){
		return new AjaxResult<T>();
	}
}
