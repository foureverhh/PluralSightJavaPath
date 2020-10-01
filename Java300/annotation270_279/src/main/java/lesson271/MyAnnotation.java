package lesson271;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
//meta annotation用来对其他注解进行解释的
/*
 * @Target （value=ElementType.TYPE）
 * 描述注解的适用范围（即被注解的东西可以用在什么地方）
 * ElementType.
 * PACKAGE - package 包
 * TYPE    - 类、接口、枚举、Annotation类型
 * CONSTRUCTOR - 用于描述构造器
 * FIELD - 用于描述域
 * METHOD - 用于描述方法
 * LOCAL-VARIABLE - 用于描述局部变量
 * PARAMETER - 用于描述参数
 *
 * ******
 *
 * @Retention
 * 表示需要在什么级别保存该注释信息，用于描述注解的生命周期
 * RetentionPolicy.
 * SOURCE - 在源文件中有效（即源文件保留）
 * CLASS - 在class文件中有效（即class保留）
 * RUNTIME - 在运行时有效（即运行时保留），为Runtime可以被反射机制读取
 *
 * ******
 *
 * @Documented
 *
 *
 *
 *
 * @Inherited
 *
 * */
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    //参数类型 参数名（） (参数名带括号)
    String studentName() default ""; //通过default来设置默认值,-1 表示不存在
    int age() default 0;             //通过default来设置默认值,-1 表示不存在
    String[] schools() default {"北大","清华"};
}
