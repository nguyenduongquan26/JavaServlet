<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tpl" uri="http://cse.net.vn/tpl" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<tpl:bg title="Detail Order">
	<jsp:attribute name="content">
		<a href="${pageContext.request.contextPath}/order.html">Manage Order</a>
		<fmt:setLocale value="vi-VN"/>
		
		<!--  you code here -->
		<!-- Begin code here -->
		<p>
			<b>Full Name</b>
			${bill.fullName}
		</p>
		<p>
			<b>Telephone</b>
			${bill.tel }
		</p>
		<p>
			<b>Order Dated</b>
			${bill.dated}
		</p>
		<p>
			<b>Total</b>
			
		</p>
		<table class="table table-bordered">
		
			<thead>
				<tr class="title">
					<th>Image</th>
					<th>Item Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>	
			<c:forEach var="o" items="${details}">
				<tr>
					<td><img width="100" src="${pageContext.request.contextPath}/images/${o.imageUrl}"></td>
					<td>${o.itemName}</td>
					<td class="right">${o.price} VNĐ</td>
					<td class="right">${o.quantity}</td>
					<td class="right">${o.price*o.quantity} VNĐ</td>
				</tr>
			</c:forEach>	
			</tbody>
			<tfoot>
				<tr><th colspan="4">Total</th><td class="right">${bill.total}</td></tr>
			</tfoot>
			
		</table>
		<!-- end code -->
	</jsp:attribute>
</tpl:bg>