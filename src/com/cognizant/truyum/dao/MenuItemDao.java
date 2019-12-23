package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	public List<MenuItem> getMenuItemListAdmin();

	public List<MenuItem> getCustomerListCustomer();

	void modifyMenuItem(MenuItem menuItem);

	MenuItem getMenuItem(long menuItemId);

}
