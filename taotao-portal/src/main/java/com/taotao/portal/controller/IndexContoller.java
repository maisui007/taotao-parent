package com.taotao.portal.controller;

import com.taotao.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 20150610 on 2016/5/10.
 */
@Controller
public class IndexContoller {

    @Autowired
    private ContentService contentService;
    @RequestMapping("/index")
    public String showIndex(Model model){
        //取大广告位内容
        String json = contentService.getAd1List();
        //传递给页面
        model.addAttribute("ad1",json);

        return "index";
    }
    @RequestMapping(value="/posttest",method = RequestMethod.POST)
    @ResponseBody
    public String postTest(String name,String pass){
        System.out.println("name:"+name+",pass:"+pass);
        return "OK";
    }
}
