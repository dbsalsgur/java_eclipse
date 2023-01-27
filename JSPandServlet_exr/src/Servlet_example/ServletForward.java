package Servlet_example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletForward
 */
public class ServletForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletForward() {
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
		String area = request.getParameter("area");
		
		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = null;
		
		if (area==null) {
			response.sendError(512, "라디오 버튼 체크 오류!!!");
			return;
		} else if(area.equals("서울")){
			dispatcher = context.getRequestDispatcher("/ServletForward_Seoul");
		} else if(area.equals("대구")){
			dispatcher = context.getRequestDispatcher("/ServletForward_Daegu");
		} 
		dispatcher.forward(request, response);
	}

}
