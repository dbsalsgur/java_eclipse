import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Round18_01_Filter implements Filter {
	public void init(FilterConfig fc) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest h_request=(HttpServletRequest)request;
		String method=h_request.getMethod();
		if(method.equalsIgnoreCase("POST")) {
			request.setCharacterEncoding("utf-8");
		}
		chain.doFilter(request, response);
	}
	public void destroy() {}
}
