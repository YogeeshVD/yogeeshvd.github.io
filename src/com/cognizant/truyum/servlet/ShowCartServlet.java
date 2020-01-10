package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@WebServlet({ "/ShowCartServlet", "/ShowCart" })
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowCartServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CartDaoCollectionImpl CartDao = new CartDaoCollectionImpl();
		List<MenuItem> menuItemListCustomer;
		try {
			menuItemListCustomer = CartDao.getAllCartItems(1);
			for (MenuItem menuItem : menuItemListCustomer)
				System.out.println(menuItem);
			double total = 0;
			for (MenuItem menuItem : menuItemListCustomer) {
				total =total + menuItem.getPrice();
			}
			request.setAttribute("menuItemListCustomer", menuItemListCustomer);
			request.setAttribute("total", total);
			
			RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
		} catch (CartEmptyException e) {
			RequestDispatcher rd = request.getRequestDispatcher("cart-empty.jsp");
			rd.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
