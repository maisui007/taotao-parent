package com.taotao.rest.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by 20150610 on 2016/5/11.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Override
    public ItemCatResult getItemCatList() {
        //调用递归方法
        List catList = getItemCatList(0l);
        ItemCatResult itemCatResult = new ItemCatResult();
        itemCatResult.setData(catList);
        return itemCatResult;
    }
    //递归查询商品分类列表
    private List getItemCatList(Long parentId){
        //根据parentId查询列表
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        List resultList = new ArrayList();
        int index = 0;
        for (TbItemCat tbItemCat : list) {
            if (index>=14){
                break;
            }
            //如果不是叶子节点
            if (tbItemCat.getIsParent()) {
                CatNode node = new CatNode();
                node.setUrl("/products/" + tbItemCat.getId() + ".html");
                if (tbItemCat.getParentId() == 0) {
                    node.setName("<a href ='/products/'" + tbItemCat.getId() + ".html>" + tbItemCat.getName() + "</a>");
                    //一级节点不能超过14个元素
                    index++;
                } else {
                    node.setName(tbItemCat.getName());
                }
                node.setItems(getItemCatList(tbItemCat.getId()));
                //把node添加到列表
                resultList.add(node);
            }else {
                //若是叶子节点
                String item = "/products/"+tbItemCat.getId()+".html|"+ tbItemCat.getName();
                resultList.add(item);
            }
        }
        return resultList;
    }
}
