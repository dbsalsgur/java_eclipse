package Servlet_example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletSendRedirect
 */
public class ServletSendRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSendRedirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("GET")) {
			response.sendRedirect("ServletSendRedirect_Get_Servlet.html");
			
			return;
		} else if(method.equalsIgnoreCase("POST")) {
			response.sendRedirect("ServletSendRedirect_Post_Servlet.html");
			
			return;
		}
	}
}
