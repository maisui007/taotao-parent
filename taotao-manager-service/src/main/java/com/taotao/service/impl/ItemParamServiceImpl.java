package com.taotao.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 20150610 on 2016/5/6.
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {
  @Autowired
  private TbItemParamMapper itemParamMapper;
    @Override
    public TaotaoResult getItemParamByCid(Long cid) {
        //根据cid查询规格参数模板
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        //执行查询
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        //判断查询结果
        if (list !=null&&list.size()>0){
            TbItemParam itemParam = list.get(0);
            return TaotaoResult.ok();
        }
        return null;
    }
}
