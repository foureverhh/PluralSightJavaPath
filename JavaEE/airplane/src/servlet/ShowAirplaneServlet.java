package servlet;

import pojo.Airplane;
import service.AirPlaneService;
import service.impl.AirplaneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/show-airplane")
public class ShowAirplaneServlet extends HttpServlet {
   AirPlaneService airPlaneService = new AirplaneServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int takeId = 0, landId = 0;
        if(req.getParameter("takeId") != null) {
            takeId = Integer.parseInt(req.getParameter("takeId"));
        }
        if(req.getParameter("landId") != null) {
            landId = Integer.parseInt(req.getParameter("landId"));
        }
        List<Airplane> airplanes = airPlaneService.show(takeId,landId);
        req.setAttribute("airplanes",airplanes);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}

