package com.example.blog.controller;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author:Sun Hongwei
 * @2020/2/24 上午3:58
 * File Description：
 */
public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
