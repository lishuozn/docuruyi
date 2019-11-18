package com.ruoyi.project.system.docMonograph.tool;

import com.ruoyi.project.system.docMonograph.domain.DocMonographForFileNameConfig;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.fileNameConfig.service.FileNameConfigServiceImpl;


import java.util.ArrayList;
import java.util.List;

public class DocMonographResolvedNameRule {

    /**
     * 获取论文解析后的文件地址和命名规范
     * @param
     * @param compareFileNameList
     * @param fileType
     * @param configList
     * @return
     */
    public List<FileNameConfig> newNameAndOldFilePath(List<DocMonographForFileNameConfig> docMonographList, List<String> compareFileNameList, String fileType,
                                                      List<FileNameConfig> configList){
        List<FileNameConfig> fileNameConfigList = resolvedNamingRules(fileType,docMonographList,compareFileNameList,
                configList);
        return fileNameConfigList;
    }

    /**
     * 解析文件命名规范
     * @param fileType
     * @param
     * @param
     * @param compareFileNameList
     * @param configList
     * @return
     */
    List<FileNameConfig> resolvedNamingRules(String fileType,List<DocMonographForFileNameConfig> docMonographList,List<String> compareFileNameList,
                                             List<FileNameConfig> configList){
        String nameRule = "";
        List<FileNameConfig> fileNameConfigList = new ArrayList<>();
        if(fileType.equals("专著")) {
            FileNameConfigServiceImpl fileNameConfigService = new FileNameConfigServiceImpl();
            List<Integer> intList = new ArrayList<>();
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
                for(int j=0;j<docMonographList.size();j++) {
                    if(compareFileNameList.get(i).equals(docMonographList.get(j).getAttachFile())){
                        for(int k=0;k<intList.size();k++) {
                            if(intList.get(k)==1) {
                                newFileName = newFileName.concat(docMonographList.get(j).getMonographId()+"+");
                            }else if(intList.get(k)==2){
                                newFileName = newFileName.concat(docMonographList.get(j).getMonographName()+"+");
                            }else if(intList.get(k)==3){
                                newFileName = newFileName.concat(docMonographList.get(j).getAuthor1Id()+"+");
                            }else if(intList.get(k)==4){
                                newFileName = newFileName.concat(docMonographList.get(j).getAuthor1Name()+"+");
                            }else if(intList.get(k)==5){
                                newFileName = newFileName.concat(docMonographList.get(j).getAuthor1MajorId()+"+");
                            }else if(intList.get(k)==6){
                                newFileName = newFileName.concat(docMonographList.get(j).getAuthor2Name()+"+");
                            }else if(intList.get(k)==7){
                                newFileName = newFileName.concat(docMonographList.get(j).getAuthor2MajorId()+"+");
                            }else if(intList.get(k)==8){
                                newFileName = newFileName.concat(docMonographList.get(j).getAuthorNameOther()+"+");
                            }else if(intList.get(k)==9){
                                newFileName = newFileName.concat(docMonographList.get(j).getPressName()+"+");
                            }else if(intList.get(k)==10){
                                newFileName = newFileName.concat(docMonographList.get(j).getPublishDate()+"+");
                            }else if(intList.get(k)==11){
                                newFileName = newFileName.concat(docMonographList.get(j).getPressLevel()+"+");
                            }else if(intList.get(k)==12){
                                newFileName = newFileName.concat(docMonographList.get(j).getAttachFile()+"+");
                            }else if(intList.get(k)==13){
                                newFileName = newFileName.concat(docMonographList.get(j).getNotes()+"+");
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
        }
        return fileNameConfigList;
    }


}
