package servletSample;

public class MyServlet  extends HttpServlet{
    @Override
    public void doGet() {
        System.out.println("MyServlet doGet()");
    }
}
