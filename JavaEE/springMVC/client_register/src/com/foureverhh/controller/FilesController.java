package com.foureverhh.controller;

import com.foureverhh.pojo.Client;
import com.foureverhh.pojo.Files;
import com.foureverhh.service.FilesService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@Controller
public class FilesController {
    @Resource
    private FilesService filesServiceImpl;

    @RequestMapping("/show")
    public String show(Model model){
        List<Files> files = filesServiceImpl.showAll();
        model.addAttribute("files",files);
        return "main";
    }

    @RequestMapping("/download")
    public void download(@RequestParam String file,@RequestParam int id, HttpServletRequest req, HttpServletResponse resp){
        //更新下载次数
        int result = filesServiceImpl.updCount(id,(Client)req.getSession().getAttribute("client"),file);
        System.out.println("update count result: "+result);
        //处理下载
        resp.setHeader("Content-Disposition","attachment;filename="+file);
        String path1 = "/Users/foureverhh/Java/JavaEE/springMVC/client_register/web/files";
        String path = req.getServletContext().getRealPath("files");
        System.out.println(path+path.equals(path1));
        try(ServletOutputStream sos = resp.getOutputStream()){
            byte[] fileByte = FileUtils.readFileToByteArray(new File(path1+"/"+file));
            sos.write(fileByte);
            sos.flush();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
