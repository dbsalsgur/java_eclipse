package Servlet_example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletHeader
 */
public class ServletHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHeader() {
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
		String name = request.getParameter("name");
		String[] skils = request.getParameterValues("skil");
		
		Enumeration enu = request.getHeaderNames();
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		while (enu.hasMoreElements()) {
			String header_name = (String)enu.nextElement();
			String header_value = request.getHeader(header_name);
			
			names.add(header_name);
			values.add(header_value);
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		out.println("★ 전달받은 데이터들 ★"+"<br/>");
		out.println("name : "+name+"<br/>");
		for (int i = 0; i < skils.length; ++i) {
			out.println(skils[i]+" ");
		}
		out.println("<br/><br/><br/><br/>");
		out.println("★ 전달받은 헤더 정보들 ★"+"<br/>");
		
		for (int i = 0; i < names.size(); i++) {
			String header_name = (String)(names.get(i));
			String header_value = (String)(values.get(i));
			out.println(header_name+" : ");
			out.println(header_value+"<br/>");
		}
		out.println("</body></html>");
		out.close();
		
	}

}
