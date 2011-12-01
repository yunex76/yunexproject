package com.kyoborealco.util.test;

import java.lang.reflect.Field;

/**
 * Ŭ���� ������ attribute üũ Class
 * @author ������
 * @since 2011-12-01
 */
public class ClassInnerAttributeCheck {

	/**
	 * Ŭ���� ������ attribute üũ
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
			throw new NoSuchFieldException(object.getClass().getName() + " Class�� '" + fieldName + "' �Ӽ��� �����ϴ�.");
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
