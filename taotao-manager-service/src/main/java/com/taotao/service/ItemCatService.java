package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by 20150610 on 2016/4/27.
 */
public interface ItemCatService {
    List<EasyUITreeNode> getItemCatList(Long parentId);
}
