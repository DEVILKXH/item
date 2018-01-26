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
			Field []fields = c.getFields();
			for(Field field : fields){
				if(field.isAnnotationPresent(com.item.base.entity.annotation.Example.class)){
					Method m = getGetMethod(field.getName(),c);
					criteria.andEqualTo(field.getName(),m.invoke(record));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return example;
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
