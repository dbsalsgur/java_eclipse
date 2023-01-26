package Servlet_example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletGetParameter
 */
public class ServletGetParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGetParameter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Enumeration names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String)names.nextElement();
			String value = request.getParameter(name);
//			String[] values = request.getParameterValues(name);
			out.println(name+" : "+ value);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Enumeration names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String)names.nextElement();
			String value = request.getParameter(name);
			String[] values = request.getParameterValues(name);
			out.println(name+" : "+value);
		}
	}

}
