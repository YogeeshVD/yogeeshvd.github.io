package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		List<MenuItem> menuItemList = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();
		try {

			String sql = "select me_id,me_name, me_price,me_active,me_date_of_launch, me_category, me_free_delivery from menu_item";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				MenuItem mi = new MenuItem();
				mi.setId(rs.getInt("me_id"));
				mi.setName(rs.getString("me_name"));
				mi.setPrice(rs.getFloat("me_price"));
				mi.setActive(rs.getString("me_active").equalsIgnoreCase("Yes"));
				mi.setDateOfLaunch(rs.getDate("me_date_of_launch"));
				mi.setCategory(rs.getString("me_category"));
				mi.setFreeDelivery(rs.getString("me_free_delivery").equalsIgnoreCase("Yes"));
				menuItemList.add(mi);

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

		return menuItemList;
	}

	@Override
	public List<MenuItem> getCustomerListCustomer() {
		List<MenuItem> customerItem = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();
		try {

			String sql = "select me_id, me_name, me_price,me_active,me_date_of_launch, me_category, me_free_delivery from menu_item where me_active = ? and me_date_of_launch <?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "Yes");
			ps.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
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
				customerItem.add(mi);
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

		return customerItem;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "update menu_item set me_name = ?, me_price = ?, me_active = ?,me_date_of_launch =?,me_category = ?, me_free_delivery=? where me_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			ps.setString(3, menuItem.isActive()?"Yes":"No");
			ps.setDate(4, new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
			ps.setString(5, menuItem.getCategory());
			ps.setString(6, menuItem.isFreeDelivery()?"Yes":"No");
			ps.setLong(7, menuItem.getId());
			int res = ps.executeUpdate();
			System.out.println(res);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public MenuItem getMenuItem(long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		MenuItem mi = new MenuItem();
		try {
			String sql = "select me_id,me_name, me_price,me_active,me_date_of_launch, me_category, me_free_delivery from menu_item where me_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, menuItemId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				mi.setId(rs.getInt("me_id"));
				mi.setName(rs.getString("me_name"));
				mi.setPrice(rs.getFloat("me_price"));
				mi.setActive(rs.getString("me_active").equalsIgnoreCase("Yes"));
				mi.setDateOfLaunch(rs.getDate("me_date_of_launch"));
				mi.setCategory(rs.getString("me_category"));
				mi.setFreeDelivery(rs.getString("me_free_delivery").equalsIgnoreCase("Yes"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mi;
	}

}
