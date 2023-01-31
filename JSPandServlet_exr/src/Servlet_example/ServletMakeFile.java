package Servlet_example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class SevletMakeFile
 */
public class ServletMakeFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMakeFile() {
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
		String age =  request.getParameter("age");
		String school = request.getParameter("school");
		String fileName = request.getParameter("fileName");
		
		ServletContext context = this.getServletContext();
		String path = context.getRealPath("/personInfo");
		File dir = new File(path);
		if(!dir.exists()) dir.mkdir();
		File file = new File(dir, fileName);
		PrintWriter f_out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		
		f_out.println("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body><center><h3>");
		out.println(path+File.separator +fileName + "의 파일에 정보가 저장되었습니다. ");
		out.println("</h3></center></body></html>");
	}

}
