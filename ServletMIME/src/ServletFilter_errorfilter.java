import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class ServletFilter_errorfilter implements Filter {
	
	public void init(FilterConfig fc) throws ServletException {}
	
    public ServletFilter_errorfilter() {  }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String id = request.getParameter("ID");
		System.out.println(id);
		if(id == null || id.trim().length() == 0) {
			HttpServletResponse h_response = (HttpServletResponse)response;
			h_response.sendRedirect("ServletFilter_errorpage.html");
		}
		chain.doFilter(request, response);
	}


}
