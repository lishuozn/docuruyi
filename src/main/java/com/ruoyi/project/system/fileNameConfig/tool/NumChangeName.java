package com.ruoyi.project.system.fileNameConfig.tool;

import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;

import java.util.ArrayList;
import java.util.List;


public class NumChangeName {
    /**
     * 文件命名配置修改页面
     * @param fileNameConfig
     * @return FileNameConfig
     */
    public static FileNameConfig anayle(FileNameConfig fileNameConfig){
        if (fileNameConfig.getFileType().equals("论文")) {
            fileNameConfig.setFileDictType("doc_manage_paper");
        }else if (fileNameConfig.getFileType().equals("专著")) {
            fileNameConfig.setFileDictType("treatise");
        }else if (fileNameConfig.getFileType().equals("教材")) {
            fileNameConfig.setFileDictType("text_book");
        }else if (fileNameConfig.getFileType().equals("科研课题")) {
            fileNameConfig.setFileDictType("sys_sci_res_subject");
        }else if (fileNameConfig.getFileType().equals("教改课题")) {
            fileNameConfig.setFileDictType("teacher_rewards");
        }else if (fileNameConfig.getFileType().equals("教师奖励")) {
            fileNameConfig.setFileDictType("teacher_rewards");
        }else if (fileNameConfig.getFileType().equals("学科竞赛获奖")) {
            fileNameConfig.setFileDictType("Subject_competition_award");
        }else if (fileNameConfig.getFileType().equals("发明专利")) {
            fileNameConfig.setFileDictType("invent_patent");
        }else if (fileNameConfig.getFileType().equals("实用新型专利")) {
            fileNameConfig.setFileDictType("practical_new_type_patent");
        }else if (fileNameConfig.getFileType().equals("软件著作权")) {
            fileNameConfig.setFileDictType("software_copyright");
        }else if (fileNameConfig.getFileType().equals("平台等立项文件")) {
            fileNameConfig.setFileDictType("platform_and_other_project");
        }
        return fileNameConfig;
    }

    /**
     * 文件命名配置查询页面
     * @param fileNameConfig
     * @return
     */
    public static String anayleListPage(FileNameConfig fileNameConfig){
        String[] nameRules = fileNameConfig.getNameRule().split("\\+");
        List<Integer> integerList = new ArrayList<>();
        for(int i=0;i<4;i++) {
            if(nameRules.length>i) {
                if(nameRules[i].equals("")) {
                    integerList.add(0);
                }else {
                    integerList.add(Integer.parseInt(nameRules[i]));
                }
            }else{
                integerList.add(0);
            }
        }
        /** 数字转为字符串后，新的命名规则 **/
        String newName = "";
        if (fileNameConfig.getFileType().equals("论文")) {
            newName = anayleDocPage(integerList);
        }else if (fileNameConfig.getFileType().equals("专著")) {
            newName = anayleTreatise(integerList);
        }else if (fileNameConfig.getFileType().equals("教材")) {
            newName = anayleTextBook(integerList);
        }else if (fileNameConfig.getFileType().equals("科研课题")) {
            newName = anayleSysSciResSubject(integerList);
        }else if (fileNameConfig.getFileType().equals("教改课题")) {
            newName = anayleEducReformSubject(integerList);
        }else if (fileNameConfig.getFileType().equals("教师奖励")) {
            newName = anayleTeacherRewards(integerList);
        }else if (fileNameConfig.getFileType().equals("学科竞赛获奖")) {
            newName = anayleSubjectCompetitionAward(integerList);
        }else if (fileNameConfig.getFileType().equals("发明专利")) {
            newName = anayleInventPatent(integerList);
        }else if (fileNameConfig.getFileType().equals("实用新型专利")) {
            newName = anaylePracticalNewTypePatent(integerList);
        }else if (fileNameConfig.getFileType().equals("软件著作权")) {
            newName = anayleSoftwareCopyright(integerList);
        }else if (fileNameConfig.getFileType().equals("平台等立项文件")) {
            newName = anaylePlatformAndOtherProject(integerList);
        }
        return newName;
    }

