package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//import service.serviceImpl.PeopleServiceImpl;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
   /* private PeopleService service = new PeopleServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<People> people = service.showAll();
        System.out.println("people in servler " + people);
        req.setAttribute("list",people);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }*/
}
