package com.web.controller;

import com.entity.User;
import com.enums.UserStateEnum;
import com.service.UserService;
import com.util.CookieUtil;
import com.util.KaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * 主Controller
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexMvc() {
        return "index";
    }

    //    post登录
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String seeWord(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        密码登录\重新登陆
        if(username != null && password != null) {
            //      数据库验证用户
            User user = userService.getUser(username,password);
//      检查验证码
            Boolean isCheckCode = KaptchaUtil.checkCode(request);

            if (isCheckCode) {
                if(user.getState() == UserStateEnum.ERROR_USERNAME.getState()){
                    return "redirect:/?errorUsername";
                }else if (user.getState() == UserStateEnum.ERROR_PASSWORD.getState()){
                    return "redirect:/?errorPassword";
                }else {
//              删除或保存Cookie
                    CookieUtil.deal(request,response);
                    model.addAttribute("user",user);
                    return "redirect:/seeWorld";
                }
            }else {
                return "redirect:/?errorCheckCode";
            }
        }else {
            return "redirect:/?signIn";
        }

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
