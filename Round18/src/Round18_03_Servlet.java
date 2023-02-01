

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Round18_03_Servlet
 */
public class Round18_03_Servlet extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Round18_03_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		
		String co_name = context.getInitParameter("co_name");
		String co_tel = context.getInitParameter("co_tel");
		String admin_email = context.getInitParameter("admin_email");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<style type='text/css'>");
		out.println(".n_bo { border:none }");
		out.println("</style>");
		out.println("</head><body><center>");
		out.println("회사상호 : ");
		out.println("<input type='text' class='n_bo' value='" + co_name +"'/><br/>");
		out.println("회사전번 : ");
		out.println("<input type='text' class='n_bo' value='" + co_tel +"'/><br/>");
		out.println("대표메일 : ");
		out.println("<input type='text' class='n_bo' value='" + admin_email +"'/><br/>");
		out.println("</center></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
