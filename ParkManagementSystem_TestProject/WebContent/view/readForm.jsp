<%@page import="jdbc.JdbcUtil"%>
<%@page import="ticket.model.Ticket"%>
<%@page import="jdbc.connection.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<link rel="stylesheet" href="/style.css">
<body>
<div id="wrap">
	<header>
		<div align="center">
			<h1>주차관리 프로그램 ver 1.0</h1>
		</div>
	</header>
	<div id="menus">
		<a href="/regist.do">[정기권등록]</a>&nbsp;&nbsp;&nbsp;&nbsp; 
		<a href="/view/readForm.jsp">[정기권조회]</a>&nbsp;&nbsp;&nbsp;&nbsp; 
		<a>[주차차량입,출고]</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a>[주차현황조회]</a>
	</div>
	<section>
		<div align="center">
			<h1 style="padding-bottom:50px">정기권 조회</h1>
			<table>
				<tr>
					<td>정기권번호</td>
					<td>차량번호</td>
					<td>차주전화</td>
					<td>주차등급</td>
					<td>정기권상태</td>
					<td>주차시작일</td>
					<td>주차종료일</td>
				</tr>
				<%
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;

				try {
					conn = ConnectionProvider.getConnection();
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select * from ticket_tbl_01");
					while (rs.next()) {
				%>
				<tr>
					<td><%=rs.getInt("tno")%></td>
					<td><%=rs.getString("carno")%></td>
					<td><%=rs.getString("phone")%></td>
					<td><%=rs.getString("grade")%></td>
					<td><%=rs.getString("tstat")%></td>
					<td><%=rs.getDate("startdate")%></td>
					<td><%=rs.getDate("enddate")%></td>
				</tr>
				<%
				}
				} catch (SQLException e) {
				e.printStackTrace();
				} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(stmt);
				JdbcUtil.close(conn);
				}
				%>
			</table>
		</div>
	</section>
	<footer>
		<div align="center">
			<p>
				<span>MHCorp. Copyright@2023 All rights reserved </span>
			</p>
		</div>
	</footer>
</div>
</body>
</html>