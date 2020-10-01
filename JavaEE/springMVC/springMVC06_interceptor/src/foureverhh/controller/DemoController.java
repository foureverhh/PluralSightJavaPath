package foureverhh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("/demo")
    public String demo(Model model){
        System.out.println("执行controller，demo");
        model.addAttribute("model","我的祖国");
        return "index";
    }
}
