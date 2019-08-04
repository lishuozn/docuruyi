package com.ruoyi.project.system.docManagePaper.controller;

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
import com.ruoyi.project.system.docManagePaper.domain.DocManagePaper;
import com.ruoyi.project.system.docManagePaper.service.IDocManagePaperService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 佐证-论文信息操作处理
 * 
 * @author daivd
 * @date 2019-07-08
 */
@Controller
@RequestMapping("/system/docManagePaper")
public class DocManagePaperController extends BaseController
{
    private String prefix = "system/docManagePaper";
	
	@Autowired
	private IDocManagePaperService docManagePaperService;
	
	@RequiresPermissions("system:docManagePaper:view")
	@GetMapping()
	public String docManagePaper()
	{
	    return prefix + "/docManagePaper";
	}
	
	/**
	 * 查询佐证-论文列表
	 */
	@RequiresPermissions("system:docManagePaper:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(DocManagePaper docManagePaper)
	{
		startPage();
        List<DocManagePaper> list = docManagePaperService.selectDocManagePaperList(docManagePaper);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出佐证-论文列表
	 */
	@RequiresPermissions("system:docManagePaper:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DocManagePaper docManagePaper)
    {
    	List<DocManagePaper> list = docManagePaperService.selectDocManagePaperList(docManagePaper);
        ExcelUtil<DocManagePaper> util = new ExcelUtil<DocManagePaper>(DocManagePaper.class);
        return util.exportExcel(list, "docManagePaper");
    }
	
	/**
	 * 新增佐证-论文
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存佐证-论文
	 */
	@RequiresPermissions("system:docManagePaper:add")
	@Log(title = "佐证-论文", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(DocManagePaper docManagePaper)
	{		
		return toAjax(docManagePaperService.insertDocManagePaper(docManagePaper));
	}

	/**
	 * 修改佐证-论文
	 */
	@GetMapping("/edit/{paperId}")
	public String edit(@PathVariable("paperId") Integer paperId, ModelMap mmap)
	{
		DocManagePaper docManagePaper = docManagePaperService.selectDocManagePaperById(paperId);
		mmap.put("docManagePaper", docManagePaper);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存佐证-论文
	 */
	@RequiresPermissions("system:docManagePaper:edit")
	@Log(title = "佐证-论文", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(DocManagePaper docManagePaper)
	{		
		return toAjax(docManagePaperService.updateDocManagePaper(docManagePaper));
	}
	
	/**
	 * 删除佐证-论文
	 */
	@RequiresPermissions("system:docManagePaper:remove")
	@Log(title = "佐证-论文", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(docManagePaperService.deleteDocManagePaperByIds(ids));
	}
	
}
