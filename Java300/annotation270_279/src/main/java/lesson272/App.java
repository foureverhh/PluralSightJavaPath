package lesson272;

import utils.annotations.SxtField;
import utils.annotations.SxtTable;
import utils.model.SxtStudent;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        try {
            Class clz = Class.forName("utils.model.SxtStudent");
            SxtStudent sxtStudent = (SxtStudent) clz.getConstructor().newInstance();
            //获取所有注解
            Annotation[] annotations = clz.getAnnotations();
            System.out.println(Arrays.toString(annotations));

            //获取指定注解
            Annotation sxtTable = clz.getAnnotation(SxtTable.class);
            System.out.println(sxtTable.toString());

            //获取类的属性的注解
            Field field = clz.getDeclaredField("studentName");
            System.out.println(field.getName());
            SxtField sxtField = field.getAnnotation(SxtField.class);
            System.out.println(sxtField.columnName() + ", " + sxtField.type() + ", " + sxtField.length() );

            //获取id的属性注解
            Field id = clz.getDeclaredField("id");
            SxtField idAnnotation = id.getAnnotation(SxtField.class);
            System.out.println(idAnnotation.columnName() + ", " + idAnnotation.type() + ", " + idAnnotation.length() );

            //通过获取的这些注解，通过JDBC实现SQL的DDL

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
