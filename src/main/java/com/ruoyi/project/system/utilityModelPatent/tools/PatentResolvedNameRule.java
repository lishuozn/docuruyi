package com.ruoyi.project.system.utilityModelPatent.tools;

import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.sciResSubject.domain.SciResSubjectFileNameConfig;
import com.ruoyi.project.system.utilityModelPatent.domain.UtilityModelPatentFileNameConfig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PatentResolvedNameRule {
    /**
     * 获取论文解析后的文件地址和命名规范
     * @param patentList sciRes的所有数据
     * @param compareFileNameList 要下载的所有数据库文件地址
     * @param fileType 文件类型
     * @param configList //数据库对于这个文件的命名规则数据
     * @return
     */
    public List<FileNameConfig> newNameAndOldFilePath(List<UtilityModelPatentFileNameConfig> patentList, List<String> compareFileNameList, String fileType,
                                                      List<FileNameConfig> configList){
        List<FileNameConfig> fileNameConfigList = resolvedNamingRules(fileType,patentList,compareFileNameList,
                configList);
        return fileNameConfigList;
    }

    /**
     * 解析文件命名规范
     * @param patentList sciRes的所有数据
     * @param compareFileNameList 要下载的所有数据库文件地址
     * @param fileType 文件类型
     * @param configList //数据库对于这个文件的命名规则数据
     * @return
     */
    List<FileNameConfig> resolvedNamingRules(String fileType,List<UtilityModelPatentFileNameConfig> patentList,List<String> compareFileNameList,
                                             List<FileNameConfig> configList){
        List<FileNameConfig> fileNameConfigList = new ArrayList<>();
        if(fileType.equals("实用新型专利")) {
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
                for(int j=0;j<patentList.size();j++) {
                    if(compareFileNameList.get(i).equals(patentList.get(j).getAttachFile())){
                        for(int k=0;k<intList.size();k++) {
                            if(intList.get(k)==1) {
                                newFileName = newFileName.concat(patentList.get(j).getPatentName()+"+");
                            }else if(intList.get(k)==2){
                                newFileName = newFileName.concat(patentList.get(j).getPatentNumber()+"+");
                            }else if(intList.get(k)==3){
                                newFileName = newFileName.concat(patentList.get(j).getInventor1Name()+"+");
                            }else if(intList.get(k)==4){
                                newFileName = newFileName.concat(patentList.get(j).getInventor1MajorId()+"+");
                            }else if(intList.get(k)==5){
                                newFileName = newFileName.concat(patentList.get(j).getOtherInventor()+"+");
                            }else if(intList.get(k)==6){
                                newFileName = newFileName.concat(patentList.get(j).getPatentee()+"+");
                            }else if(intList.get(k)==7){
                                newFileName = newFileName.concat(patentList.get(j).getAccreditNoticeDate()+"+");
                            }else if(intList.get(k)==8){
                                newFileName = newFileName.concat(patentList.get(j).getAttachFile()+"+");
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
