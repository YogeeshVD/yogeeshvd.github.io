package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) {

		testgetAllCartItems();
		System.out.println("------Add to Cart-------");
		testAddCartItem();
		testgetAllCartItems();
		System.out.println("-----Delete From Cart--------");
		testRemoveCartItem();
		testgetAllCartItems();

	}

	private static void testAddCartItem() {
		CartDaoSqlImpl CartDao = new CartDaoSqlImpl();
		CartDao.addCartItem(1, 2);
		CartDao.addCartItem(1, 3);
		CartDao.addCartItem(1, 4);
		CartDao.addCartItem(1, 5);

	}

	private static void testgetAllCartItems() {
		CartDaoSqlImpl CartDao = new CartDaoSqlImpl();
		List<MenuItem> menuItemListCustomer;
		try {
			menuItemListCustomer = CartDao.getAllCartItems(1);

			for (MenuItem menuItem : menuItemListCustomer)
				System.out.println(menuItem);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testRemoveCartItem() {
		CartDaoSqlImpl CartDao = new CartDaoSqlImpl();

		try {
			CartDao.removecartItem(1, 2);
		} catch (CartEmptyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
