package Servlet_example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRequestArea_02
 */
public class ServletRequestArea_02 extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRequestArea_02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data1 = (String)request.getAttribute("data1");
		ArrayList data2 = (ArrayList)request.getAttribute("data2");
		String data3 = request.getParameter("data3");
		String data4 = request.getParameter("data4");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("data1 = "+data1+"<br/>");
		out.println("data2 = ");
		for (int i = 0; i < data2.size(); ++i) {
			out.println(data2.get(i)+ " ");
		}
		out.println("<br/>");
		out.println("data3 = "+data3 +"<br/>");
		out.println("data4 = "+data4 +"<br/>");
		
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
