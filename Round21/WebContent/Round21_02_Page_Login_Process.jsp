<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*"%>

<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = "", tel = "";
	
	Connection conn = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdbms", "root", "");
		String query = "select * from user_tb where id = ? and pw = ?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			name = rs.getString("name");
			tel = rs.getString("tel");
		} else throw new Exception();
		rs.close();
		pstmt.close();
	} catch(Exception ex) {
		response.sendRedirect("Round21_02_Page_Register.jsp");
		return;
	} finally {
		if(conn != null) conn.close();
		conn = null;
	}
	
	session.setAttribute("name", name);
	session.setAttribute("id", id);
	session.setAttribute("tel", tel);
	pageContext.forward("Round21_02_Page_Main.jsp");
	
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