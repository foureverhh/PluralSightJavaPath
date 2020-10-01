package com.foureverhh.controller;

import com.foureverhh.pojo.Client;
import com.foureverhh.service.ClientService;
import com.foureverhh.service.FilesService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.faces.annotation.RequestMap;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.UUID;

@Controller
public class ClientController {
    @Resource
    private ClientService clientServiceImpl; //Resource find by name


/*
    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
*/

    @RequestMapping("/regis")
    public String register(Client client, @RequestParam MultipartFile file, HttpServletRequest request){
        System.out.println("username: "+client.getUsername() + ", password: "+client.getPassword());

       try{
            //将上传的头像放在images文件夹下
            String filePath = request.getServletContext().getRealPath("images");
            System.out.println(filePath+"->"+filePath.equals("/Users/foureverhh/Java/JavaEE/springMVC/client_register/web/images"));
            String filename = file.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString();
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(filePath+"/"+uuid+suffix));
            //只给client传setPhoto中的uuid+suffix,而不是全路径，因为只能
            client.setPhoto(uuid+suffix);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        int result = clientServiceImpl.insRegister(client);

        if(result > 0){
            request.getSession().setAttribute("client",client);
            return "redirect:show";
        }

        return "redirect:register";
    }

}
