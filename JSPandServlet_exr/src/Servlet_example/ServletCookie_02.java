package Servlet_example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCookie_02
 */
public class ServletCookie_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCookie_02() {
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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String id_rem = request.getParameter("id_rem");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body><center><h2>");
		out.println(id+"("+pw+")님 로그인 성공!!!");
		out.println("</h2></center></body></html>");
		
		if (id_rem != null && id_rem.equals("chk")) {
			Cookie id_cookie = new Cookie("id", java.net.URLEncoder.encode(id, "utf-8"));
			id_cookie.setComment("아이디 저장");
			id_cookie.setPath("/");
			id_cookie.setMaxAge(60 * 60 * 24 * 365);
			response.addCookie(id_cookie);
		}

	}

}
