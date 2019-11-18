package com.ruoyi.project.system.teachingSubject.tool;

import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.fileNameConfig.service.FileNameConfigServiceImpl;

import com.ruoyi.project.system.teachingSubject.domain.TeachingSubjectForFileNameConfig;


import java.util.ArrayList;
import java.util.List;

public class TeachingResolvedNameRule {

    /**
     * 获取论文解析后的文件地址和命名规范
     * @param
     * @param compareFileNameList
     * @param fileType
     * @param configList
     * @return
     */
    public List<FileNameConfig> newNameAndOldFilePath(List<TeachingSubjectForFileNameConfig> teachingSubjectList, List<String> compareFileNameList, String fileType,
                                                      List<FileNameConfig> configList){
        List<FileNameConfig> fileNameConfigList = resolvedNamingRules(fileType,teachingSubjectList,compareFileNameList,
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
    List<FileNameConfig> resolvedNamingRules(String fileType,List<TeachingSubjectForFileNameConfig> teachingSubjectList,List<String> compareFileNameList,
                                             List<FileNameConfig> configList){
        String nameRule = "";
        List<FileNameConfig> fileNameConfigList = new ArrayList<>();
        if(fileType.equals("教改课题")) {
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
                for(int j=0;j<teachingSubjectList.size();j++) {
                    if(compareFileNameList.get(i).equals(teachingSubjectList.get(j).getAttachFile())){
                        for(int k=0;k<intList.size();k++) {
                            if(intList.get(k)==1) {
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getSubjectId()+"+");
                            }else if(intList.get(k)==2){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getSubjectName()+"+");
                            }else if(intList.get(k)==3){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getSubjectLevel()+"+");
                            }else if(intList.get(k)==4){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getModerator()+"+");
                            }else if(intList.get(k)==5){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getModMajorId()+"+");
                            }else if(intList.get(k)==6){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getModParticipant()+"+");
                            }else if(intList.get(k)==7){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getFirstUnit()+"+");
                            }else if(intList.get(k)==8){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getProjectDate()+"+");
                            }else if(intList.get(k)==9){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getGrants()+"+");
                            }else if(intList.get(k)==10){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getArrivalAmount()+"+");
                            }else if(intList.get(k)==11){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getConcludingDate()+"+");
                            }else if(intList.get(k)==12){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getProjectSource()+"+");
                            }else if(intList.get(k)==13){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getIsFinished()+"+");
                            }else if(intList.get(k)==14){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getIsFinishedOnTime()+"+");
                            }else if(intList.get(k)==15){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getAttachFile()+"+");
                            }else if(intList.get(k)==16){
                                newFileName = newFileName.concat(teachingSubjectList.get(j).getNotes()+"+");
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
