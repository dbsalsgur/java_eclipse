package Servlet_example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCookie_01
 */
public class ServletCookie_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCookie_01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = "";
		
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; ++i) {
			String key = cookies[i].getName();
			if (key.equals("id")) {
				id = cookies[i].getValue();
				id = java.net.URLDecoder.decode(id, "utf-8");
			}
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Log In!</title><head>");
		out.println("<body>");
		out.println("<center>");
		
		out.println("<form method='post' action='ServletCookie_02'>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td align='right' width='30%'>아이디 : </td>");
		out.println("<td align='center'><input type='text' name='id' value='" + id + "' size='10'></td>");
		out.println("<td align='center' rowspan='2'><input type='submit' value='로그인'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='right'>비밀번호 : </td>");
		out.println("<td align='center'><input type='password' name='pw' size='9'></td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
