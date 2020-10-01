package demo06_again.filter;

import demo06_again.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import java.io.IOException;


public class OpenSessionInViewFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Session session = null;
        Transaction  tx = null;
        try{
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            filterChain.doFilter(servletRequest,servletResponse);

            tx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            if(tx!=null) {
                tx.rollback();
            }
        }finally {
            HibernateUtil.closeSession();
        }

    }

    @Override
    public void destroy() {

    }
}
