<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tpl" uri="http://cse.net.vn/tpl" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<tpl:bg title="Coffee">
	<jsp:attribute name="content">
		<fmt:setLocale value="vi-VN"/>
		<div class="col-4">
		
		<table class="table table-bordered">
		<c:forEach var="p" items="${categories}">
			<tr class="title">
					<th colspan="4" class="title">${p.name}</th>
			</tr>
		 	
			<c:forEach var="o" items="${items}">
				<tr>
				<c:choose>
					<c:when test="${o.categoryId==p.id}">
					<td><input value="${o.id}" class="item" name="item" type="checkbox"></td>
					<td><img width="52px" src="${pageContext.request.contextPath}/images/${o.imageUrl}"></td>
					<td>${o.name}</td>
					<td class="right">${o.price}</td>
					</c:when>
				</c:choose>
				</tr>
			</c:forEach>
	</c:forEach>
			</table>
		</div>
		<div class="col-8">
			<div class="box">
				<form method="post" action="${pageContext.request.contextPath}/order.html">
					<p>
						<label>Full Name</label>
						<input class="form-control" type="text" name="fullName" placeholder="Full Name">
					</p>
					<p>
						<label>Telephone</label>
						<input class="form-control" type="tel" name="tel" placeholder="Telephone">
					</p>
					<table class="table table-bordered">
						<thead>
							<tr class="title">
								<th colspan="2">Coffee</th>
								<th>Price</th>
								<th>Quantity</th>
							</tr>
						</thead>
						<tbody id="rs"></tbody>
					</table>
					<p class="center"><button class="btn btn-primary">Order</button></p>
				</form>
			</div>
		</div>
<script type="text/javascript">
$('item').click(function(){
	var tr = this.parent('tr');
	var name = tr.cells[2].text();
	var pri = tr.cells[3].text();
	var image = tr.cells[1].firstChild.src;
	var id = this.val();
	if(this.checked){
		rs.append(String.format('<tr><td><img width="150px" src="{0}"></td><td><input type="hidden" value="{1}" name="itemId"><input type="hidden" value="{4}" name="pri">{2}</td><td class="right">{3}</td><td><input type="number" value="1" name="qty"></td></tr>',image, id, name, pri, pri.replace(/[\.]/g, '')));
	}else{
		rs.remove(document.getElementsByName('itemId').find(id).parent('tr'));
	}
});
</script>
	</jsp:attribute>
</tpl:bg>