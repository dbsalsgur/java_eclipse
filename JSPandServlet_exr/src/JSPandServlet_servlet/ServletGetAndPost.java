package JSPandServlet_servlet;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletGetAndPost
 */
public class ServletGetAndPost extends HttpServlet {
	public void init() {}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGetAndPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String auth_type = request.getAuthType();
		String context_path = request.getContextPath();
		String method = request.getMethod();
		String path_info = request.getPathInfo();
		String path_translated = request.getPathTranslated();
		String query_string = request.getQueryString();
		String remote_user = request.getRemoteUser();
		String requested_sessionid = request.getRequestedSessionId();
		String request_uri = request.getRequestURI();
		StringBuffer request_url = request.getRequestURL();
		String servlet_path = request.getServletPath();
		Principal principal = request.getUserPrincipal();
		
		System.out.println();
		System.out.println("auth_type = "+auth_type);
		System.out.println("context_path = "+context_path);
		System.out.println("method = "+method);
		System.out.println("path_info = "+path_info);
		System.out.println("path_translated = "+path_translated);
		System.out.println("query_string = "+query_string);
		System.out.println("remote_user = "+remote_user);
		System.out.println("requested_sessionid = "+requested_sessionid);
		System.out.println("request_uri = "+request_uri);
		System.out.println("request_url = "+request_url);
		System.out.println("sevlet_path = "+servlet_path);
		System.out.println("principal = "+principal);
		System.out.println();
		
		boolean is_requested_sessionid_from_cookie = request.isRequestedSessionIdFromCookie();
		boolean is_requested_sessionid_from_url = request.isRequestedSessionIdFromURL();
		boolean is_requested_sessionid_valid = request.isRequestedSessionIdValid();
		boolean is_user_in_role = request.isUserInRole("");
		
		System.out.println("is_requested_sessionid_from_cookie = "+is_requested_sessionid_from_cookie);
		System.out.println("is_requested_sessionid_from_url = "+is_requested_sessionid_from_url);
		System.out.println("is_requested_sessionid_valid = "+is_requested_sessionid_valid);
		System.out.println("is_user_in_role = "+is_user_in_role);
		System.out.println();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String auth_type = request.getAuthType();
		String context_path = request.getContextPath();
		String method = request.getMethod();
		String path_info = request.getPathInfo();
		String path_translated = request.getPathTranslated();
		String query_string = request.getQueryString();
		String remote_user = request.getRemoteUser();
		String requested_sessionid = request.getRequestedSessionId();
		String request_uri = request.getRequestURI();
		StringBuffer request_url = request.getRequestURL();
		String servlet_path = request.getServletPath();
		Principal principal = request.getUserPrincipal();
		
		System.out.println();
		System.out.println("auth_type = "+auth_type);
		System.out.println("context_path = "+context_path);
		System.out.println("method = "+method);
		System.out.println("path_info = "+path_info);
		System.out.println("path_translated = "+path_translated);
		System.out.println("query_string = "+query_string);
		System.out.println("remote_user = "+remote_user);
		System.out.println("requested_sessionid = "+requested_sessionid);
		System.out.println("request_uri = "+request_uri);
		System.out.println("request_url = "+request_url);
		System.out.println("sevlet_path = "+servlet_path);
		System.out.println("principal = "+principal);
		System.out.println();
		
		boolean is_requested_sessionid_from_cookie = request.isRequestedSessionIdFromCookie();
		boolean is_requested_sessionid_from_url = request.isRequestedSessionIdFromURL();
		boolean is_requested_sessionid_valid = request.isRequestedSessionIdValid();
		boolean is_user_in_role = request.isUserInRole("");
		
		System.out.println("is_requested_sessionid_from_cookie = "+is_requested_sessionid_from_cookie);
		System.out.println("is_requested_sessionid_from_url = "+is_requested_sessionid_from_url);
		System.out.println("is_requested_sessionid_valid = "+is_requested_sessionid_valid);
		System.out.println("is_user_in_role = "+is_user_in_role);
		System.out.println();
	}
	
	public void destroy() {}

}
