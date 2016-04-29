package com.taotao.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 20150610 on 2016/4/27.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
   private TbItemCatMapper itemCatMapper;
    @Override
    public List<EasyUITreeNode> getItemCatList(Long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        //设置查询条件
       TbItemCatExample.Criteria criteria = example.createCriteria();
        //根据parentid查询子节点
        criteria.andParentIdEqualTo(parentId);
        List<EasyUITreeNode> resultList = new ArrayList<EasyUITreeNode>();
        //返回子节点列表
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        for (TbItemCat tbItemCat : list){
            //创建一个节点对象
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent() ? "closed" : "open");
            //添加到列表中
            resultList.add(node);

        }
        return resultList;
    }
}
