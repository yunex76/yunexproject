package com.kyoborealco.util.test;

import java.lang.reflect.Field;

/**
 * 클래스 내부의 attribute 체크 Class
 * @author 남윤혁
 * @since 2011-12-01
 */
public class ClassInnerAttributeCheck {

	/**
	 * 클래스 내부의 attribute 체크
	 * @param object
	 * @param fieldName
	 * @param checkValue
	 * @return
	 * @throws Exception
	 * @throws NoSuchFieldException
	 */
	public static boolean check(Object object, String fieldName, Object checkValue) throws Exception, NoSuchFieldException {
		
		Field field = object.getClass().getDeclaredField(fieldName);
		if ( field == null ) {
			throw new NoSuchFieldException(object.getClass().getName() + " Class에 '" + fieldName + "' 속성이 없습니다.");
		}
		field.setAccessible(true);
		Object value = field.get(object);
		
		if ( value == null ) {
			return false;
		}
		
		if (checkValue.getClass() != value.getClass()) {
			return false;
		}

		if ( !checkValue.equals(value) ) {
			return false;
		}

		return true;
	}

}
