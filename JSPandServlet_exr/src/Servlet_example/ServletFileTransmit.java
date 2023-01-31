package Servlet_example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletFileTransmit
 */
public class ServletFileTransmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFileTransmit() {
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
		ServletInputStream p_in = request.getInputStream();
		
		response.setContentType("text/html;charset=utf-8");
		ServletOutputStream p_out = response.getOutputStream();
		
		p_out.write("전송된 데이터 출력 시작!!! <br/>".getBytes());
		while (true) {
			int x = p_in.read();
			if(x == -1) break;
			p_out.write((char)x);
		}
		p_out.write("전송된 데이터 출력 끝!!! <br/>".getBytes());
		p_in.close();
		p_out.close();
	
	}

}
