<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블 정보 출력!</title>
<script type="text/javascript">
	function check_form() {
		var table_name = myform.table_name.value;
		if(table_name == '') {
			alert('테이블 명은 반드시 입력해야 합니다.');
			myform.table_name.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<h2>테이블 정보 출력!</h2>
	<div align='center'>
		<%
		if(request.getMethod().equalsIgnoreCase("GET")) {
		%>
		<form name='myform' method='post' onSubmit='return check_form()'>
			<table width='340' border='0'>
				<tr>
				<th width='100' align='right'>테이블명 </th>
				<td> <input type='text' name='table_name' size='30'/> </td>
				</tr>
				<tr>
				<th width='100' align='right'>조건절 </th>
				<td> <input type='text' name='table_where' size='30'/> </td>
				</tr>
				<tr>
				<td colspan='2' align='right'> 
					<input type='submit' value='테이블 정보 획득'/> &nbsp;
				</td>
				</tr>
			</table>
		</form>
		<%
		} else if(request.getMethod().equalsIgnoreCase("POST")) {
			String table_name = request.getParameter("table_name");
			String table_where = request.getParameter("table_where");
			if(table_where == null) table_where = "";
		%>
		<form name='myform' method='post' onSubmit='return check_form()'>
			<table width='340' border='0'>
				<tr>
				<th width='100' align='right'>테이블명 </th>
				<td> <input type='text' name='table_name' size='30' value= '<%= table_name %>'/> </td>
				</tr>
				<tr>
				<th width='100' align='right'>조건절 </th>
				<td> <input type='text' name='table_where' size='30' value= '<%= table_where %>'/> </td>
				</tr>
				<tr>
				<td colspan='2' align='right'> 
					<input type='submit' value='테이블 정보 획득'/> &nbsp;
				</td>
				</tr>
			</table>
		</form>
		<% 
			String driver = config.getInitParameter("driver");
			String url = config.getInitParameter("url");
			String user_id = config.getInitParameter("user_id");
			String user_pw = config.getInitParameter("user_pw");
			Connection conn = null;
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user_id, user_pw);
				String query = "select * from " + table_name;
				if(table_where != null && table_where.trim().length() != 0)
					query += " " + table_where;
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery(query);
				ResultSetMetaData rsmd = rs.getMetaData();
		%>
		<table width='600' border='1'>
			<tr>
			<%
				for(int i = 1; i <= rsmd.getColumnCount(); ++i) {
					out.println("<td>" + rsmd.getColumnName(i) + "</td>");
				}
			%>
			</tr>
			<%
				while(rs.next()) {
					out.println("<tr>");
					for(int i = 1; i <= rsmd.getColumnCount(); ++i) {
						if(rsmd.getColumnTypeName(i).equalsIgnoreCase("Date"))
							out.println("<td>" +rs.getDate(i) +"</td>");
						else
							out.println("<td>" +rs.getString(i) +"</td>");
					}
					out.println("</tr>");
				}
			%>
		</table>
		<%
			} catch(Exception ex) {
				out.println("ERROR : "+ex.getMessage() + "<br></br>");
			} finally {
				if(conn != null) conn.close();
				conn = null;
			}
		}
		%>
	</div>
</body>
</html>