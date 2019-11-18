package com.ruoyi.project.system.award.tools;

import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.award.domain.Award;
import com.ruoyi.project.system.award.domain.AwardVO;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.dept.service.IDeptService;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
public class AwardFileNameRuleResolver {

    @Resource
    public static IDeptService deptService;

    public static List<FileNameConfig> resolveRule(List<Integer> ruleItems, List<AwardVO> AwardList){

        List<FileNameConfig> configs = new ArrayList<>();

        for (AwardVO award:AwardList){
            String filename ="";

            FileNameConfig config = new FileNameConfig();
            config.setFileType(RuoYiConfig.getUploadPath() +award.getAttachFile());

            for (Integer rule:ruleItems){
                switch (rule){
                    case 1:filename+= String.valueOf(award.getAwardId()) +"+";break;
                    case 2:filename+= award.getAwardName() +"+";break;
                    case 3:filename+= award.getFirstWinner() +"+";break;
                    case 4:filename+= award.getFirstWinnerMajor().getDeptName()+"+";break;
                    case 5:filename+= award.getSecondWinner() +"+";break;
                    case 6:filename+= award.getSecondWinnerMajor().getDeptName() +"+";break;
                    case 7:filename+= award.getThirdWinner() +"+";break;
                    case 8:filename+= award.getThirdWinnerMajor().getDeptName() +"+";break;
                    case 9:filename+= award.getFirstDept() +"+";break;
                    case 10:filename+= award.getWorkWithDept() +"+";break;
                    case 11:filename+= award.getAwardLeval() +"+";break;
                    case 12:filename+= award.getAwardFrom() +"+";break;
                    case 13:filename+= award.getAwardNumber() +"+";break;
                    case 14:filename+= award.getAwardDate() +"+";break;
                    case 15:filename+= award.getAttachFile() +"+";break;
                    case 16:filename+= award.getNote() +"+";break;
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
