package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Apple on 2017/4/21.
 */
@Controller
@RequestMapping("/hello")
public class HelloMvcController {


//    url的参数接受输入(不推荐)
    @RequestMapping(value = "/mvc", method = RequestMethod.GET)
//    localhost:8080/hello/mvc?num=123
    public String helloMvc0(@RequestParam("num") Integer number, Model model){

//        *******默认命名为integer*******
//        model.addAttribute(number);

        model.addAttribute("number", number);

        return "home";
    }


//     面向资源的角度，通过路径接受参数接受输入（推荐）
    @RequestMapping(value = "/mvc/{num}", method = RequestMethod.GET)
//    localhost:8080/hello/mvc/{num}
    public String helloMvc(@PathVariable("num") Integer number, Map<String,Object> model){

        model.put("number", number);

        return "home";
    }


    //     传统的参数传递，通过request参数接受输入
    @RequestMapping("/mvc00")
//    localhost:8080/hello/mvc
    public String helloMvc00(HttpServletRequest request){

        Integer number = 1234000;

        request.setAttribute("number",number);

        return "home";
    }


}
