package lesson277_js_engine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class DemoJavaScriptEngine {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine jsEngine = manager.getEngineByName("javascript");

        //定义变量
        jsEngine.put("msg","GaoQi is a good man!");
        String str = "var user = {" +
                                    "name:'GaoQi',"+
                                    "age:18,"+
                                    "school: ['清华大学','北京大学']"+
                                 "};";
        str += "println(user.name);";

        //执行脚本
        try {
            jsEngine.eval(str);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
