package servlet;

import pojo.People;
import service.PeopleService;
import service.serviceImpl.PeopleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    private PeopleService service = new PeopleServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<People> people = service.showAll();
        System.out.println("people in servler " + people);
        req.setAttribute("list",people);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
