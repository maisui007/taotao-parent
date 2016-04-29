package com.taotao.fastdfs;

import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * Created by 20150610 on 2016/4/29.
 */
public class FastdfsTest {


    @Test
    public  void testUpload() throws Exception {
        //            1、把FastDFS提供的jar包添加到工程中
//            2、初始化全局配置。加载一个配置文件。
        ClientGlobal.init("D:\\think_in_java_workspaces\\taotao-parent\\taotao-manager-web\\src\\main\\resources\\properties\\client_conf.properties");
//            3、创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
//            4、创建一个TrackerServer对象。
        TrackerServer trackerServer = trackerClient.getConnection();
//            5、声明一个StorageServer对象，null。
        StorageServer storageServer = null;
//            6、获得StorageClient对象。
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
//            7、直接调用StorageClient对象方法上传文件即可。
        String[] strings =storageClient.upload_file("C:\\Users\\Public\\Pictures\\Sample Pictures\\psb.jpg", "jpg", null);
        for (String str : strings){
            System.out.println(str);
        }

    }
//    @Test
//    public void testUpload1() throws Exception {
//        FastDFSClient fastDFSClient = new FastDFSClient("classpath:client_conf.properties");
//    String str =    fastDFSClient.uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\psb.jpg", "jpg");
//    System.out.println(str);
//    }
}
