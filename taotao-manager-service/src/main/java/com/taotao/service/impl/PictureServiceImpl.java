package com.taotao.service.impl;

import com.taotao.common.pojo.PictureResponeResult;
import com.taotao.common.upload.picture.FastDFSClient;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 20150610 on 2016/4/29.
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Value("${IMAGE_SERVER_BASE_URL}")
    private String baseUrl;
    @Override
    public PictureResponeResult uploadPic(MultipartFile picFile) {
        PictureResponeResult result = new PictureResponeResult();
        //判断图片是否为空
        if (picFile.isEmpty()) {
            result.setError(1);
            result.setMessage("图片为空");
            return result;
        }
        //上传到图片服务器
        try {
            //取图片扩展名
            String originalFilename = picFile.getOriginalFilename();
            //取扩展名不要“.”
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            FastDFSClient client = new FastDFSClient("classpath:properties/client_conf.properties");
            String url = client.uploadFile(picFile.getBytes(), extName);
            //把url响应给客户端
            result.setError(0);
            //拼接图片服务器的ip及域名
            url = baseUrl+url;
            result.setUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
            result.setError(1);
            result.setMessage("图片上传失败");
        }
        return result;
    }
}
