package com.ruoyi.project.system.sciResSubject.tools;

import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.sciResSubject.domain.SciResSubjectFileNameConfig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SciResResolvedNameRule {
    /**
     * 获取论文解析后的文件地址和命名规范
     * @param sciResList sciRes的所有数据
     * @param compareFileNameList 要下载的所有数据库文件地址
     * @param fileType 文件类型
     * @param configList //数据库对于这个文件的命名规则数据
     * @return
     */
    public List<FileNameConfig> newNameAndOldFilePath(List<SciResSubjectFileNameConfig> sciResList, List<String> compareFileNameList, String fileType,
                                                      List<FileNameConfig> configList){
        List<FileNameConfig> fileNameConfigList = resolvedNamingRules(fileType,sciResList,compareFileNameList,
                configList);
        return fileNameConfigList;
    }

    /**
     * 解析文件命名规范
     * @param sciResList sciRes的所有数据
     * @param compareFileNameList 要下载的所有数据库文件地址
     * @param fileType 文件类型
     * @param configList //数据库对于这个文件的命名规则数据
     * @return
     */
    List<FileNameConfig> resolvedNamingRules(String fileType,List<SciResSubjectFileNameConfig> sciResList,List<String> compareFileNameList,
                                             List<FileNameConfig> configList){
        List<FileNameConfig> fileNameConfigList = new ArrayList<>();
        if(fileType.equals("科研课题")) {
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
                for(int j=0;j<sciResList.size();j++) {
                    if(compareFileNameList.get(i).equals(sciResList.get(j).getAttachFile())){
                        for(int k=0;k<intList.size();k++) {
                            if(intList.get(k)==0) {
//                                不做处理
//                                newFileName = newFileName.concat(sciResList.get(j).getSubjectId()+"+");
                            }else if(intList.get(k)==1){
                                newFileName = newFileName.concat(sciResList.get(j).getSubjectName()+"+");
                            }else if(intList.get(k)==2){
                                newFileName = newFileName.concat(sciResList.get(j).getSubjectLevel()+"+");
                            }else if(intList.get(k)==3){
                                newFileName = newFileName.concat(sciResList.get(j).getModerator()+"+");
                            }else if(intList.get(k)==4){
                                newFileName = newFileName.concat(sciResList.get(j).getModMajorId()+"+");
                            }else if(intList.get(k)==5){
                                newFileName = newFileName.concat(sciResList.get(j).getModParticipant()+"+");
                            }else if(intList.get(k)==6){
                                newFileName = newFileName.concat(sciResList.get(j).getFirstUnit()+"+");
                            }else if(intList.get(k)==7){
                                newFileName = newFileName.concat(sciResList.get(j).getCooperUnit()+"+");
                            }else if(intList.get(k)==8){
                                newFileName = newFileName.concat(sciResList.get(j).getProjectDate()+"+");
                            }else if(intList.get(k)==9){
                                newFileName = newFileName.concat(sciResList.get(j).getGrants()+"+");
                            }else if(intList.get(k)==10){
                                newFileName = newFileName.concat(sciResList.get(j).getArrivalAmount()+"+");
                            }else if(intList.get(k)==11){
                                newFileName = newFileName.concat(sciResList.get(j).getConcludingDate()+"+");
                            }else if(intList.get(k)==12){
                                newFileName = newFileName.concat(sciResList.get(j).getProjectSource()+"+");
                            }else if(intList.get(k)==13){
                                newFileName = newFileName.concat(sciResList.get(j).getIsFinished()+"+");
                            }else if(intList.get(k)==14){
                                newFileName = newFileName.concat(sciResList.get(j).getIsFinishedOnTime()+"+");
                            }else if(intList.get(k)==15){
                                newFileName = newFileName.concat(sciResList.get(j).getAttachFile()+"+");
                            }else if(intList.get(k)==16){
                                newFileName = newFileName.concat(sciResList.get(j).getNotes()+"+");
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
