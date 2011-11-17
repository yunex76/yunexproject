package com.yunex.auction.service.objtest;

import java.lang.reflect.Field;
import java.sql.Date;

import org.junit.Test;
import static org.junit.Assert.*;

import com.yunex.auction.service.obj.Item;

public class ItemTest {
	
	private final static String testItemName = "������4S";
	private final static String testItemPurchasingDate = "2011-11-11";
	private final static long testItemPurchasingPrice = 800000L;

	@Test
	public void makeItem() throws Exception {
		Item item = new Item(testItemName, testItemPurchasingDate, testItemPurchasingPrice);
		assertNotNull(item);
		
		assertInnerAttrs(item);	// ���μӼ��� ����
	}

	/**
	 * Item Class�� name�Ӽ��� �����ϴ��� ��ϵ� ���� �´��� Ȯ��
	 */
	private void assertInnerAttrs(Item item) throws SecurityException,
		NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field itemNameField = Item.class.getDeclaredField("name");
		if (itemNameField == null)
			fail("Item Ŭ������ 'name' �Ӽ��� �����ϴ�.");
		
		itemNameField.setAccessible(true);
		Object itemNameValue = itemNameField.get(item);
		assertNotNull(itemNameValue);
		assertTrue(itemNameValue instanceof String);
		assertEquals(testItemName, (String)itemNameValue);
	}
	
}
