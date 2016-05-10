package com.taotao.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 20150610 on 2016/5/6.
 */
@Controller
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;
    @RequestMapping("/query/itemcatid/{cid}")
    @ResponseBody
    public TaotaoResult getItemCatByCid(@PathVariable long cid){
       TaotaoResult taotaoResult = itemParamService.getItemParamByCid(cid);
        return taotaoResult;
    }
}
