package advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import pojo.User;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.apache.log4j.*;

public class MyBefore implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        User user = (User) objects[0];
        Logger logger = Logger.getLogger(this.getClass());
        logger.info(user.getUsername() + ", at "+ LocalDateTime.now().getHour() + " tries to log in!");
    }
}
