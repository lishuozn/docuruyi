package com.ruoyi.project.system.docPaper.tool;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class ZipCompress {
    private String zipFileName;	//目的地Zip文件
    private List<String> list ;//文件地址
    public ZipCompress(String zipFileName,List<String> list) {
        this.zipFileName = zipFileName;
        this.list = list;
    }


    public void zip() throws Exception {
        System.out.println("开始压缩...");

        //创建zip输出流
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        //调用函数
        compress(out);
        out.close();
        System.out.println("压缩完成！");
    }

    public void compress(ZipOutputStream out) throws Exception {
        FileInputStream fos = null;
        BufferedInputStream bis = null;
        for(int j=0;j<list.size();j++)
        {
            File sourceFile = new File(list.get(j));

            //如果路径为目录（文件夹）
            if(sourceFile.isDirectory()) {
                    //如果是文件夹，不做处理
            } else {
                out.putNextEntry(new ZipEntry(sourceFile.getName()));
                fos = new FileInputStream(sourceFile);
                bis = new BufferedInputStream(fos);
                int len;

                byte[] buf = new byte[1024];
                System.out.println(sourceFile.getName());
                while((len=bis.read(buf, 0, 1024)) != -1) {
                    out.write(buf, 0, len);
                }

            }


        }
        bis.close();
        fos.close();
    }
}