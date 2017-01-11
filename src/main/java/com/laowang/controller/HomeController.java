package com.laowang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/1/11.
 */

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        System.out.println("hello");
        return "home";
    }

}
