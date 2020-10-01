package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionAttributeListener, ServletContextListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        ServletContext sc = event.getSession().getServletContext();
        int counter = (Integer) sc.getAttribute("counter");
        if(event.getName().equals("user")) {
            sc.setAttribute("counter", ++counter);
        }
        System.out.println("counter in sessionCreated " +  counter);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        ServletContext sc = event.getSession().getServletContext();
        int counter = (Integer) sc.getAttribute("counter");
        sc.setAttribute("counter",--counter);
        System.out.println("counter in sessionDestroyed " +  counter);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
    //session被创建时，人数自增
/*    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        int counter = (Integer) sc.getAttribute("counter");
        if(se.getSession().getAttribute("user") != null) {
            sc.setAttribute("counter", ++counter);
        }
        System.out.println("counter in sessionCreated " +  counter);
    }*/

    //session被销毁时，人数自减
/*    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        int counter = (Integer) sc.getAttribute("counter");
        sc.setAttribute("counter",--counter);
        System.out.println("counter in sessionDestroyed " +  counter);
    }*/

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("counter",0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
