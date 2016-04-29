package com.taotao.controller;

import com.taotao.common.pojo.PictureResponeResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 20150610 on 2016/4/29.
 */
@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile) {//uploadFile
        PictureResponeResult result = pictureService.uploadPic(uploadFile);
      String json = JsonUtils.objectToJson(result);
        return json;
    }
}
