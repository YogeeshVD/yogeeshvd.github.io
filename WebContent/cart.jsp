<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cart</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<header> <span id="hh">truYum</span> <img
		src="./images/truyum-logo-light.png" id="img1" /> <a href="cart.jsp"
		id="link2">Cart</a> <a href="menu-item-list-customer.jsp" id="link">Menu</a>
	</header>
	<div id="dv">
		<h2>Cart</h2>
		<h4 class="saved1">${msgg }</h4>
				<table>
					<tr>
						<th class="lh">Name</th>
						<th class="lh">Free Delivery</th>
						<th class="rh">Price</th>
						<th class="ct"></th>
					</tr>

					<c:forEach items="${menuItemListCustomer}" var="menu">
						<tr>
							<th class="lh">${menu.name}</th>
							<th class="lh">${menu.freeDelivery}</th>
							<th class="rh">${menu.price}</th>
							<td id="ct"><a href="RemoveCart?menuItemId=${menu.id}">Delete</a></td>
						</tr>
					</c:forEach>
					<th class="lh"></th>
					<th class="lh" >Total</th>
					<th class="rh">${total}</th>
					<th class="ct"></th>
				</table>
	</div>
	<footer>
	<h6>copyright &copy 2019</h6>
	</footer>
</body>
</html>