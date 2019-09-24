package servletSample;

public class HttpServlet {
    public void service(){
        System.out.println("servletSample.HttpServlet.service()");
        doGet();
    }

    public void doGet(){
        System.out.println("servletSample.HttpServlet.doGet()");
    }

}
