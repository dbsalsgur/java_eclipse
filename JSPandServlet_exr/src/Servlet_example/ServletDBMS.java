package Servlet_example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDBMS
 */
public class ServletDBMS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDBMS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String subject = request.getParameter("subject");
		String author = request.getParameter("author");
		String contents= request.getParameter("contents");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body><center><h3>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		String url = "jdbc:mysql://localhost:3306/servletdbms";
		String id = "root";
		String pw = "";
		String query=  "insert into servletdbms_exr values (null, ? , ? , ?)";
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, subject);
			pstmt.setString(2, author);
			pstmt.setString(3, contents);
			int res = pstmt.executeUpdate();
			if(res > 0)
				out.println("Success Save!!");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			out.println("SQL Process Erro :" + e.getMessage());
		}
		out.println("</h3></center></body?</html>");

	}

}
