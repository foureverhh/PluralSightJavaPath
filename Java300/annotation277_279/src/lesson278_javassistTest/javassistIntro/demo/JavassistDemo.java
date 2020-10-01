package lesson278_javassistTest.javassistIntro.demo;

import javassist.*;

import java.io.IOException;

public class JavassistDemo {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {

        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("com.javassist.test.EmpTest");
        CtField num = CtField.make("private int num;",cc);
        CtField name = CtField.make("private String name;",cc);
        cc.addField(num);
        cc.addField(name);
        CtMethod getNum = CtMethod.make("public int getNum(){return num;}",cc);
        CtMethod setNum = CtMethod.make("public void setNum(int num){return this.num = num;}",cc);
        cc.addMethod(getNum);
        cc.addMethod(setNum);
        CtConstructor constructorNoParam = new CtConstructor(new CtClass[]{},cc);
        constructorNoParam.setBody("{}");
        CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
        constructor.setBody("{this.num = num; this.name = name;}");
        cc.addConstructor(constructorNoParam);
        cc.addConstructor(constructor);
        cc.writeFile("src"); //将数据从内存写入未见
    }

}