    /**
     * 论文命名解析
     * @param integerList
     * @return
     */
    private static String anayleDocPage(List<Integer> integerList){
        String newName = "";
        for(int i=0;i<integerList.size();i++) {
            if(integerList.get(i) == 0) {
                //不做处理
            }else if(integerList.get(i) == 1) {
                newName = newName.concat("论文类别"+"+");
            }else if(integerList.get(i) == 2) {
                newName = newName.concat("论文题目"+"+");
            }else if(integerList.get(i) == 3) {
                newName = newName.concat("一作名字"+"+");
            }else if(integerList.get(i) == 4) {
                newName = newName.concat("一作专业"+"+");
            }else if(integerList.get(i) == 5) {
                newName = newName.concat("二作名字"+"+");
            }else if(integerList.get(i) == 6) {
                newName = newName.concat("二作专业"+"+");
            }else if(integerList.get(i) == 7) {
                newName = newName.concat("其它作者名字"+"+");
            }else if(integerList.get(i) == 8) {
                newName = newName.concat("第一单位"+"+");
            }else if(integerList.get(i) == 9) {
                newName = newName.concat("第二单位"+"+");
            }else if(integerList.get(i) == 10) {
                newName = newName.concat("期刊名"+"+");
            }else if(integerList.get(i) == 11) {
                newName = newName.concat("刊号"+"+");
            }else if(integerList.get(i) == 12) {
                newName = newName.concat("期刊检索号"+"+");
            }else if(integerList.get(i) == 13) {
                newName = newName.concat("出版日期"+"+");
            }else if(integerList.get(i) == 14) {
                newName = newName.concat("卷号"+"+");
            }else if(integerList.get(i) == 15) {
                newName = newName.concat("起始页码"+"+");
            }else if(integerList.get(i) == 16) {
                newName = newName.concat("终止页码"+"+");
            }else if(integerList.get(i) == 17) {
                newName = newName.concat("基金"+"+");
            }else if(integerList.get(i) == 18) {
                newName = newName.concat("校内认定级别"+"+");
            }
        }
        return newName;
    }

    /**
     * 教材命名解析
     * @param integerList
     * @return
     */
    private static String anayleTreatise(List<Integer> integerList){
        String newName = "";
        for(int i=0;i<integerList.size();i++) {
            if(integerList.get(i) == 0) {
                //不做处理
            }else if(integerList.get(i) == 1) {
                newName = newName.concat("专著名称"+"+");
            }else if(integerList.get(i) == 2) {
                newName = newName.concat("第一作者"+"+");
            }else if(integerList.get(i) == 3) {
                newName = newName.concat("第一作者所在专业"+"+");
            }else if(integerList.get(i) == 4) {
                newName = newName.concat("第二作者"+"+");
            }else if(integerList.get(i) == 5) {
                newName = newName.concat("第二作者所在专业"+"+");
            }else if(integerList.get(i) == 6) {
                newName = newName.concat("其他作者"+"+");
            }else if(integerList.get(i) == 7) {
                newName = newName.concat("出版社"+"+");
            }else if(integerList.get(i) == 8) {
                newName = newName.concat("出版时间"+"+");
            }else if(integerList.get(i) == 9) {
                newName = newName.concat("出版社级别"+"+");
            }
        }
        return newName;
    }

    /**
     * 教材命名解析
     * @param integerList
     * @return
     */
    private static String anayleTextBook(List<Integer> integerList){
        String newName = "";
        for(int i=0;i<integerList.size();i++) {
            if(integerList.get(i) == 0) {
                //不做处理
            }else if(integerList.get(i) == 1) {
                newName = newName.concat("教材名称"+"+");
            }else if(integerList.get(i) == 2) {
                newName = newName.concat("教材类别"+"+");
            }else if(integerList.get(i) == 3) {
                newName = newName.concat("第一作者"+"+");
            }else if(integerList.get(i) == 4) {
                newName = newName.concat("第一作者所在专业"+"+");
            }else if(integerList.get(i) == 5) {
                newName = newName.concat("第二作者"+"+");
            }else if(integerList.get(i) == 6) {
                newName = newName.concat("第二作者所在专业"+"+");
            }else if(integerList.get(i) == 7) {
                newName = newName.concat("其它作者"+"+");
            }else if(integerList.get(i) == 8) {
                newName = newName.concat("出版社"+"+");
            }else if(integerList.get(i) == 9) {
                newName = newName.concat("出版社级别"+"+");
            }else if(integerList.get(i) == 10) {
                newName = newName.concat("出版时间"+"+");
            }else if(integerList.get(i) == 11) {
                newName = newName.concat("ISSN编号"+"+");
            }
        }
        return newName;
    }

