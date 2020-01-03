<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Menu Item List Customer</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header> <span id="hh">truYum</span> <img
		src="./images/truyum-logo-light.png" id="img1" /> <a href="ShowCart""
		id="link2">Cart</a> <a href="ShowMenuItemListCustomer" id="link">Menu</a>
	</header>
	<div id="dv">
		<h2>Menu Item</h2>
		<br> <br>
		<table>
			<tr>
				<th class="lh">Name</th>
				<th class="ct">Free Delivery</th>
				<th class="rh">Price</th>
				<th class="ct">Category</th>
				<th class="ct">Action</th>
			</tr>
			<p><h4 class="saved1">${msg1}<h4>
			<p><h4 class="saved1">${msg3}<h4></p>
		    

							<c:forEach items="${menuItemList}" var="menu">
								<tr>
									<td class="lh">${menu.name}</td>
									<td class="ct">${menu.freeDelivery?'Yes':'No'}</td>
									<td class="rh">Rs.${menu.price}</td>
									<td class= "ct">${menu.category}</td>
									<td class="ct"><a href="AddToCart?menuItemId=${menu.id}">Add
											to Cart</a></td>
								</tr>
							</c:forEach>
		</table>
	</div>
	<footer>
	<h6>copyright &copy 2019</h6>
	</footer>
</body>
</html>