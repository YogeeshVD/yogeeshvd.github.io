package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@WebServlet({ "/RemoveCartServlet", "/RemoveCart" })
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveCartServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDao cartDao = new CartDaoSqlImpl();
		long menuItemId = Long.parseLong(request.getParameter("menuItemId"));
		request.setAttribute("msgg", "Item removed from Cart successfully");
		try {
			cartDao.removecartItem(1, menuItemId);
			RequestDispatcher rd = request.getRequestDispatcher("ShowCart");
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
