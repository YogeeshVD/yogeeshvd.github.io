package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String[] args) {
		try {
			System.out.println("-----ADMIN-----");
			testGetMenuitemListAdmin();
			System.out.println("-----CUSTOMER-----");
			testGetMenuItemListCustomer();
			System.out.println("-----Modified-----");
			testModifyMenuItem();
			testGetMenuitemListAdmin();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testGetMenuitemListAdmin() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem x : menuItemList)
			System.out.println(x);

	}

	public static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getCustomerListCustomer();
		for (MenuItem x : menuItemList)
			System.out.println(x);
	}
	
	public static void testModifyMenuItem() throws ParseException {
		MenuItem mod = new MenuItem(1, "Ice Cream", 69.00f, true, DateUtil.convertToDate("25/03/2018"), "Main Course",
				false);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItem(mod);
	}

}
