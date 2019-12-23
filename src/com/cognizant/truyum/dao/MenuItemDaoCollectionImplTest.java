package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) {
		try {
			System.out.println("-----ADMIN-----");
			testGetMenuitemListAdmin();
			System.out.println("-----CUSTOMER-----");
			testGetMenuItemListCustomer();
			System.out.println("-----MODIFIED-----");
			testModifyMenuItem();
			testGetMenuitemListAdmin();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testGetMenuitemListAdmin() throws ParseException {
		MenuItemDaoCollectionImpl menuItemDao = new MenuItemDaoCollectionImpl();

		menuItemDao.getMenuItemListAdmin();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem x : menuItemList)
			System.out.println(x);

	}

	public static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDaoCollectionImpl menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.getCustomerListCustomer();
		List<MenuItem> menuItemList = menuItemDao.getCustomerListCustomer();
		for (MenuItem x : menuItemList)
			System.out.println(x);

	}

	public static void testModifyMenuItem() throws ParseException {
		MenuItem mod = new MenuItem(1, "Ice Cream", 69.00f, true, DateUtil.convertToDate("25/03/20018"), "Main Course",
				false);
		MenuItemDaoCollectionImpl menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(mod);
	}

}
