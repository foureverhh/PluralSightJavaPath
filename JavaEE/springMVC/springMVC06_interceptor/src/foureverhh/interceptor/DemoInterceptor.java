package foureverhh.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoInterceptor implements HandlerInterceptor {
    //进入controller之前执行
    //如果返回值为false，阻止进入controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //handler为被拦截的controller的方法
        System.out.println("preHandle");
        return true;
    }

    //controller执行完成，进入到jsp之前执行
    //可以获取到model和view的值
    //日志记录，敏感词语过滤
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("往"+modelAndView.getViewName()+"跳转");
        System.out.println("model的值"+modelAndView.getModel().get("model"));
        String word = modelAndView.getModel().toString();
        String newWord = word.replace("祖国","**");
        modelAndView.getModel().put("model",newWord);

     /*   //可以修改model的值
        modelAndView.getModel().put("model","修改model的值");*/
        System.out.println("PostHandle");
    }

    //（也是controller执行完成）并且jsp执行完成后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion, ex: "+ex);
    }
}
