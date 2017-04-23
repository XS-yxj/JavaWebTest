package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/seeWorld")
    public String mainMvc() {
        return "seeWorld";
    }



}
