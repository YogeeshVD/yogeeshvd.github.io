package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private static HashMap<Long, Cart> Usercart;

	public CartDaoCollectionImpl() {
		if (Usercart == null) {
			Usercart = new HashMap<>();
			Usercart.put(1l, new Cart());
		}
	}

	@Override
	public void addCartItem(long UserId, long menuItemId) {
		try {
			MenuItemDaoCollectionImpl menuDao = new MenuItemDaoCollectionImpl();
			MenuItem menuitem = menuDao.getMenuItem(menuItemId);
			if (Usercart.containsKey(UserId)) {
				Cart cart = Usercart.get(UserId);
				cart.getMenuItemList().add(menuitem);
			} else {
				Cart cart = new Cart();
				cart.getMenuItemList().add(menuitem);
				Usercart.put(UserId, cart);
			}

		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) {
		List<MenuItem> menuItemList = Usercart.get(userId).getMenuItemList();
		Cart cart = Usercart.get(userId);
		double total = 0.0;
		if (cart == null || menuItemList==null || menuItemList.isEmpty()) {
			try {
				throw new CartEmptyException();
			} catch (CartEmptyException e) {

				e.printStackTrace();
			}
		} else {
			for (MenuItem menuItem : menuItemList) {
				total += menuItem.getPrice();
			}
		}
		cart.setTotal(total);
		return menuItemList;
	}

	

	@Override
	public void removecartItem(long userId, long menuItemId) {
		List<MenuItem> menuItemList = Usercart.get(userId).getMenuItemList();
		for(MenuItem t : menuItemList) {
			if (t.getId() == menuItemId) {
				menuItemList.remove(t);
				break;
			}

		}

	}
}