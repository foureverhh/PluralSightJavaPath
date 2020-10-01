package foureverhh.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class DemoController {
    @RequestMapping("/upload")
    public String upload(@RequestParam MultipartFile file,@RequestParam String name) throws IOException {
        /*MultipartResolver mr = null;*/
        System.out.println("hello");
        System.out.println(" name: "+name);
        String filePath = file.getOriginalFilename();
        if(filePath!=null) {
            String desktop = "/Users/foureverhh/Desktop/test/";
            String suffix = filePath.substring(filePath.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString();
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(desktop + uuid + suffix));
        }
        return "index";
    }
}
