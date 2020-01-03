<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cart Notification</title>
		<link href="./style/style.css" rel="stylesheet" type="text/css"/>
		
	</head>
	<body>
		<header>
			<span id="hh">truYum</span>
			<img src="./images/truyum-logo-light.png" id="img1"/>
			<a href="ShowCart" id="link2">Cart</a>
			<a href="menu-item-list-customer.html" id="link">Menu</a>
		</header>
		<div id="dv">
			<h2>Cart</h2><br><br>
			<p ><h4 class="saved1">Item removed from Cart successfully<h4></p>
			<table>
				<tr>
					<th class="lh" >Name</th>
					<th class="ct">Free Delivery</th>
					<th class="rh">Price</th>
					<th class="ct"></th>
				</tr>
				<c:forEach items = "${menuItemList}" var ="menu">
				<tr>
					<td class="lh">${menu.name}</td>
					<td class="ct">${menu.freeDelivery}</td>
					<td class="rh">Rs.${menu.price}</td>
					<td class="ct"><a href="RemoveCart?menuItemId=${menu.id}"  id="ref">Delete</a></td>
				</tr>
	
				<tr>
					<td class="lh"></td>
					<td class="ct"><b>Total</b></td>
					<td class="rh"><b>Rs.${total}</b></td>
					<td class="ct"></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<footer>
			<h6>copyright &copy 2019</h6>
		</footer>
	</body>
</html>