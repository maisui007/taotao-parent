package com.taotao.rest.service;

import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * Created by 20150610 on 2016/5/12.
 */
public interface ContentService {
    List<TbContent> getContentList(Long cid);
}
