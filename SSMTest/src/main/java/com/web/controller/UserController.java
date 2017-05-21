package com.web.controller;

import com.entity.Message;
import com.entity.User;
import com.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

//    post会限制书签
    @RequestMapping(value = "/seeWorld")
    public String seeWord(@CookieValue(value = "username", required = false)String username,
                          @CookieValue(value = "password", required = false) String password,
                          HttpServletRequest request,
                          Model model) throws IOException {

//        cookie登录/重新登录
        if(username != null && password != null){
            User user = userService.getUser(username,password);
            request.getSession().setAttribute("user", user);
            model.addAttribute("user",user);

//       加载信息
            List<Message> messages = userService.queryMessages(username);
            model.addAttribute("messages", messages);

            return "seeWorld";
        }else {
            return "redirect:/?signIn";
        }



    }

//     ！！！！！！住此处偷懒，以后页面不考虑书签保存问题//TODO
    @RequestMapping(value = "/{username}/setting")
    private String setting(@PathVariable String username, HttpServletRequest request, Model model) {
        User user = (User)request.getSession().getAttribute("user");
        model.addAttribute(user);
        return "setting";
    }


    @RequestMapping(value = "/{username}/newMessage", method = RequestMethod.POST)
    private String newM(@PathVariable String username, @RequestParam(value = "file", required = false)MultipartFile file,
                        String message) throws IOException {

        if(!file.isEmpty()){
            String filePath = "E:\\fileRepo\\ssm\\"+username;
            FileUtils.copyInputStreamToFile(file.getInputStream(),
                    new File(filePath, file.getOriginalFilename()));
            userService.newMessage(username, message, filePath+"\\"+file.getOriginalFilename());
        }else {
            userService.newMessage(username, message, null);
        }
        return "redirect:/seeWorld";
    }


}