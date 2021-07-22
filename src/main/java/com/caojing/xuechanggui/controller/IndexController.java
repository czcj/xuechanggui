package com.caojing.xuechanggui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }
    @RequestMapping("/form.html")
    public String form(){
        return "form";
    }
    @RequestMapping("/chart.html")
    public String route(){
        return "chart";
    }

}
