package com.taotao.portal.controller;

import com.taotao.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by 20150610 on 2016/5/12.
 */
@Controller
public class ContentController {
    @Autowired
    private ContentService contentService;
}
