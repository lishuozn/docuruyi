package com.ruoyi.project.system.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.user.domain.AttachFileNumber;
import com.ruoyi.project.system.user.service.IMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.system.menu.domain.Menu;
import com.ruoyi.project.system.menu.service.IMenuService;
import com.ruoyi.project.system.user.domain.User;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private IMenuService menuService;

    @Autowired
    private RuoYiConfig ruoYiConfig;

    @Autowired
    private IMainService mainService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        User user = getSysUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", ruoYiConfig.getCopyrightYear());
        mmap.put("demoEnabled", ruoYiConfig.isDemoEnabled());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        AttachFileNumber attachFileNumber = mainService.selectAttachFileNumber();
        Map attrNameMap = new HashMap<String,Integer>();

        attrNameMap.put("教师奖励信息",attachFileNumber.getAward());
        attrNameMap.put("论文信息",attachFileNumber.getDocPaper());
        attrNameMap.put("出版物信息",attachFileNumber.getPublication());

        mmap.addAttribute("attrNameMap",attrNameMap);
        return "main";
    }
}
