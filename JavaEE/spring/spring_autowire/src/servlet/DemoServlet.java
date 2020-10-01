package servlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import pojo.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    private People people1;
    private People people2;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       WebApplicationContext context =  WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
       people1 = context.getBean("people",People.class);
       people2 = context.getBean("people",People.class);
        System.out.println("people1 " + people1 );
        System.out.println("people2 " + people2 );
    }
}
