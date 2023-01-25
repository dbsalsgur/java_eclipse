package jsp_exr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_exr.models.MyMemberDTO;
import jsp_exr.models.MyMemberDAO;

public class MyMemberProcess extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		MyMemberDTO dto = new MyMemberDTO();
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddr(addr);
		MyMemberDAO dao = new MyMemberDAO();
		boolean bool = dao.registerMember(dto);
		if (bool) {
			response.sendRedirect("./MySuccess.html");
		}
	}
	
}
