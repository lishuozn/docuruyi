package com.ruoyi.project.system.invention.tools;

import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.invention.domain.InventionVO;
import com.ruoyi.project.system.dept.service.IDeptService;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class InventionFileNameRuleResolver {

    @Resource
    public static IDeptService deptService;

    public static List<FileNameConfig> resolveRule(List<Integer> ruleItems, List<InventionVO> inventionList){

        List<FileNameConfig> configs = new ArrayList<>();

        for (InventionVO invention:inventionList){
            String filename ="";

            FileNameConfig config = new FileNameConfig();
            config.setFileType(RuoYiConfig.getUploadPath() +invention.getAttachFile());

            for (Integer rule:ruleItems){
                switch (rule){
                    case 1:filename+= String.valueOf(invention.getInventionId()) +"+";break;
                    case 2:filename+= invention.getInventionName() +"+";break;
                    case 3:filename+= invention.getInventionState() +"+";break;
                    case 4:filename+= invention.getPatentNumber()+"+";break;
                    case 5:filename+= invention.getFirstInventor() +"+";break;
                    case 6:filename+= invention.getFirstInventorMajor().getDeptName() +"+";break;
                    case 7:filename+= invention.getOtherInventor() +"+";break;
                    case 8:filename+= invention.getPatentRightBelongsTo() +"+";break;
                    case 9:filename+= invention.getAppliedDate().toString() +"+";break;
                    case 10:filename+= invention.getExamDate().toString() +"+";break;
                    case 11:filename+= invention.getAnnouncementDate().toString() +"+";break;
                    default:
                        throw new IllegalStateException("没有这个规则值，请检查属性和数值对应" + rule);
                }
            }
            config.setNameRule(filename);
            configs.add(config);
        }

        return configs;
    }

}
