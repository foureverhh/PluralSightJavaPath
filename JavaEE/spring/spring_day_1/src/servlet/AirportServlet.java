package servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.AirportService;
import service.impl.AirportServiceImpl;

import javax.annotation.PostConstruct;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/airport")
public class AirportServlet extends HttpServlet {
    private AirportService airportService;
    @Override
    public void init(ServletConfig config) throws ServletException{
         /*  ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
           airportService = ac.getBean("airportService", AirportServiceImpl.class);*/

        //使用web.xml中的context-param，将spring的applicationContext及web信息都封装在了webApplicationContext中
        super.init(config);
       ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        airportService = context.getBean("airportService", AirportServiceImpl.class);
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
       resp.setCharacterEncoding("utf-8");
       resp.setContentType("text/html;charset=utf-8");
       req.setAttribute("airports",airportService.showAll());
       req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
}
