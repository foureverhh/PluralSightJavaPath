package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class DemoController {
    @RequestMapping("/download")
    public void download(@RequestParam String file, HttpServletRequest req, HttpServletResponse response){
        String path = req.getServletContext().getRealPath("files");
        System.out.println("fileName->" + file);
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(path+"/"+file));
            ServletOutputStream sos = response.getOutputStream()) {
            response.setHeader("Content-Disposition","attachment;filename="+file);
            int info;
            while ((info=reader.read())!=-1){
                sos.write(info);
            }
            sos.flush();
            System.out.println("I am here!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
