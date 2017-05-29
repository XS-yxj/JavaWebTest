package com.web.controller;

import com.entity.User;
import com.enums.UserStateEnum;
import com.service.UserService;
import com.util.CookieUtil;
import com.util.KaptchaUtil;
import com.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

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
    public String signIn(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

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

    //    post注册
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(HttpServletRequest request,
                         @RequestParam String username, @RequestParam String email,
                         @RequestParam String password, @RequestParam String rePassword,
                         Model model) throws IOException {
//      检查验证码
//            Boolean isCheckCode = KaptchaUtil.checkCode(request);
        if(rePassword.equals(password)) {
            int count = userService.newUser(username, password, email);
            if(count == 1) {
                return "redirect:/?signIn";
            }else {
                return "redirect:/?";
            }
        }else {
//            重复密码错误
            return "redirect:/?";
        }
    }

//    提供Ajax实时注册检查用户重名
    @RequestMapping(value = "/checkUsername")
    public void checkUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        username = URLDecoder.decode(username, "UTF-8");
        if(userService.getUser(username) != null){
            response.getWriter().write("rename");
        }
    }

}
