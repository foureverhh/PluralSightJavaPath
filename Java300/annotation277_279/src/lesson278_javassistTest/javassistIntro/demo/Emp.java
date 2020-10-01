package lesson278_javassistTest.javassistIntro.demo;

import com.javassist.test.Author;
import javassist.*;

import java.io.IOException;
@Author(name = "Chiba",year = 2005)
public class Emp {
    private int empNo;
    private String eName;

    public Emp() {
    }

    public Emp(int empNo, String eName) {
        this.empNo = empNo;
        this.eName = eName;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return eName;
    }

    public void setName(String eName) {
        this.eName = eName;
    }

    public void sayHello(int a){
        System.out.println("sayHello, " + a);
    }

    public static class JavassistDemo {
        public static void main(String[] args) {
            ClassPool pool = ClassPool.getDefault();
            CtClass ctClass = pool.makeClass("com.javassist.test.Emp");

            //属性
            try {
                CtField empNum = CtField.make("private int empNum;",ctClass);
                CtField empName = CtField.make("private String empName;",ctClass);
                ctClass.addField(empNum);
                ctClass.addField(empName);
                //方法
                CtMethod method1 = CtMethod.make("public int getEmpNum() {\n" +
                        "        return empNum;\n" +
                        "    }",ctClass);
                CtMethod method2 = CtMethod.make("public void setEmpNum(int empNum){" +
                        "return this.empNum = empNum;" +
                        "}",ctClass);
                ctClass.addMethod(method1);
                ctClass.addMethod(method2);
                //构造器
                CtConstructor ctConstructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},ctClass);
                ctConstructor.setBody("{this.empNum = empNum;this.empName = empName;}");
                ctClass.addConstructor(ctConstructor);
                ctClass.writeFile("src"); //将上述构造好的class从内存写入指定路径
            } catch (CannotCompileException | NotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
