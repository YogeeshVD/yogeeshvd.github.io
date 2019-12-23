package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() throws ParseException {
		if (menuItemList == null) {
			menuItemList = new ArrayList<>();
			menuItemList.add(new MenuItem(1, "Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/20017"),
					"Main Course", true));
			menuItemList.add(new MenuItem(2, "Burger", 129.00f, true, DateUtil.convertToDate("23/12/2017"),
					"Main Course", false));
			menuItemList.add(new MenuItem(3, "Pizza", 149.00f, true, DateUtil.convertToDate("21/08/2018"),
					"Main Course", false));
			menuItemList.add(new MenuItem(4, "French Fries", 57.00f, true, DateUtil.convertToDate("02/07/2017"),
					"starters", true));
			menuItemList.add(new MenuItem(5, "Chocolate Brownie", 32.00f, true, DateUtil.convertToDate("02/11/2022"),
					"dessert", true));
		}

	}

	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
	}

	@Override
	public List<MenuItem> getCustomerListCustomer() {
		List<MenuItem> customerItem = new ArrayList<MenuItem>();
		Date today = new Date();
		for (MenuItem x : menuItemList) {
			if (x.isActive() && x.getDateOfLaunch().before(today)) {
				customerItem.add(x);
			}

		}
		return customerItem;

	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		MenuItem x = getMenuItem(menuItem.getId());
		x.setName(menuItem.getName());
		x.setPrice(menuItem.getPrice());
		x.setActive(menuItem.isActive());
		x.setDateOfLaunch(menuItem.getDateOfLaunch());
		x.setCategory(menuItem.getCategory());
		x.setFreeDelivery(menuItem.isFreeDelivery());

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem = null;
		for (MenuItem m : menuItemList)
			if (m.getId() == menuItemId) {
				menuItem = m;
				break;
			}
		return menuItem;
	}

}
