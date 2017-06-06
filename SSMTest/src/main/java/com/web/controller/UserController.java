package com.web.controller;

import com.entity.Message;
import com.entity.User;
import com.service.UserService;
import com.util.MyUtil;
import net.sf.json.JSONArray;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
//            List<Message> messages = userService.queryMessages(username);
            List<User> users = userService.queryFriends(username);
            users.add(user);
            List<Message> messages = userService.queryMessageAll(users);
            model.addAttribute("messages", messages);
            return "seeWorld";
        }else {
            return "redirect:/?signIn";
        }
    }


//     ！！！！！！住此处偷懒，以后页面不考虑书签保存问题//TODO
    @RequestMapping(value = "/{username}/setting")
    public String setting(@PathVariable String username, HttpServletRequest request, Model model) {
        User user = (User)request.getSession().getAttribute("user");
        model.addAttribute(user);
        return "setting";
    }

    //人脉
    @RequestMapping(value = "/{username}/friends")
    public String friends(@PathVariable String username, Model model) {
        List<User> userList = userService.queryFriends(username);
        model.addAttribute("userList", userList);
        return "friends";
    }

//  搜索
    @RequestMapping(value = "/search")
    public void search(@RequestParam String keyword, HttpServletResponse response) throws IOException {
        keyword =  URLDecoder.decode(keyword, "UTF-8");
        List<String> users = userService.search(keyword);
//        返回json格式
//        System.out.println(JSONArray.fromObject(users));
        response.getWriter().write(JSONArray.fromObject(users).toString());
    }

    @RequestMapping(value = "/search/keyword")
    public String search(@RequestParam String keyword){
        return "redirect:/"+keyword;
    }


//    关注
    @RequestMapping(value = "/{userA}/watch/{userB}")
    public void watch(@PathVariable String userA, @PathVariable String userB, HttpServletResponse response, Model model) throws IOException {

        userA = URLDecoder.decode(userA, "UTF-8");
        userB = URLDecoder.decode(userB, "UTF-8");
        response.getWriter().write(userService.watchByProcedure(userA, userB) + "");

    }


    @RequestMapping(value = "/{username}/newMessage", method = RequestMethod.POST)
    public String newM(@PathVariable String username, @RequestParam(value = "file", required = false)MultipartFile file,
                        String message) throws IOException {

        if(!file.isEmpty()){
            String filePath = "\\fileRepo\\ssm\\"+username;
            FileUtils.copyInputStreamToFile(file.getInputStream(),
                    new File("E:\\" + filePath, MyUtil.getNowDateString() + file.getOriginalFilename()));
            userService.newMessage(username, message, filePath+"\\"+ MyUtil.getNowDateString() + file.getOriginalFilename());
        }else {
            userService.newMessage(username, message, null);
        }
        return "redirect:/seeWorld";
    }

//  根据用户名进入空间
    @RequestMapping(value = "/{username}")
    public String zone(@PathVariable String username, HttpServletRequest request,Model model) throws IOException {

        User user = (User)request.getSession().getAttribute("user");

//       加载信息
        List<Message> messages = userService.queryMessages(username);
        model.addAttribute("messages", messages);
//      关注列表
        List<User> userList = userService.queryFriends(user.getUsername());
        model.addAttribute("userList", userList);

        return "zone";
    }

//    评论
    @RequestMapping(value = "/{followerName}/follow/{username}/{time}" )
    public String follow(@PathVariable String followerName, @PathVariable String username,
                         @PathVariable String time, @RequestParam String content) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");

        userService.comment(username, followerName, format.parse(time), content);
        return "redirect:/seeWorld";
    }


}