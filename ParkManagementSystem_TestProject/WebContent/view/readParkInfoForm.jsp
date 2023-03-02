<%@page import="jdbc.JdbcUtil"%>
<%@page import="ticket.model.Ticket"%>
<%@page import="jdbc.connection.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%!
	String dateFormat(Timestamp date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(date == null) {
			return "";
		}
		String strDate = format.format(date);
		
		return strDate;
	}

	String stringFormat(String str) {
		if(str.equals("Y"))
			return "연회원";
		if(str.equals("M"))
			return "월회원";
		if(str.equals("D"))
			return "일일회원";
		if(str.equals("O"))
			return "출고";
		if(str.equals("I"))
			return "입고";
		else 
			return "";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차 입출고 현황 조회</title>
<style type="text/css">
	#wth {
		width : 150px;
	}
</style>
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
		<a class="menu" href="/regist.do">[정기권등록]</a>
		<a class="menu" href="/view/readTicketForm.jsp">[정기권조회]</a> 
		<a class="menu" href="/view/infoForm.jsp">[주차차량입,출고]</a>
		<a class="menu" href="/view/readParkInfoForm.jsp">[주차현황조회]</a>
	</div>
	<section>
		<div align="center">
			<h1 style="padding-bottom:50px">정기권 조회</h1>
			<table>
				<tr>
					<td id="wth">주차번호</td>
					<td id="wth">차량번호</td>
					<td id="wth">주차등급</td>
					<td id="wth">상태</td>
					<td width="200">입고일시</td>
					<td width="200">출고일시</td>
				</tr>
				<%
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				try {
					conn = ConnectionProvider.getConnection();
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select * from park_info_tbl");
					
					while (rs.next()) {
				%>
				<tr>
					<td><%=rs.getInt("parkno")%></td>
					<td><%=rs.getString("carno")%></td>
					<td><%=stringFormat(rs.getString("grade"))%></td>
					<td><%=stringFormat(rs.getString("tstat"))%></td>
					<td><%=dateFormat(rs.getTimestamp("indate"))%></td>
					<td><%=dateFormat(rs.getTimestamp("outdate"))%></td>
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