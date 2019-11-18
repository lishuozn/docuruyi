package com.ruoyi.project.system.publication.tools;

import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.publication.domain.PublicationVO;

import java.util.ArrayList;
import java.util.List;

public class PublicationFileNameRuleResolver {

    public static List<FileNameConfig> resolveRule(List<Integer> ruleItems, List<PublicationVO> publicationVOList){

        List<FileNameConfig> configs = new ArrayList<>();

        for (PublicationVO pb:publicationVOList){
            String filename ="";

            FileNameConfig config = new FileNameConfig();
            String pbFileName = pb.getAttachFile();
            config.setFileType(RuoYiConfig.getUploadPath() +pb.getAttachFile());

            for (Integer rule:ruleItems){
                switch (rule){
                    case 1:filename+=String.valueOf(pb.getPbId()+"+");break;
                    case 2:filename+=pb.getPbKind()+"+";break;
                    case 3:filename+=pb.getPbTitle() +"+";break;
                    case 4:filename+=String.valueOf(pb.getAuthor1Id()+"+");break;
                    case 5:filename+=pb.getAuthor1Name()+"+";break;
                    case 6:filename+=pb.getAuthor1Major().getDeptName()+"+";break;
                    case 7:filename+=String.valueOf(pb.getAuthor2Id())+"+";break;
                    case 8:filename+=pb.getAuthor2Name()+"+";break;
                    case 9:filename+=pb.getAuthor2Major().getDeptName()+"+";break;
                    case 10:filename+=pb.getAuthorNameOther()+"+";break;
                    case 11:filename+=pb.getPublisherName()+"+";break;
                    case 12:filename+=pb.getPublisherLevel();break;
                    case 13:filename+=pb.getPublishDate().toString()+"+";break;
                    case 14:filename+=pb.getIssnNumber()+"+";break;
                    case 15:filename+=pbFileName+"+";break;
                    case 16:filename+=pb.getNotes()+"+";break;
                    default:
                        throw new IllegalStateException("没有这个规则值，请检查属性和数值对应" + rule);
                }
            }
            config.setNameRule(filename);
            configs.add(config);
        }

        return configs;
    }

    //List<FileNameConfig> resolvedNamingRules(String fileType, List<PublicationFileNameConfig> pbNameList, List<String> compareFileNameList,
    //                                         List<FileNameConfig> configList){
    //
    //    List<FileNameConfig> fileNameConfigList = new ArrayList<>();
    //
    //    if(fileType.equals("出版物")) {
    //
    //        List<Integer> intList = new ArrayList<>();
    //
    //        for(int i=0;i<configList.size();i++) {
    //            String[] as = configList.get(i).getNameRule().split("\\+");
    //            for(int j=0;j<as.length;j++) {
    //                if(as[j].equals("")) {
    //                }else {
    //                    intList.add(Integer.parseInt(as[j]));
    //                }
    //            }
    //        }
    //
    //        String newFileName = "";
    //        for(int i=0;i<compareFileNameList.size();i++) {
    //            for(int j=0;j<pbNameList.size();j++) {
    //                if(compareFileNameList.get(i).equals(pbNameList.get(j).getAttachFile())){
    //                    for(int k=0;k<intList.size();k++) {
    //                        if(intList.get(k)==1) {
    //                            newFileName = newFileName.concat(pbNameList.get(j).getPbId()+"+");
    //                        }else if(intList.get(k)==2){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getPbKind()+"+");
    //                        }else if(intList.get(k)==3){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getPbTitle()+"+");
    //                        }else if(intList.get(k)==4){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getAuthor1Id()+"+");
    //                        }else if(intList.get(k)==5){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getAuthor1Name()+"+");
    //                        }else if(intList.get(k)==6){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getAuthor1MajorId()+"+");
    //                        }else if(intList.get(k)==7){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getAuthor2Id()+"+");
    //                        }else if(intList.get(k)==8){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getAuthor2Name()+"+");
    //                        }else if(intList.get(k)==9){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getAuthor2MajorId()+"+");
    //                        }else if(intList.get(k)==10){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getAuthorNameOther()+"+");
    //                        }else if(intList.get(k)==11){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getPublisherName()+"+");
    //                        }else if(intList.get(k)==12){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getPublishNumber()+"+");
    //                        }else if(intList.get(k)==13){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getPublisherLevel()+"+");
    //                        }else if(intList.get(k)==14){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getPublishDate()+"+");
    //                        }else if(intList.get(k)==15){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getIssnNumber()+"+");
    //                        }else if(intList.get(k)==16){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getAttachFile()+"+");
    //                        }else if(intList.get(k)==17){
    //                            newFileName = newFileName.concat(pbNameList.get(j).getNotes()+"+");
    //                        }
    //                    }
    //                }
    //            }
    //            FileNameConfig fileNameConfig = new FileNameConfig();
    //            fileNameConfig.setFileType("/Users/apple/IdeaProjects/ruoyi_doc/profile/"+compareFileNameList.get(i));
    //            fileNameConfig.setNameRule(newFileName);
    //            fileNameConfigList.add(fileNameConfig);
    //            newFileName = "";
    //        }//一层循环结束
    //    }//if结束
    //    return fileNameConfigList;
    //}
}
