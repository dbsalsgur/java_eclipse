<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
	String tel = (String)session.getAttribute("tel");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width='370' border='1'>
		<colgroup span="3" align="center">
		<tr>
			<th width='100'>이름 </th>
			<th width='120'>아이디 </th>
			<th width='150'>전화번호 </th>
		</tr>
		<tr>
			<td><%= name %> </td>
			<td><%= id %> </td>
			<td><%= tel  %> </td>
		</tr>
	</table>
</body>
</html>