package com.ruoyi.common.utils.file;

import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompress {
    private String zipFileName;	//目的地Zip文件
    private List<FileNameConfig> list ;//文件地址和命名规则转换后的名字
    private String[] colums = new String[]{}; //文件命名前面加的序号
    public ZipCompress(String zipFileName, List<FileNameConfig>  list,String[] colums) {
        String zipPath = "D:/profile/zipFile/";
        File myZipPath = new File( zipPath );

        if ( !myZipPath.exists()){//若此目录不存在，则创建之
            myZipPath.mkdir();
        }
        String zipFilename =  "D:/profile/zipFile/tempFile.zip" ;
        File file = new File(zipFilename);
        if (file.delete()) {
            file.delete();
        }else{
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("文件创建失败");
            }
        }
        this.zipFileName = zipFileName;
        this.list = list;
        this.colums = colums;
    }



    public void zip() throws Exception {
        //创建zip输出流
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        //调用函数
        compress(out);
        out.close();
    }

    public void compress(ZipOutputStream out) throws Exception {
        FileInputStream fos = null;
        BufferedInputStream bis = null;
        for(int j=0;j<list.size();j++)
        {
            File sourceFile = new File(list.get(j).getFileType());
            //如果路径为目录（文件夹）
            if(sourceFile.isDirectory()) {
                    //如果是文件夹，不做处理
            } else {
                String alterFileName = sourceFile.getName();
//                String newFileName = "7"+alterFileName.substring(alterFileName.indexOf("."));
                String newFileName = colums[j]+"+"+list.get(j).getNameRule()+alterFileName.substring(alterFileName.indexOf("."));
                out.putNextEntry(new ZipEntry(newFileName));
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