<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String tel = request.getParameter("tel");
	
	Connection conn = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdbms", "root", "");
		String query = "insert into user_tb values (null, ?, ?, ?, ?)";
		System.out.println(query);
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, name);
		pstmt.setString(2, id);
		pstmt.setString(3, pw);
		pstmt.setString(4, tel);
		pstmt.executeUpdate();
		pstmt.close();
	} catch(Exception ex) {
		ex.printStackTrace();
		response.sendRedirect("Round21_02_Page_Register.jsp");
		return;
	} finally {
		if(conn != null) conn.close();
		conn = null;
	}
	session.setAttribute("id", id);
	response.sendRedirect("Round21_02_Page_Login.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>