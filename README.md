# docuruyi
# docuruyi-branch yelihu
@author:yelihu
# 要修改的地方
**application.yml line13** 
 
    #  profile: D:/profile/
      profile: /Users/apple/IdeaProjects/RuoYi-fast/profile
      
 
***
**application-druid.yml line8**

    master:
        url: jdbc:mysql://localhost:3306/ry?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
        username: root
        password: a87160265
****
**logback.xml line5**
  
    <property name="log.path" value="/Users/apple/IdeaProjects/RuoYi-fast/home/ruoyi/logs" />

**注意：mac开发的log文件在项目文件 /Users/apple/IdeaProjects/docuruyi/home/ruoyi/logs 该路径下**

### 2019年08月05日15:30 
  第一次提交，环境部署完成：publication 出版物功能完成添加，成功上传。
