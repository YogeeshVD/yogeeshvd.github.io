package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@WebServlet({ "/ShowEditMenuItemServlet", "/ShowEditMenuItem" })
public class ShowEditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowEditMenuItemServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
			long id = Long.parseLong(request.getParameter("menuItemId"));
			MenuItem menuItem = menuItemDao.getMenuItem(id);
			request.setAttribute("menuItem", menuItem);
			RequestDispatcher rd = request.getRequestDispatcher("edit-menu-item.jsp");
			rd.forward(request, response);

		} catch (ParseException e) {
	
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

	}

}
