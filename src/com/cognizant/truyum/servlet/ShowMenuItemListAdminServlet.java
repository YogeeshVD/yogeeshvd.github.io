package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@WebServlet({ "/ShowMenuItemListAdminServlet", "/ShowMenuItemListAdmin" })
public class ShowMenuItemListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowMenuItemListAdminServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			MenuItemDaoCollectionImpl menuItemDao = new MenuItemDaoCollectionImpl();
			List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
			request.setAttribute("menuItemList", menuItemList);
			RequestDispatcher rd = request.getRequestDispatcher("menu-item-list-admin.jsp");
			rd.forward(request, response);
			
		} catch (ParseException e) {
		
			
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
