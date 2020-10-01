package lesson279_javassistAPI;

import com.javassist.test.Author;
import javassist.*;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class JavassistAPIDemo {
    public static void test01() throws NotFoundException, IOException, CannotCompileException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("lesson278_javassistTest.javassistIntro.demo.Emp");
        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
        System.out.println("类名： " + cc.getName());
        System.out.println("包名： " + cc.getPackageName());
        System.out.println("简要类名： " + cc.getSimpleName());
        System.out.println("获得父类： " + cc.getSuperclass());
        System.out.println("获得接口： " + Arrays.toString(cc.getInterfaces()));
    }

    public static void testMethodHandel() throws NotFoundException, CannotCompileException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("lesson278_javassistTest.javassistIntro.demo.Emp");
        CtMethod m1 = CtMethod.make("public int add(int a,int b){return a + b;}",cc);
        cc.addMethod(m1);

        CtMethod m2 = new CtMethod(CtClass.intType,"multiply",new CtClass[]{CtClass.intType,CtClass.intType},cc);
        m2.setModifiers(Modifier.PUBLIC);
        m2.setBody("{System.out.println($1 * $2);return $1 * $2;}"); //$0代表this，$1代表第一个实参，$2代表第二个实参
        cc.addMethod(m2);

        //通过反射调用新方法
        //Class<?> clz = Class.forName("lesson278_javassistTest.javassistIntro.demo.Emp");
        Class<?> clz = cc.toClass(); //通过CtClass获得Class<?>
        System.out.println(clz.getSimpleName());
        Object obj = clz.getConstructor().newInstance();
        Method multiply = clz.getDeclaredMethod("multiply",int.class,int.class);
        int result = (Integer) multiply.invoke(obj,2,3);
        System.out.println(result);
    }

    public static void modifyMethod() throws NotFoundException, CannotCompileException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();
        CtClass  cc = pool.get("lesson278_javassistTest.javassistIntro.demo.Emp");
        CtMethod sayHello = cc.getDeclaredMethod("sayHello",new CtClass[]{CtClass.intType});
        //加在现存方法体代码前
        sayHello.insertBefore("System.out.println($1);System.out.println(\"InsertBefore!\");");

        //插入在该class文件的某行
        sayHello.insertAt(37,"System.out.println(\"insertAt(37)!\");");

        //加在限次你方法体代码后
        sayHello.insertAfter("System.out.println($1);System.out.println(\"insertAfter!\");");

        //通过反射调用sayHello方法
        Class<?> clz = cc.toClass();
        Object obj = clz.getConstructor().newInstance();
        Method target = clz.getDeclaredMethod("sayHello",int.class);
        target.invoke(obj,4);
    }

    public static void modifyField() throws NotFoundException, CannotCompileException, NoSuchFieldException, IllegalAccessException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("lesson278_javassistTest.javassistIntro.demo.Emp");
        CtField f1 = new CtField(CtClass.intType,"salary",cc);
        f1.setModifiers(Modifier.PRIVATE);
        f1.setModifiers(Modifier.STATIC);
        cc.addField(f1, String.valueOf(1000));
        Field num = cc.toClass().getDeclaredField("salary");
        num.setAccessible(true);
        System.out.println(num.get(null));

        //add getter and setter
        cc.addMethod(CtNewMethod.getter("getSalary",f1));
        cc.addMethod(CtNewMethod.setter("setSalary",f1));
    }

    public static void modifyConstructor() throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("lesson278_javassistTest.javassistIntro.demo.Emp");
        CtConstructor[] constructors = cc.getConstructors();
        for(CtConstructor constructor : constructors){
            System.out.println(constructor.getName());
            System.out.println(constructor.getLongName());
            //可以使用insertBefore和insertAfter，以及insertAt
        }
    }

    public static void modifyAnnotations() throws NotFoundException, ClassNotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("lesson278_javassistTest.javassistIntro.demo.Emp");
        Object[] annotations =cc.getAnnotations();
        Author author = (Author) annotations[0];
        System.out.println(author.name() + ", " + author.year());
    }

    public static void main(String[] args) throws NotFoundException, IOException, CannotCompileException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //test01();
        System.out.println("test");
        //testMethodHandel();
        //modifyMethod();
        //modifyField();
        //modifyConstructor();
        modifyAnnotations();
    }
}
