package com.walkBAM.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    /**
     * 递归获取某路径下的所有文件，文件夹，并输出
     */
    public static List getFiles(String path) {
        String fileName="";

        File file = new File(path);
        List<String> pname = new ArrayList<>();
        // 如果这个路径是文件夹
        if (file.isDirectory()) {
            // 获取路径下的所有文件
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
               fileName=path.substring(path.lastIndexOf("\\")+1);
                // 如果还是文件夹 递归获取里面的文件 文件夹
                if (files[i].isDirectory()) {
                    fileName=files[i].getName();
                    getFiles(files[i].getPath());
                } else {
                    fileName = fileName+"/"+files[i].getName();
                    System.out.println(fileName);
                    pname.add(fileName);
                }
            }
        } else {
        }
        System.out.println(pname.size());
        return pname;
    }

}
