package servlet;

import pojo.PageInfo;

import service.impl.LogServiceImpl;
import service.MyLogService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/log")
public class LogServlet extends HttpServlet {
    //private LogService logService= new LogServiceImpl();
    private MyLogService logService= new LogServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNumber,pageSize;
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String pageNumberReq = req.getParameter("pageNumber");
        String pageSizeReq = req.getParameter("pageSize");
        if(pageNumberReq == null){
            pageNumber = 1;
        }else {
            pageNumber = Integer.parseInt(pageNumberReq);
        }
        if(pageSizeReq == null){
            pageSize = 2;
        }else {
            pageSize  = Integer.parseInt(pageSizeReq);
        }
        System.out.println("Log servlet -> " + pageNumber + ", "+pageSize);
        PageInfo currentPageInfo = logService.showPage(pageNumber,pageSize);
        req.setAttribute("currentPageInfo",currentPageInfo);
        req.getRequestDispatcher("/log.jsp").forward(req,resp);
    }
}
