package com.foureverhh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
public class FileUploadController {
    @RequestMapping("/file_upload")
    public Map<String,Object> upload(@RequestParam("fileName") MultipartFile fileName) throws IOException {
        Map<String,Object> map = new HashMap<>();
        fileName.transferTo(new File("/Users/foureverhh/Desktop/"+fileName.getOriginalFilename()));
        map.put("msg",fileName.getOriginalFilename() + " uploaded succeed");
        return map;
    }
}
