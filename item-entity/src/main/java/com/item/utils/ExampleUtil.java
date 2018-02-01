/**
 * @author kexiaohong
 * @version 1.0 2018年1月26日
 *
 */
package com.item.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

import com.item.base.entity.Example;
import com.item.base.entity.Example.Criteria;

@Component
public class ExampleUtil {
	
	public <E> Example getExample(E record){
		Example example = new Example();
		try {
			Criteria criteria = example.createCriteria();
			Class<?> c = record.getClass();
			Field []fields = c.getDeclaredFields();
			for(Field field : fields){
				if(field.isAnnotationPresent(com.item.base.entity.annotation.Example.class)){
					Method m = getGetMethod(field.getName(),c);
					Object obj = m.invoke(record);
					
					if(null == obj){
						continue;
					}
					if(obj.getClass() == String.class && StringUtil.isNotNull((String) obj)){
						criteria.andEqualTo(getParam(field.getName()),obj);
					}else if(null != obj.getClass()){
						criteria.andEqualTo(field.getName(),obj);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return example;
	}

	private String getParam(String name) {
		String s = "";
		for(int i = 0; i < name.length(); i++){
			char c = name.charAt(i);
			if(c < 97){
				s += "_";
			}
			s += c;
		}
		return s;
	}

	private Method getGetMethod(String name,Class<?> c) {
		Method method = null ;
		try {
			char ch = name.charAt(0);
			String methonName = "get"+Character.toUpperCase(ch)+name.substring(1);
			method = c.getMethod(methonName);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return method;
	}
	
}
