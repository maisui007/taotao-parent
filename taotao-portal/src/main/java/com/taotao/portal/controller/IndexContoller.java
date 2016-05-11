package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 20150610 on 2016/5/10.
 */
@Controller
public class IndexContoller {
    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
}
