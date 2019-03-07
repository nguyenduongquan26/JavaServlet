<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" %>
<%@attribute name="content" required="true" fragment="true"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
<script src="${pageContext.request.contextPath}/js/js.js"></script>
</head>
<body>
<div class="nav">
	<div class="container">
		<div class="brand"><a href="${pageContext.request.contextPath}">Coffee</a></div>
		<div class="nav-right">
			<ul>
				<li>
					<a href="${pageContext.request.contextPath}/order.html">Manager Order</a>
				</li>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
</div>
<div class="page">
	<div class="container">
		<jsp:invoke fragment="content"/>
	</div>
</div>
</body>
</html>
