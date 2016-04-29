package com.taotao.service;

import com.taotao.common.pojo.PictureResponeResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 20150610 on 2016/4/29.
 */
public interface PictureService {
    PictureResponeResult uploadPic(MultipartFile multipartFile);
}
