package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Apple on 2017/4/22.
 * 首页
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexMvc() {
        return "index";
    }




////  处理上传文件
//    @RequestMapping("/setting/upload/{username}")
//    public String uploadImage(@PathVariable("username") String username, @RequestParam("file") MultipartFile file) throws IOException {
//
//        if(!file.isEmpty()) {
//            FileUtils.copyInputStreamToFile(file.getInputStream(),new File("E:\\fileRepo\\"+username,username+".jpg"));
//        }
//
//        return "redirect:/setting/"+username;
//    }



}
