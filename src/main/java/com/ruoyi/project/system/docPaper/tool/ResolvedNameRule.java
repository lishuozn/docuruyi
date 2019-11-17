package com.ruoyi.project.system.docPaper.tool;

import com.ruoyi.project.system.docPaper.domain.DocPaperForFileNameConfig;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ResolvedNameRule {

    /**
     * 获取论文解析后的文件地址和命名规范
     * @param docPaperList docPaper的所有数据
     * @param compareFileNameList 要下载的所有数据库文件地址
     * @param fileType 文件类型
     * @param configList //数据库对于这个文件的命名规则数据
     * @return
     */
    public List<FileNameConfig> newNameAndOldFilePath(List<DocPaperForFileNameConfig> docPaperList, List<String> compareFileNameList, String fileType,
                                                      List<FileNameConfig> configList){
        List<FileNameConfig> fileNameConfigList = resolvedNamingRules(fileType,docPaperList,compareFileNameList,
                configList);
        return fileNameConfigList;
    }

    /**
     * 解析文件命名规范
     * @param docPaperList docPaper的所有数据
     * @param compareFileNameList 要下载的所有数据库文件地址
     * @param fileType 文件类型
     * @param configList //数据库对于这个文件的命名规则数据
     * @return
     */
    List<FileNameConfig> resolvedNamingRules(String fileType,List<DocPaperForFileNameConfig> docPaperList,List<String> compareFileNameList,
                                             List<FileNameConfig> configList){
        List<FileNameConfig> fileNameConfigList = new ArrayList<>();
        if(fileType.equals("论文")) {
            List<Integer> intList = new ArrayList<>();
            /**
             * 把命名规则的数字全部分开存在intList里面
             */
            for(int i=0;i<configList.size();i++) {
                String[] as = configList.get(i).getNameRule().split("\\+");
                for(int j=0;j<as.length;j++) {
                    if(as[j].equals("")) {
                    }else {
                        intList.add(Integer.parseInt(as[j]));
                    }
                }
            }
            String newFileName = "";
            for(int i=0;i<compareFileNameList.size();i++) {
                for(int j=0;j<docPaperList.size();j++) {
                    if(compareFileNameList.get(i).equals(docPaperList.get(j).getAttachFile())){
                        for(int k=0;k<intList.size();k++) {
                            if(intList.get(k)==1) {
                                newFileName = newFileName.concat(docPaperList.get(j).getPaperKind()+"+");
                            }else if(intList.get(k)==2){
                                newFileName = newFileName.concat(docPaperList.get(j).getPaperTitle()+"+");
                            }else if(intList.get(k)==3){
                                newFileName = newFileName.concat(docPaperList.get(j).getAuthor1Name()+"+");
                            }else if(intList.get(k)==4){
                                newFileName = newFileName.concat(docPaperList.get(j).getAuthor1MajorId()+"+");
                            }else if(intList.get(k)==5){
                                newFileName = newFileName.concat(docPaperList.get(j).getAuthor2Name()+"+");
                            }else if(intList.get(k)==6){
                                newFileName = newFileName.concat(docPaperList.get(j).getAuthor2MajorId()+"+");
                            }else if(intList.get(k)==7){
                                newFileName = newFileName.concat(docPaperList.get(j).getAuthorNameOther()+"+");
                            }else if(intList.get(k)==8){
                                newFileName = newFileName.concat(docPaperList.get(j).getFirstUnit()+"+");
                            }else if(intList.get(k)==9){
                                newFileName = newFileName.concat(docPaperList.get(j).getSecondUnit()+"+");
                            }else if(intList.get(k)==10){
                                newFileName = newFileName.concat(docPaperList.get(j).getJournalName()+"+");
                            }else if(intList.get(k)==11){
                                newFileName = newFileName.concat(docPaperList.get(j).getJournalNumber()+"+");
                            }else if(intList.get(k)==12){
                                newFileName = newFileName.concat(docPaperList.get(j).getJournalSearchNumber()+"+");
                            }else if(intList.get(k)==13){
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                                String result=formatter.format(docPaperList.get(j).getPublishDate());
                                newFileName = newFileName.concat(result+"+");
                            }else if(intList.get(k)==14){
                                newFileName = newFileName.concat(docPaperList.get(j).getReelNumber()+"+");
                            }else if(intList.get(k)==15){
                                newFileName = newFileName.concat(docPaperList.get(j).getPageStart()+"+");
                            }else if(intList.get(k)==16){
                                newFileName = newFileName.concat(docPaperList.get(j).getPageEnd()+"+");
                            }else if(intList.get(k)==17){
                                newFileName = newFileName.concat(docPaperList.get(j).getFunds()+"+");
                            }else if(intList.get(k)==18){
                                newFileName = newFileName.concat(docPaperList.get(j).getLevelIdCcec()+"+");
                            }
                        }
                    }
                }
                FileNameConfig fileNameConfig = new FileNameConfig();
                fileNameConfig.setFileType("D:/profile/upload/"+compareFileNameList.get(i));
                fileNameConfig.setNameRule(newFileName);
                fileNameConfigList.add(fileNameConfig);
                newFileName = "";
            }//一层循环结束
        }//if结束
        return fileNameConfigList;
    }


}
