package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/")
//  /表示出了jsp文件以外，所有的uri都会到这个dispatchServlet来
// /*表示拦截所有uri的request
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = req.getParameter("control");
        System.out.println(result);
        switch (result){
            case "demo1":
                demo1();
                break;
            case "demo2":
                demo2();
                break;
            case "demo3":
                demo3();
                break;
            case "demo4":
                demo4();
                break;
        }
    }

    private void demo4() {

    }

    private void demo3() {

    }

    private void demo2() {

    }

    private void demo1() {

    }
}
