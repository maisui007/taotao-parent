package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 20150610 on 2016/4/27.
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping("/list")
    @ResponseBody
    public List categoryList(@RequestParam(value="id",defaultValue = "0") Long parentId) throws Exception{
        List catList = new ArrayList();
        //查询数据库
        List<EasyUITreeNode> list = itemCatService.getItemCatList(parentId);
//        for (TbItemCat tbItemCat : list){
//            Map node = new HashMap<>();
//            node.put("id",tbItemCat.getId());
//            node.put("text",tbItemCat.getName());
//            //如果是父节点的话就设置成关闭状态，如果是叶子节点就是open状态
//            node.put("state",tbItemCat.getIsParent()?"closed":"open");
//            catList.add(node);
//        }
        return list;
    }
}
