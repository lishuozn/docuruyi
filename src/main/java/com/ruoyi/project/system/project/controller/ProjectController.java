package com.ruoyi.project.system.project.controller;

import java.util.List;
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
import com.ruoyi.project.system.project.domain.Project;
import com.ruoyi.project.system.project.service.IProjectService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 平台等立项文件信息操作处理
 * 
 * @author daivd
 * @date 2019-11-10
 */
@Controller
@RequestMapping("/system/project")
public class ProjectController extends BaseController
{
    private String prefix = "system/project";
	
	@Autowired
	private IProjectService projectService;
	
	@RequiresPermissions("system:project:view")
	@GetMapping()
	public String project()
	{
	    return prefix + "/project";
	}
	
	/**
	 * 查询平台等立项文件列表
	 */
	@RequiresPermissions("system:project:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Project project)
	{
		startPage();
        List<Project> list = projectService.selectProjectList(project);
		return getDataTable(list);
	}


	@GetMapping("/detail/{projectId}")
	public String detail(@PathVariable("projectId") Integer projectId, ModelMap mmap)
	{
		Project project = projectService.selectProjectById(projectId);

		mmap.put("project", project);
		return prefix + "/detail";
	}
	
	/**
	 * 导出平台等立项文件列表
	 */
	@RequiresPermissions("system:project:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Project project)
    {
    	List<Project> list = projectService.selectProjectList(project);
        ExcelUtil<Project> util = new ExcelUtil<Project>(Project.class);
        return util.exportExcel(list, "project");
    }
	
	/**
	 * 新增平台等立项文件
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存平台等立项文件
	 */
	@RequiresPermissions("system:project:add")
	@Log(title = "平台等立项文件", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Project project)
	{		
		return toAjax(projectService.insertProject(project));
	}

	/**
	 * 修改平台等立项文件
	 */
	@GetMapping("/edit/{projectId}")
	public String edit(@PathVariable("projectId") Integer projectId, ModelMap mmap)
	{
		Project project = projectService.selectProjectById(projectId);
		mmap.put("project", project);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存平台等立项文件
	 */
	@RequiresPermissions("system:project:edit")
	@Log(title = "平台等立项文件", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Project project)
	{		
		return toAjax(projectService.updateProject(project));
	}
	
	/**
	 * 删除平台等立项文件
	 */
	@RequiresPermissions("system:project:remove")
	@Log(title = "平台等立项文件", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(projectService.deleteProjectByIds(ids));
	}
	
}
