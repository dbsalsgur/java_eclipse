

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Round18_04_Servlet_Listener
 *
 */
@WebListener
public class Round18_04_Servlet_Listener implements ServletContextListener, ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public Round18_04_Servlet_Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	System.out.println("Context 영역에 값이 추가 되었습니다");
    	System.out.println("added = "+scae.getName()+" : "+scae.getValue());
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	System.out.println("Context 영역에 값이 삭제되었습니다.");
    	System.out.println("removed = "+scae.getName()+" : "+scae.getValue());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("ServletContext 가 소멸되었습니다.");
    	System.out.println("dest context = "+sce.getServletContext());
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	System.out.println("Context 영역에 값이 변경 되었습니다");
    	System.out.println("replaced = "+scae.getName()+" : "+scae.getValue());
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("ServletContext 가 초기화 되었습니다.");
    	System.out.println("init contex = "+sce.getServletContext());	
    }
	
}
