package com.cw.fanshe.validate.domain;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 
 * @Description   实体属性校验工具类
 * @date   2017年9月6日 上午10:33:29
 * @author chenwei
 *
 */
public class ValidateUtils {

	public static void check(Object obj){
		
		if (obj==null) {
			throw new IllegalArgumentException("参数对象为null");
		}
		
		Class<?> clazz= obj.getClass();
		Field[] declaredFields = clazz.getDeclaredFields();
		if (declaredFields!=null && declaredFields.length>0) {
			
			for (int i = 0; i < declaredFields.length; i++) {
				Field field = declaredFields[i];
				
				field.setAccessible(true);
				
				boolean isValidate= field.isAnnotationPresent(Validate.class);
				
				Object fieldVal=null;
				
				if (isValidate) {
					
					Validate annotation = field.getAnnotation(Validate.class);
					boolean notBlank= annotation.notBlank();
			        boolean notNull=annotation.notNull();
					try {
						fieldVal = field.get(obj);
					} catch (Exception e) {
						throw new IllegalArgumentException(e);
					} 
					if (notNull && fieldVal==null) {
						throw new IllegalArgumentException(field.getName() +" is null");
					}
					if (notBlank && fieldVal instanceof String) {
						
						 String fieldStr=(String)fieldVal;
						 int fieldLength=0;
						 if ((fieldLength = fieldStr.length()) == 0) {
							 throw new IllegalArgumentException(field.getName() +" is blank");
				         }else {
							 boolean isBlankFlag=true;
					         for (int j = 0; j < fieldLength; j++) {
					            if (!(Character.isWhitespace(fieldStr.charAt(j)))) {
					            	isBlankFlag=false;
					            }
					         }
					         if (isBlankFlag) {
					        	 throw new IllegalArgumentException(field.getName() +" is blank");
					         }
				         }
						
					}
				}
				
			}
			
		}
	}
	
}
