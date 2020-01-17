package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			MenuItemDao menuDao = new MenuItemDaoSqlImpl();
			MenuItem menuItem = menuDao.getMenuItem(menuItemId);
			String sql = "insert into cart (ct_us_id, ct_pr_id) values (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			int rs = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> list = new ArrayList<>();
		Cart cart = new Cart();
		String sql = "select m.me_id,m.me_name, m.me_price, m.me_active, m.me_date_of_launch, m.me_category, m.me_free_delivery from menu_item m join cart c on m.me_id = c.ct_pr_id where c.ct_us_id =? ";
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MenuItem mi = new MenuItem();
				mi.setId(rs.getInt("me_id"));
				mi.setName(rs.getString("me_name"));
				mi.setPrice(rs.getFloat("me_price"));
				mi.setActive(rs.getString("me_active").equalsIgnoreCase("Yes"));
				mi.setDateOfLaunch(rs.getDate("me_date_of_launch"));
				mi.setCategory(rs.getString("me_category"));
				mi.setFreeDelivery(rs.getString("me_free_delivery").equalsIgnoreCase("Yes"));
				cart.getMenuItemList().add(mi);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cart.getMenuItemList();
	}

	@Override
	public void removecartItem(long userId, long menuItemId) throws CartEmptyException {
		Connection con = ConnectionHandler.getConnection();
		try {
			MenuItemDao menuDao = new MenuItemDaoSqlImpl();
			MenuItem menuItem = menuDao.getMenuItem(menuItemId);
			String sql = "Delete from cart (ct_us_id,ct_pr_id) values (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			int rs = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
	}
}
