package Servlet_example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


public class ServletDBMS_dbcp extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String subject = request.getParameter("subject");
		String author = request.getParameter("author");
		String contents= request.getParameter("contents");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body><center><h3>");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query=  "insert into servletdbms_exr values (null, ? , ? , ?)";
		
		try {
			Context context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/myconn");
			con = source.getConnection();
		} catch (Exception e) {	}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, subject);
			pstmt.setString(2, author);
			pstmt.setString(3, contents);
			int res = pstmt.executeUpdate();
			if(res > 0)
				out.println("Success Save!!");
			pstmt.close();
			con.close();
		} catch (Exception e) {
			out.println("SQL Process Error :" + e.getMessage());
		}
		out.println("</h3></center></body?</html>");
	}

}
