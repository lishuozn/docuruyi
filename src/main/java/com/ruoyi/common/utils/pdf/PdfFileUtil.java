package com.ruoyi.common.utils.pdf;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * pdf合并拼接、拆分
 * @author zhaoqiang
 * @date 2019年11月15日
 * @throws IOException
 */
public class PdfFileUtil {
    public static File mulFile2One(List<File> files, String targetPath) throws IOException {
        // pdf合并工具类
        PDFMergerUtility mergePdf = new PDFMergerUtility();
        for (File f : files) {
            if(f.exists() && f.isFile()){
                // 循环添加要合并的pdf
                mergePdf.addSource(f);
            }
        }

        // 设置合并生成pdf文件名称
        mergePdf.setDestinationFileName(targetPath);
        // 合并pdf
        mergePdf.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        return new File(targetPath);
    }
    public static List<File> SplitPages(String fileName) throws IOException{
        //Loading an existing PDF document
        File file = new File(fileName);
        PDDocument document = PDDocument.load(file);
        //Instantiating Splitter class
        Splitter splitter = new Splitter();
        //splitting the pages of a PDF document
        List<PDDocument> Pages = splitter.split(document);
        //Creating an iterator
        Iterator<PDDocument> iterator = Pages.listIterator();
        //Saving each page as an individual document
        int i = 1;
        File file1;
        List<File> fileList = new ArrayList<>();
        File fileParent = new File("D:/profile/splitFile");
        if(!fileParent.exists()){
            fileParent.mkdirs();
        }
        while(iterator.hasNext()) {
            PDDocument pd = iterator.next();
            pd.save("D:/profile/splitFile/sample"+ i++ +".pdf");
            file1 = new File("D:/profile/splitFile/sample"+i+".pdf");
            fileList.add(file1);

        }
        System.out.println("Multiple PDF’s created");
        document.close();
        return fileList;
    }
//    public static void main(String[] args) throws IOException {
//        List<File> fileList = SplitPages( "G:\\test\\mul2one.pdf");
//        System.out.println(fileList.size());
//    }

}
