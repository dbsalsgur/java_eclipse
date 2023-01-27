package Servlet_example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInclude
 */
public class ServletInclude extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInclude() {
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
		
		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = null;
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("★ 서울 지역 관련 정보 ★ <br/>");
		dispatcher = context.getRequestDispatcher("/ServletForward_Seoul");
		dispatcher.include(request, response);
		out.println("<br/><br/>");
		out.println("★ 대구 지역 관련 정보 ★ <br/>");
		dispatcher = context.getRequestDispatcher("/ServletForward_Daegu");
		dispatcher.include(request, response);
		out.println("</body></html>");
		out.close();
	}

}
