<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Menu Item List Admin</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header> <span id="hh">truYum</span> <img
		src="./images/truyum-logo-light.png" id="img1" /> <a
		href="ShowMenuItemListAdmin" id="link">Menu</a> </header>
	<div id="dv">
		<h2>Menu Item</h2>
		<br>
		<br>
		<table>
			<tr>
				<th id="lh">Name</th>
				<th id="rh">Price</th>
				<th id="ct">Active</th>
				<th id="ct">Date of launch</th>
				<th id="ct">Category</th>
				<th id="ct">Free Delivery</th>
				<th id="ct">Action</th>
			</tr>

			<c:forEach items="${menuItemList}" var="menu">
				<tr>
					<td id="lh">${menu.name}</td>
					<td id="rh">Rs ${menu.price}</td>
					<td id="ct">${menu.active?'Yes':'No'}</td>
					<td id="ct">${menu.dateOfLaunch}</td>
					<td id="ct">${menu.category}</td>
					<td id="ct">${menu.freeDelivery?'Yes':'No'}</td>
					<td id="ct"><a href="ShowEditMenuItem?menuItemId=${menu.id}" id="ref" target="_blank">Edit</a></td>
			</tr>
			</c:forEach>

		</table>
	</div>
	<footer>
	<h6>Copyright &copy 2019</h6>
	</footer>
</body>
</html>