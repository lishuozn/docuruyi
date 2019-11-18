package com.ruoyi.project.system.softwareCopyright.tool;

import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.fileNameConfig.service.FileNameConfigServiceImpl;
import com.ruoyi.project.system.softwareCopyright.domain.SoftwareCopyrightForFileNameConfig;

import java.util.ArrayList;
import java.util.List;

public class SoftwareCopyrightResolvedNameRule {

    /**
     * 获取软件著作权解析后的文件地址和命名规范
     * @param
     * @param compareFileNameList
     * @param fileType
     * @param configList
     * @return
     */
    public List<FileNameConfig> newNameAndOldFilePath(List<SoftwareCopyrightForFileNameConfig> softwareCopyrightList, List<String> compareFileNameList, String fileType,
                                                      List<FileNameConfig> configList){
        List<FileNameConfig> fileNameConfigList = resolvedNamingRules(fileType,softwareCopyrightList,compareFileNameList,
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
    List<FileNameConfig> resolvedNamingRules(String fileType,List<SoftwareCopyrightForFileNameConfig> softwareCopyrightList,List<String> compareFileNameList,
                                             List<FileNameConfig> configList){
        String nameRule = "";
        List<FileNameConfig> fileNameConfigList = new ArrayList<>();
        if(fileType.equals("软件著作权")) {
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
                for(int j=0;j<softwareCopyrightList.size();j++) {
                    if(compareFileNameList.get(i).equals(softwareCopyrightList.get(j).getAttachFile())){
                        for(int k=0;k<intList.size();k++) {
                            if(intList.get(k)==1) {
                                newFileName = newFileName.concat(softwareCopyrightList.get(j).getCopyrightId()+"+");
                            }else if(intList.get(k)==2){
                                newFileName = newFileName.concat(softwareCopyrightList.get(j).getCopyrightName()+"+");
                            }else if(intList.get(k)==3){
                                newFileName = newFileName.concat(softwareCopyrightList.get(j).getRegistrationId()+"+");
                            }else if(intList.get(k)==4){
                                newFileName = newFileName.concat(softwareCopyrightList.get(j).getFirstCopyrightOwner()+"+");
                            }else if(intList.get(k)==5){
                                newFileName = newFileName.concat(softwareCopyrightList.get(j).getFirstCopyrightOwnerMajorId()+"+");
                            }else if(intList.get(k)==6){
                                newFileName = newFileName.concat(softwareCopyrightList.get(j).getOtherCopyrightOwner()+"+");
                            }else if(intList.get(k)==7){
                                newFileName = newFileName.concat(softwareCopyrightList.get(j).getConcurrentCompletionDate()+"+");
                            }else if(intList.get(k)==8){
                                newFileName = newFileName.concat(softwareCopyrightList.get(j).getAttachFile()+"+");
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
