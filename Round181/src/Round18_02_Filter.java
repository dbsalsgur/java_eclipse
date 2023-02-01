import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Round18_02_Filter implements Filter {
	public void init(FilterConfig fc)throws ServletException {}
	
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)throws IOException,ServletException{
		//HttpSession h_session=h_request.getSession();
		//Object id_obj=h_session.getAttribute();
		String id=request.getParameter("ID");
		if(id==null || id.trim().length()==0) {
			HttpServletResponse h_response = (HttpServletResponse)response;
			h_response.sendRedirect("Round18_02_Servlet_Error.html");
		}
		chain.doFilter(request, response);
	}
	public void destroy() {}
}
