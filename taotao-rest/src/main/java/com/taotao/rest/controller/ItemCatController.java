package com.taotao.rest.controller;

import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.service.ItemCatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**商品分类服务
 * Created by 20150610 on 2016/5/11.
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;
//    @RequestMapping(value="/list",produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
//    @ResponseBody
//    public String getItemCatList(String callback){
//       ItemCatResult itemCatResult = itemCatService.getItemCatList();
//        if (StringUtils.isBlank(callback)){
//            String json  = JsonUtils.objectToJson(itemCatResult);
//            return json;
//        }
//        //如果字符串不为空，需要指出jsonp调用
//        //把itemCatResult转换为字符串
//        String json = JsonUtils.objectToJson(itemCatResult);
//        return callback+"("+json+");";
//    }
    @RequestMapping(value="/list")
    @ResponseBody
    public Object getItemCatList(String callback){
        ItemCatResult itemCatResult = itemCatService.getItemCatList();
        if (StringUtils.isBlank(callback)){
            return itemCatResult;
        }
        //如果字符串不为空，需要指出jsonp调用
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(itemCatResult);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
