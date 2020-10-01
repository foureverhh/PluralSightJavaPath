package servlet;

import pojo.Airport;
import service.AirPortService;
import service.impl.AirPortServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/show-departure")
public class ShowTakeServlet extends HttpServlet {
    AirPortService airPortService = new AirPortServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> takePort = airPortService.showTakePort();
        List<Airport> landPort = airPortService.showLandPort();
        req.setAttribute("takeport",takePort);
        req.setAttribute("landport",landPort);
        req.getRequestDispatcher("show-arrival").forward(req,resp);
        //req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
