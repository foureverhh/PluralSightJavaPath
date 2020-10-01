package lesson271;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)   //如果只有一个value
@Retention(RetentionPolicy.RUNTIME)  //那么value = 可写也可不写
public @interface MyAnnotation2 {
    String value(); //如果只有一个参数的话，一般参数的名字为value()
}
