package com.cognizant.truyum.dao;

import java.util.List;
import java.text.ParseException;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpTest {

	public static void main(String... arg) throws ParseException {
		try {
			testgetAllCartItems();
		} catch (Exception e) {
			System.out.println("Cart is Empty");
		}
		System.out.println("-------Add Cart Items------");
		testAddCartItem();
		System.out.println("-------All Cart Items--------");
		testgetAllCartItems();
		System.out.println("------Cart Items After Removed-------");
		testRemoveCartItem();
		System.out.println("------All Cart Items After Removed------");
		testgetAllCartItems();
	}

	private static void testAddCartItem() {
		CartDaoCollectionImpl CartDao = new CartDaoCollectionImpl();
		CartDao.addCartItem(1, 2);
		CartDao.addCartItem(1, 3);
		CartDao.addCartItem(1, 4);
		CartDao.addCartItem(1, 5);
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

	private static void testgetAllCartItems() {
		CartDaoCollectionImpl CartDao = new CartDaoCollectionImpl();
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
		CartDaoCollectionImpl CartDao = new CartDaoCollectionImpl();

		try {
			CartDao.removecartItem(1, 2);
		} catch (CartEmptyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

}
