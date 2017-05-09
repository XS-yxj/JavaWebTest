package com.web.controller;

import com.entity.User;
import com.enums.UserStateEnum;
import com.service.UserService;
import com.util.CookieUtil;
import com.util.KaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    UserService userService;

//    post会限制书签
    @RequestMapping(value = "/seeWorld")
    public String seeWord(@CookieValue(value = "username", required = false)String usernameC,
                          @CookieValue(value = "password", required = false) String passwordC,
                          HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        密码登录\cookie登录\重新登陆
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
                    return "seeWorld";
                }
            }else {
                return "redirect:/?errorCheckCode";
            }
        }else if(usernameC != null && passwordC != null){
            User user = userService.getUser(usernameC,passwordC);
            model.addAttribute("user",user);
            return "seeWorld";
        }else {
            return "redirect:/?signIn";
        }


    }

    @RequestMapping(value = "/setting")
    private String setting() {
        return "setting";
    }


}
