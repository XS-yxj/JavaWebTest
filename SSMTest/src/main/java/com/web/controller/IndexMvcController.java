package com.web.controller;

import com.bean.User;
import com.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Apple on 2017/4/22.
 * 首页
 */

@Controller
//@RequestMapping("/")
public class IndexMvcController {

    @RequestMapping({"/"})
    public String indexMvc() {

        return "index";
    }



//  若没占位会有bug？？？？
    @RequestMapping("/seeWorld/{username}")
    public String mainMvc(@PathVariable("username") String username ,Model model) {

            User user = UserService.getUserInfo(username);
            model.addAttribute(user);

        return "seeWorld";
    }


    @RequestMapping("/setting")
    public String settingMvc1() {

//        User user = UserService.getUserInfo(username);
//        model.addAttribute(user);

        return "setting";
    }



    @RequestMapping("/setting/{username}")
    public String settingMvc(@PathVariable("username") String username ,Model model) {

        User user = UserService.getUserInfo(username);
        model.addAttribute(user);

        return "setting";
    }

//  处理上传文件
    @RequestMapping("/setting/upload/{username}")
    public String uploadImage(@PathVariable("username") String username, @RequestParam("file") MultipartFile file) throws IOException {

        if(!file.isEmpty()) {
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File("E:\\fileRepo\\"+username,username+".jpg"));
        }

        return "redirect:/setting/"+username;
    }


//    @RequestMapping(value = "/mvc/{num}", method = RequestMethod.GET)
////    localhost:8080/hello/mvc/{num}
//    public String helloMvc(@PathVariable("num") Integer number, Map<String,Object> model){
//
//        model.put("number", number);
//
//        return "home";
//    }

}
