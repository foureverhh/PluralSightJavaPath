package lessson277_javascript_engine;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class DemoJavaScriptEngine {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine jsEngine = manager.getEngineByName("javascript");

        //定义变量,并将变量储存在引擎上下文中
        jsEngine.put("msg","GaoQi is a good man!");
        String str = "var user = {" +
                "name:'GaoQi',"+
                "age:18,"+
                "school: ['清华大学','北京大学']"+
                "};";
        str += "print(user.name);";

        //执行脚本
        try {
            //使用js运行和更改
            jsEngine.eval(str);
            jsEngine.eval("msg = 'sxt is a good school'");
            System.out.println(jsEngine.get("msg"));
            System.out.println("#############################################");

            //定义JS函数
            jsEngine.eval("function add(a,b){" +
                    "var sum = parseFloat(a) + parseFloat(b); return sum;};");

            //调用JS函数
            Invocable jsInvoke = (Invocable) jsEngine; //需要将ScriptEngine转为Invocable才可以调用JS函数
            Object sum = jsInvoke.invokeFunction("add",new Object[]{"13","20"});
            System.out.println(sum);

            System.out.println("#############################################");

            //导入其他java包，使用其他包中的java类
            String jsCode = "var list = java.util.Arrays.asList([\"北京大学\",\"清华大学\",\"北航大学\"]);";
            jsEngine.eval(jsCode);
            List<String> list2 = (List<String>)jsEngine.get("list");
            for(String string : list2){
                System.out.println(string);
            }

            System.out.println("#############################################");

            //执行一个js文件
            URL url =  DemoJavaScriptEngine.class.getClassLoader().getResource("scripts/a.js");
            FileReader fileReader = new FileReader(url.getPath());
            jsEngine.eval(fileReader);/**/
            fileReader.close();
        } catch (ScriptException | NoSuchMethodException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
