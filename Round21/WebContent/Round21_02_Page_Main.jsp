<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.getParameter("utf-8");

	String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
	<div align = "center">
		<h2>방문을 환영합니다.</h2>
		<%
			pageContext.include("Round21_02_Page_Main_Sub.jsp", true);
		%>
	</div>
</body>
</html>