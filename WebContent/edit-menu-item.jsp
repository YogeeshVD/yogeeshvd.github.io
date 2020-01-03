<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<title>Edit Menu Item</title>
		<link href="./style/style.css" rel="stylesheet" type="text/css"/>
		<script src="./js/script.js" type="text/javascript"></script>
	</head>
	<body>
		<header>
			<span id="hh">truYum</span>
			<img src="./images/truyum-logo-light.png" id="img1"/>
			<a href="ShowMenuItemListAdmin" id="link">Menu</a>
		</header>
		<div id="dv">
		<form  name="form1" method="post" action="EditMenuItem?menuItemId=${menuItem.id}" onsubmit="return validate()">
			<h2>Edit Menu Item</h2>
			<table>
				<tr>
					<td colspan="4">Name</td>
				</tr>
				<tr>
					<td colspan="4"><input type="text" name="name" size="80" value="${menuItem.name}"/></td>
				</tr>
				<tr>
					<td>Price (Rs.)</td>
					<td>Active</td>
					<td>Date of Launch</td>
					<td>Category</td>
				</tr>
				<tr>
					<td><input id="align" type="text" name="price" value="${menuItem.price}" }/></td>
					<td>
						<label><input type="radio" name="active" value="${menuItem.active?'Yes':'No'}" <c:if test="${menuItem.active eq 'Yes'}"></c:if> checked/>Yes</label>
						<label><input type="radio" name="active" value="${menuItem.active?'Yes':'No'}" <c:if test="${menuItem.active eq 'No'}"></c:if> checked/>No</label>
					</td>
					<td>
					<fmt:formatDate value="${menuItem.dateOfLaunch}" pattern="dd/MM/yyyy" var="dol"></fmt:formatDate>
					<input type="text" name="dateOfLaunch" placeholder="DD/MM/YYYY" value = "${dol}"></td>
					<td>
						<select name="category">
						<option value="${menuItem.category}">Main Course</option>
						<option value="${menuItem.category}">Starters</option>
						<option value="${menuItem.category}">Main Course</option>
						<option value="${menuItem.category}">Dessert</option>
						<option value="${menuItem.category}">Drinks</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="checkbox" name="freeDelivery" value="true" <c:if test="${menuItem.freeDelivery }"> checked</c:if> /> Free Delivery
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input class="bx" type="submit" value="Save" id="sub"/>
						
					</td>
				</tr>
			</table>
		</form>
		</div>
		<footer>
			<h6>copyright &copy 2019</h6>
		</footer>
		
		
	</body>
</html>
					
			