package filter;


import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class AirplaneFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        SqlSession session = MybatisUtil.getSession();
        try{
            filterChain.doFilter(servletRequest,servletResponse);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession();
        }
    }

    @Override
    public void destroy() {

    }
}
