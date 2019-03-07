<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tpl" uri="http://cse.net.vn/tpl" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<tpl:bg title="Detail Order">
	<jsp:attribute name="content">
		<fmt:setLocale value="vi-VN"/>
		<!--  you code here -->
		<!-- Begin code here -->
		<table class="table table-bordered">
			<tr class="title">
				<th>Full Name</th>
				<th>Telephone</th>
				<th>Dated</th>
				<th>Total</th>
				<th>Detail</th>
			</tr>
			<!--  You code here -->
			<c:forEach var="p" items="${bill}">
				<tr>
					<td>${p.fullName}</td>
					<td>${p.tel}</td>
					<td>${p.dated}</td>
					<td class="right">83000</td>
					<th>
						<a href="${pageContext.request.contextPath}/order/detail.html?id=${p.id}">
						<img src="${pageContext.request.contextPath}/images/detail.png">
						</a>
					</th>
				</tr>
			</c:forEach>
		</table>
		<!-- end code here -->
		
	</jsp:attribute>
</tpl:bg>