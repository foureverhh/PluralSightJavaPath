package advice;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import pojo.User;

import java.lang.reflect.Method;

public class MyAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        Logger logger = Logger.getLogger(this.getClass());
        //o为切片方法的返回对象
        User u1 = (User) o;
        User u2 = (User) objects[0];
        if(o!=null){
            logger.info(u1.getUsername() + u2.getUsername() + " 登录成功 ");
        }else {
            logger.info(u2.getUsername() + " 登录失败");
        }
    }
}
