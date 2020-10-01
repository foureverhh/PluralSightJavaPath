package servlet;

import pojo.Log;
import service.MyLogService;
import service.impl.LogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
    private MyLogService service = new LogServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log log = new Log();
        log.setAccIn(req.getParameter("accIn"));
        log.setAccOut(req.getParameter("accOut"));
        log.setMoney(Double.parseDouble(req.getParameter("money")));
        if(service.ins(log) > 0){
            req.getSession().setAttribute("result","succeed");
            resp.sendRedirect("/open/success.jsp");
        }
        resp.getWriter().write("insert result is" + service.ins(log));
    }
}
