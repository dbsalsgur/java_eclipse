package JSPandServlet_servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRequest
 */
public class ServletRequest extends HttpServlet {
	public void init() {}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRequest() {
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
		doGet(request, response);
		String local_addr = request.getLocalAddr();
		String local_name = request.getLocalName();
		int local_port = request.getLocalPort();
		
		System.out.println();
		System.out.println("local_addr = " +local_addr);
		System.out.println("local_name = " +local_name);
		System.out.println("local_port = " +local_port);
		System.out.println();
		
		String remote_addr = request.getRemoteAddr();
		String remote_host = request.getRemoteHost();
		int remote_port = request.getRemotePort();
		
		System.out.println("remote_addr = "+remote_addr);
		System.out.println("remote_host = "+remote_host);
		System.out.println("remote_port = "+remote_port);
		System.out.println();
		
		int content_length = request.getContentLength();
		String content_type = request.getContentType();
		
		System.out.println("content_length = "+content_length+"bytes");
		System.out.println("content_type = "+content_type);
		System.out.println();
		
		Locale locale = request.getLocale();
		Enumeration locales = request.getLocales();
		
		System.out.println("locale = "+locale);
		while (locales.hasMoreElements()) {
			System.out.println("localse = "+(Locale)locales.nextElement());
		}
		System.out.println();
		
		String protocol = request.getProtocol();
		String scheme = request.getScheme();
		String server_name = request.getServerName();
		int server_port = request.getServerPort();
		boolean secure = request.isSecure();
		
		System.out.println("protocol = "+protocol);
		System.out.println("scheme = "+scheme);
		System.out.println("server_name = "+server_name);
		System.out.println("server_port = "+server_port);
		System.out.println("is_secure = "+secure);
		System.out.println();

	}
	
	public void destroy() {}
	

}
