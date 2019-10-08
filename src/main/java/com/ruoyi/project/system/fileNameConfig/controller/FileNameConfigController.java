package com.ruoyi.project.system.fileNameConfig.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.docPaper.tool.QueryInterfaceNameRules;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.fileNameConfig.service.IFileNameConfigService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 文件命名配置信息操作处理
 * 
 * @author daivd
 * @date 2019-08-30
 */
@Controller
@RequestMapping("/system/fileNameConfig")
public class FileNameConfigController extends BaseController
{
    private String prefix = "system/fileNameConfig";
	
	@Autowired
	private IFileNameConfigService fileNameConfigService;
	
	@RequiresPermissions("system:fileNameConfig:view")
	@GetMapping()
	public String fileNameConfig()
	{
	    return prefix + "/fileNameConfig";
	}
	
	/**
	 * 查询文件命名配置列表
	 */
	@RequiresPermissions("system:fileNameConfig:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FileNameConfig fileNameConfig)
	{
		startPage();
        List<FileNameConfig> list = fileNameConfigService.selectFileNameConfigList(fileNameConfig);
        List<FileNameConfig> newList = new ArrayList<>();
        for(int i=0;i<list.size();i++) {
            FileNameConfig fileNameConfig1 = list.get(i);
            String as = fileNameConfig1.getNameRule();
            fileNameConfig1.setNameRule(QueryInterfaceNameRules.resolveNameByType("论文",as));
            newList.add(fileNameConfig1);
        }
		return getDataTable(newList);
	}
	
	
	/**
	 * 导出文件命名配置列表
	 */
	@RequiresPermissions("system:fileNameConfig:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FileNameConfig fileNameConfig)
    {
    	List<FileNameConfig> list = fileNameConfigService.selectFileNameConfigList(fileNameConfig);
        ExcelUtil<FileNameConfig> util = new ExcelUtil<FileNameConfig>(FileNameConfig.class);
        return util.exportExcel(list, "fileNameConfig");
    }
	
	/**
	 * 新增文件命名配置
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存文件命名配置
	 */
	@RequiresPermissions("system:fileNameConfig:add")
	@Log(title = "文件命名配置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FileNameConfig fileNameConfig)
	{
		return toAjax(fileNameConfigService.insertFileNameConfig(fileNameConfig));
	}

	/**
	 * 修改文件命名配置
	 */
	@GetMapping("/edit/{fileNameId}")
	public String edit(@PathVariable("fileNameId") Integer fileNameId, ModelMap mmap)
	{
		FileNameConfig fileNameConfig = fileNameConfigService.selectFileNameConfigById(fileNameId);
		mmap.put("fileNameConfig", fileNameConfig);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存文件命名配置
	 */
	@RequiresPermissions("system:fileNameConfig:edit")
	@Log(title = "文件命名配置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FileNameConfig fileNameConfig)
	{		
		return toAjax(fileNameConfigService.updateFileNameConfig(fileNameConfig));
	}
	
	/**
	 * 删除文件命名配置
	 */
	@RequiresPermissions("system:fileNameConfig:remove")
	@Log(title = "文件命名配置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fileNameConfigService.deleteFileNameConfigByIds(ids));
	}
	
}
