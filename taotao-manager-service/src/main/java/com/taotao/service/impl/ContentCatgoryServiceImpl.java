package com.taotao.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.service.ContentCatgoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 20150610 on 2016/5/11.
 */
@Service
public class ContentCatgoryServiceImpl implements ContentCatgoryService {

    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;
    @Override
    public List<EasyUITreeNode> getContentCatList(Long parentId) {
       //根据parentId查询子节点列表
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
        //转换成EasyUITreeNode列表
        List<EasyUITreeNode> resultList = new ArrayList<EasyUITreeNode>();
        for (TbContentCategory tbContentCategory:list){
            //创建一个EasyUITreeNode节点
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent()?"closed":"open");
            //添加到列表
            resultList.add(node);
        }
        return resultList;
    }

    @Override
    public TaotaoResult insertCatgory(Long parentId, String name) {
      //创建一个pojo对象
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setName(name);
        tbContentCategory.setParentId(parentId);
        //1:正常2：删除
        tbContentCategory.setStatus(1);
        tbContentCategory.setIsParent(false);
        //排序
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setUpdated(new Date());
        //插入数据
        tbContentCategoryMapper.insert(tbContentCategory);
        //取返回的主键
        Long id = tbContentCategory.getId();
        //判断父节点的isParent属性
        //查询父节点
        TbContentCategory tbContentCategoryparent = tbContentCategoryMapper.selectByPrimaryKey(parentId);
        if (!tbContentCategory.getIsParent()){
            tbContentCategoryparent.setIsParent(true);
            //更新父节点
            tbContentCategoryMapper.updateByPrimaryKey(tbContentCategory);
        }
        return TaotaoResult.ok(id);
    }

}
