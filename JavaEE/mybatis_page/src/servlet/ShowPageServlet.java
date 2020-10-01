package servlet;

import pojo.PageInfo;
import service.PeopleService;
import service.impl.PeopleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page")
public class ShowPageServlet extends HttpServlet {
    PeopleService service = new PeopleServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageSize,pageNumber;
        if(req.getParameter("pageSize")==null ||req.getParameter("pageSize").equals("")){
            pageSize = 2;
        }else {
            pageSize = Integer.parseInt(req.getParameter("pageSize"));
        }
        if(req.getParameter("pageNumber")==null ||req.getParameter("pageNumber").equals("")) {
            pageNumber = 1;
        }else {
            pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
        }
        PageInfo pageInfo = service.showPage(pageNumber,pageSize);
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
