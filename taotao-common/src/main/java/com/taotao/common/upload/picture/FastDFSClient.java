package com.taotao.common.upload.picture;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

/**
 * Created by 20150610 on 2016/4/29.
 */
public class FastDFSClient {
    private TrackerClient trackerClient = null;
    private TrackerServer trackerServer = null;
    private StorageServer storageServer = null;
    private StorageClient storageClient = null;
    public FastDFSClient(String conf) throws Exception {
        if (conf.contains("classpath:")){
            conf = conf.replace("classpath:",this.getClass().getResource("/").getPath());
        }
        ClientGlobal.init(conf);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageServer =null;
        storageClient = new StorageClient(trackerServer,storageServer);
    }
    public String uploadFile(String fileName,String extName,NameValuePair[] metas) throws Exception {
        String result = uploadFileToPath(fileName,extName,metas);
        return result;
    }
    public String uploadFile(String fileName)throws Exception{
        return uploadFile(fileName,null,null);
    }
    public String uploadFile(String fileName,String extName)throws Exception{
        return uploadFile(fileName,extName,null);
    }
    public String uploadFile(byte[] fileContent,String extName,NameValuePair[] metas) throws Exception {
        String result =uploadFileToPath(fileContent,extName,metas);
        return result;
    }
    public String uploadFile(byte[] fileContent)throws Exception{
        return uploadFile(fileContent,null,null);
    }
    public String uploadFile(byte[] fileContent,String extName)throws Exception{
        return uploadFile(fileContent,extName,null);
    }
    private String uploadFileToPath(String fileName,String extName,NameValuePair[] metas) throws Exception {
        String[] result = storageClient.upload_file(fileName,extName,metas);
        String url=null;
        for (String str : result){
            url+="/"+str;
        }
        return url;
    }
    private String uploadFileToPath(byte[] fileContent,String extName,NameValuePair[] metas) throws Exception {
        String[] result = storageClient.upload_file(fileContent,extName,metas);
        String url="";
        for (String str : result){
            url+="/"+str;
        }
        return url;
    }
}
