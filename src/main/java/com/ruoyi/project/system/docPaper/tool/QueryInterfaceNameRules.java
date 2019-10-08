package com.ruoyi.project.system.docPaper.tool;

import java.util.ArrayList;
import java.util.List;

public class QueryInterfaceNameRules {

    public static String resolveNameByType(String type,String nameRule) {
        String newNameRule = "";
        if(type.equals("论文")) {
            return transform(nameRule);
        }
        return newNameRule;
    }

    /**
     * 论文命名规则字符串的转化
     * @return List<Integer>
     */
    static String transform(String nameRule) {
        String[] nameRules = nameRule.split("\\+");
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
        String newNameRule = "";
        for(int i=0;i<integerList.size();i++) {
            if(integerList.get(i) == 0) {
                //不做处理
            }else if(integerList.get(i) == 1) {
                newNameRule = newNameRule.concat("论文类别"+"+");
            }else if(integerList.get(i) == 2) {
                newNameRule = newNameRule.concat("论文题目"+"+");
            }else if(integerList.get(i) == 3) {
                newNameRule = newNameRule.concat("一作名字"+"+");
            }else if(integerList.get(i) == 4) {
                newNameRule = newNameRule.concat("一作专业"+"+");
            }else if(integerList.get(i) == 5) {
                newNameRule = newNameRule.concat("二作名字"+"+");
            }else if(integerList.get(i) == 6) {
                newNameRule = newNameRule.concat("二作专业"+"+");
            }else if(integerList.get(i) == 7) {
                newNameRule = newNameRule.concat("其它作者名字"+"+");
            }else if(integerList.get(i) == 8) {
                newNameRule = newNameRule.concat("第一单位"+"+");
            }else if(integerList.get(i) == 9) {
                newNameRule = newNameRule.concat("第二单位"+"+");
            }else if(integerList.get(i) == 10) {
                newNameRule = newNameRule.concat("期刊名"+"+");
            }else if(integerList.get(i) == 11) {
                newNameRule = newNameRule.concat("刊号"+"+");
            }else if(integerList.get(i) == 12) {
                newNameRule = newNameRule.concat("期刊检索号"+"+");
            }else if(integerList.get(i) == 13) {
                newNameRule = newNameRule.concat("出版日期"+"+");
            }else if(integerList.get(i) == 14) {
                newNameRule = newNameRule.concat("卷号"+"+");
            }else if(integerList.get(i) == 15) {
                newNameRule = newNameRule.concat("起始页码"+"+");
            }else if(integerList.get(i) == 16) {
                newNameRule = newNameRule.concat("终止页码"+"+");
            }else if(integerList.get(i) == 17) {
                newNameRule = newNameRule.concat("基金"+"+");
            }else if(integerList.get(i) == 18) {
                newNameRule = newNameRule.concat("校内认定级别"+"+");
            }
        }
        return newNameRule;
    }
}