    /**
     * 科研课题命名解析
     * @param integerList
     * @return
     */
    private static String anayleSysSciResSubject(List<Integer> integerList){
        String newName = "";
        for(int i=0;i<integerList.size();i++) {
            if(integerList.get(i) == 0) {
                //不做处理
            }else if(integerList.get(i) == 1) {
                newName = newName.concat("科研课题名称"+"+");
            }else if(integerList.get(i) == 2) {
                newName = newName.concat("科研课题级别"+"+");
            }else if(integerList.get(i) == 3) {
                newName = newName.concat("主持人"+"+");
            }else if(integerList.get(i) == 4) {
                newName = newName.concat("主持人所在专业"+"+");
            }else if(integerList.get(i) == 5) {
                newName = newName.concat("主持人参与人"+"+");
            }else if(integerList.get(i) == 6) {
                newName = newName.concat("第一单位"+"+");
            }else if(integerList.get(i) == 7) {
                newName = newName.concat("合作单位"+"+");
            }else if(integerList.get(i) == 8) {
                newName = newName.concat("立项时间"+"+");
            }else if(integerList.get(i) == 9) {
                newName = newName.concat("资助金额"+"+");
            }else if(integerList.get(i) == 10) {
                newName = newName.concat("到账金额"+"+");
            }else if(integerList.get(i) == 11) {
                newName = newName.concat("结题时间"+"+");
            }else if(integerList.get(i) == 12) {
                newName = newName.concat("项目来源"+"+");
            }else if(integerList.get(i) == 13) {
                newName = newName.concat("是否已结题"+"+");
            }else if(integerList.get(i) == 14) {
                newName = newName.concat("是否按期结题"+"+");
            }
        }
        return newName;
    }
    /**
     * 教改课题命名解析
     * @param integerList
     * @return
     */
    private static String anayleEducReformSubject(List<Integer> integerList){
        String newName = "";
        for(int i=0;i<integerList.size();i++) {
            if(integerList.get(i) == 0) {
                //不做处理
            }else if(integerList.get(i) == 1) {
                newName = newName.concat("教改课题名称"+"+");
            }else if(integerList.get(i) == 2) {
                newName = newName.concat("教改课题级别"+"+");
            }else if(integerList.get(i) == 3) {
                newName = newName.concat("主持人"+"+");
            }else if(integerList.get(i) == 4) {
                newName = newName.concat("主持人所在专业"+"+");
            }else if(integerList.get(i) == 5) {
                newName = newName.concat("参与人"+"+");
            }else if(integerList.get(i) == 6) {
                newName = newName.concat("第一单位"+"+");
            }else if(integerList.get(i) == 7) {
                newName = newName.concat("立项时间"+"+");
            }else if(integerList.get(i) == 8) {
                newName = newName.concat("资助金额"+"+");
            }else if(integerList.get(i) == 9) {
                newName = newName.concat("到账金额"+"+");
            }else if(integerList.get(i) == 10) {
                newName = newName.concat("结题时间"+"+");
            }else if(integerList.get(i) == 11) {
                newName = newName.concat("项目来源"+"+");
            }else if(integerList.get(i) == 12) {
                newName = newName.concat("是否已结题"+"+");
            }else if(integerList.get(i) == 13) {
                newName = newName.concat("是否按期结题"+"+");
            }
        }
        return newName;
    }
    /**
     * 教师奖励命名解析
     * @param integerList
     * @return
     */
    private static String anayleTeacherRewards(List<Integer> integerList){
        String newName = "";
        for(int i=0;i<integerList.size();i++) {
            if(integerList.get(i) == 0) {
                //不做处理
            }else if(integerList.get(i) == 1) {
                newName = newName.concat("奖励名称"+"+");
            }else if(integerList.get(i) == 2) {
                newName = newName.concat("第一完成人"+"+");
            }else if(integerList.get(i) == 3) {
                newName = newName.concat("第一完成人所在专业"+"+");
            }else if(integerList.get(i) == 4) {
                newName = newName.concat("第二完成人"+"+");
            }else if(integerList.get(i) == 5) {
                newName = newName.concat("第二完成人所在专业"+"+");
            }else if(integerList.get(i) == 6) {
                newName = newName.concat("第三完成人"+"+");
            }else if(integerList.get(i) == 7) {
                newName = newName.concat("第三完成人所在专业"+"+");
            }else if(integerList.get(i) == 8) {
                newName = newName.concat("第一单位"+"+");
            }else if(integerList.get(i) == 9) {
                newName = newName.concat("合作单位"+"+");
            }else if(integerList.get(i) == 10) {
                newName = newName.concat("奖励级别"+"+");
            }else if(integerList.get(i) == 11) {
                newName = newName.concat("奖励来源"+"+");
            }else if(integerList.get(i) == 12) {
                newName = newName.concat("奖励等级"+"+");
            }else if(integerList.get(i) == 13) {
                newName = newName.concat("奖励时间"+"+");
            }
        }
        return newName;
    }
    /**
     * 学科竞赛获奖命名解析
     * @param integerList
     * @return
     */
    private static String anayleSubjectCompetitionAward(List<Integer> integerList){
        String newName = "";
        for(int i=0;i<integerList.size();i++) {
            if(integerList.get(i) == 0) {
                //不做处理
            }else if(integerList.get(i) == 1) {
                newName = newName.concat("获奖作品名称"+"+");
            }else if(integerList.get(i) == 2) {
                newName = newName.concat("参与竞赛名称"+"+");
            }else if(integerList.get(i) == 3) {
                newName = newName.concat("竞赛获奖级别"+"+");
            }else if(integerList.get(i) == 4) {
                newName = newName.concat("获奖等级"+"+");
            }else if(integerList.get(i) == 5) {
                newName = newName.concat("举办时间"+"+");
            }else if(integerList.get(i) == 6) {
                newName = newName.concat("获奖时间"+"+");
            }
        }
        return newName;
    }
    /**
     * 发明专利命名解析
     * @param integerList
     * @return
     */
    private static String anayleInventPatent(List<Integer> integerList){
        String newName = "";
        for(int i=0;i<integerList.size();i++) {
            if(integerList.get(i) == 0) {
                //不做处理
            }else if(integerList.get(i) == 1) {
                newName = newName.concat("专利名称"+"+");
            }else if(integerList.get(i) == 2) {
                newName = newName.concat("专利状态"+"+");
            }else if(integerList.get(i) == 3) {
                newName = newName.concat("专利号"+"+");
            }else if(integerList.get(i) == 4) {
                newName = newName.concat("第一发明人"+"+");
            }else if(integerList.get(i) == 5) {
                newName = newName.concat("第一发明人所在专业"+"+");
            }else if(integerList.get(i) == 6) {
                newName = newName.concat("其它发明人"+"+");
            }else if(integerList.get(i) == 7) {
                newName = newName.concat("专利权人"+"+");
            }else if(integerList.get(i) == 8) {
                newName = newName.concat("申请时间"+"+");
            }else if(integerList.get(i) == 9) {
                newName = newName.concat("实审时间"+"+");
            }else if(integerList.get(i) == 10) {
                newName = newName.concat("授权公告日"+"+");
            }
        }
        return newName;
    }
    /**
     * 实用新型专利命名解析
     * @param integerList
     * @return
     */
    private static String anaylePracticalNewTypePatent(List<Integer> integerList){
        String newName = "";
        for(int i=0;i<integerList.size();i++) {
            if(integerList.get(i) == 0) {
                //不做处理
            }else if(integerList.get(i) == 1) {
                newName = newName.concat("专利名称"+"+");
            }else if(integerList.get(i) == 2) {
                newName = newName.concat("专利号"+"+");
            }else if(integerList.get(i) == 3) {
                newName = newName.concat("第一发明人"+"+");
            }else if(integerList.get(i) == 4) {
                newName = newName.concat("第一发明人所在专业"+"+");
            }else if(integerList.get(i) == 5) {
                newName = newName.concat("其它发明人"+"+");
            }else if(integerList.get(i) == 6) {
                newName = newName.concat("专利权人"+"+");
            }else if(integerList.get(i) == 7) {
                newName = newName.concat("授权公告日"+"+");
            }
        }
        return newName;
    }
    /**
     * 软件著作权命名解析
     * @param integerList
     * @return
     */
    private static String anayleSoftwareCopyright(List<Integer> integerList){
        String newName = "";
        for(int i=0;i<integerList.size();i++) {
            if(integerList.get(i) == 0) {
                //不做处理
            }else if(integerList.get(i) == 1) {
                newName = newName.concat("著作权名称"+"+");
            }else if(integerList.get(i) == 2) {
                newName = newName.concat("登记号"+"+");
            }else if(integerList.get(i) == 3) {
                newName = newName.concat("第一著作权人"+"+");
            }else if(integerList.get(i) == 4) {
                newName = newName.concat("第一著作权人专业"+"+");
            }else if(integerList.get(i) == 5) {
                newName = newName.concat("其它著作权人"+"+");
            }else if(integerList.get(i) == 6) {
                newName = newName.concat("开发完成时间"+"+");
            }else if(integerList.get(i) == 7) {
                newName = newName.concat("登记时间"+"+");
            }
        }
        return newName;
    }

    /**
     * 平台等立项文件命名解析
     * @param integerList
     * @return
     */
    private static String anaylePlatformAndOtherProject(List<Integer> integerList){
        String newName = "";
        for(int i=0;i<integerList.size();i++) {
            if(integerList.get(i) == 0) {
                //不做处理
            }else if(integerList.get(i) == 1) {
                newName = newName.concat("\t平台名称"+"+");
            }else if(integerList.get(i) == 2) {
                newName = newName.concat("\t立项文件级别"+"+");
            }else if(integerList.get(i) == 3) {
                newName = newName.concat("\t主持人"+"+");
            }else if(integerList.get(i) == 4) {
                newName = newName.concat("立项时间"+"+");
            }else if(integerList.get(i) == 5) {
                newName = newName.concat("资助金额"+"+");
            }
        }
        return newName;
    }
}
