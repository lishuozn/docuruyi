package com.ruoyi.project.system.invention.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.docPaper.tool.ZipCompress;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.fileNameConfig.service.IFileNameConfigService;
import com.ruoyi.project.system.invention.domain.InventionVO;
import com.ruoyi.project.system.invention.tools.InventionFileNameRuleResolver;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.invention.domain.Invention;
import com.ruoyi.project.system.invention.service.IInventionService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

/**
 * 发明专利信息操作处理
 * 
 * @author daivd
 * @date 2019-11-16
 */
@Controller
@RequestMapping("/system/invention")
public class InventionController extends BaseController
{
    private String prefix = "system/invention";

	@Autowired
	private IFileNameConfigService iFileNameConfigService;



	@Autowired
	private IInventionService inventionService;
	
	@RequiresPermissions("system:invention:view")
	@GetMapping()
	public String invention()
	{
	    return prefix + "/invention";
	}
	
	/**
	 * 查询发明专利列表
	 */
	@RequiresPermissions("system:invention:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Invention invention)
	{
		startPage();
        //List<Invention> list = inventionService.selectInventionList(invention);
        List<InventionVO> list = inventionService.selectInventionVOList(invention);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出发明专利列表
	 */
	@RequiresPermissions("system:invention:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Invention invention)
    {
    	List<Invention> list = inventionService.selectInventionList(invention);
        ExcelUtil<Invention> util = new ExcelUtil<Invention>(Invention.class);
        return util.exportExcel(list, "invention");
    }
	@GetMapping("/detail/{inventionId}")
	public String detail(@PathVariable("inventionId") Integer inventionId, ModelMap mmap)
	{
		InventionVO inventionVO = inventionService.selectInventionVOById(inventionId);

		mmap.put("invention", inventionVO);

		return prefix + "/detail";
	}
	/**
	 * 新增发明专利
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存发明专利
	 */
	@RequiresPermissions("system:invention:add")
	@Log(title = "发明专利", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestParam String inventionName,@RequestParam int inventionState,@RequestParam String patentNumber,
							  @RequestParam String firstInventor,@RequestParam int firstInventorMajor,
							  @RequestParam String otherInventor,@RequestParam String patentRightBelongsTo,
							  @RequestParam Date appliedDate,@RequestParam Date examDate,@RequestParam Date announcementDate,@RequestParam
							  MultipartFile file,@RequestParam String note)

	{
		Invention invention = new Invention();
		try {
			String filePath = RuoYiConfig.getUploadPath();
			String fileName = FileUploadUtils.uploadWithPreffix(filePath, file,"invention");

			Date now = new Date();

			invention.setInventionName(inventionName);
			invention.setInventionState(inventionState);
			invention.setPatentNumber(patentNumber);
			invention.setFirstInventor(firstInventor);
			invention.setFirstInventorMajor(firstInventorMajor);
			invention.setOtherInventor(otherInventor);
			invention.setPatentRightBelongsTo(patentRightBelongsTo);
			invention.setAppliedDate(appliedDate);
			invention.setExamDate(examDate);
			invention.setAnnouncementDate(announcementDate);
			invention.setAttachFile(fileName);
			invention.setCreatedDate(now);
			invention.setCreatedBy(String.valueOf(ShiroUtils.getSysUser().getUserId()));
			invention.setNote(note);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return toAjax(inventionService.insertInvention(invention));
	}

	/**
	 * 修改发明专利
	 */
	@GetMapping("/edit/{inventionId}")
	public String edit(@PathVariable("inventionId") Integer inventionId, ModelMap mmap)
	{
		InventionVO invention = inventionService.selectInventionVOById(inventionId);
		mmap.put("invention", invention);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存发明专利
	 */
	@RequiresPermissions("system:invention:edit")
	@Log(title = "发明专利", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@RequestParam int inventionId,
			@RequestParam String inventionName,@RequestParam int inventionState,@RequestParam String patentNumber,
							   @RequestParam String firstInventor,@RequestParam int firstInventorMajor,
							   @RequestParam String otherInventor,@RequestParam String patentRightBelongsTo,
							   @RequestParam Date appliedDate,@RequestParam Date examDate,@RequestParam Date announcementDate,
							   @RequestParam(value = "file",required = false) MultipartFile file,@RequestParam String note,@RequestParam String attachFile)
	{
		Invention invention = new Invention();

		try {
			if(file!=null){
				//原有文件删除
				String baseDir = RuoYiConfig.getProfile();
				String filePath = baseDir+attachFile;
				FileUtils.deleteFile(filePath);

				//上传文件
				String newFilePath = FileUploadUtils.uploadWithPreffix(baseDir, file,"award");

				//更新
				invention.setAttachFile(newFilePath);
			}else {
				//保持原有文件
				invention.setAttachFile(attachFile);
			}


			invention.setInventionId(inventionId);
			invention.setInventionName(inventionName);
			invention.setInventionState(inventionState);
			invention.setPatentNumber(patentNumber);
			invention.setFirstInventor(firstInventor);
			invention.setFirstInventorMajor(firstInventorMajor);
			invention.setOtherInventor(otherInventor);
			invention.setPatentRightBelongsTo(patentRightBelongsTo);
			invention.setAppliedDate(appliedDate);
			invention.setExamDate(examDate);
			invention.setAnnouncementDate(announcementDate);
			invention.setCreatedBy(String.valueOf(ShiroUtils.getSysUser().getUserId()));
			invention.setNote(note);

		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(AjaxResult.Type.ERROR,e.toString());
		}
		int i = inventionService.updateInvention(invention);
		return toAjax(inventionService.updateInvention(invention));
	}
	
	/**
	 * 删除发明专利
	 */
	@RequiresPermissions("system:invention:remove")
	@Log(title = "发明专利", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(inventionService.deleteInventionByIds(ids));
	}


	@GetMapping("/getAttachFile")
	@ResponseBody
	public AjaxResult getAttachFile(@RequestParam Integer inventionId)
	{
		String filePath = inventionService.selectInventionById(inventionId).getAttachFile();
		return new AjaxResult(AjaxResult.Type.SUCCESS,"",filePath);
	}

	@GetMapping("/downloadFile/batchDownload")
	public void batchDownload (@RequestParam("column") String column,
							   @RequestParam("inventionId") String inventionIds, HttpServletResponse response, HttpServletRequest request) throws Exception {
		Map<Integer,String>[] nameMaps;

		String[] colums = column.split(",");
		String[] inventorIdStr = inventionIds.split(",");

		//获取规则对象
		List<FileNameConfig> fileNameConfigs = iFileNameConfigService.selectFileNameConfigList(new FileNameConfig("发明专利"));
		String[] rules=fileNameConfigs.get(0).getNameRule().split("\\+");
		List<Integer> ruleItems = new ArrayList<>();

		for (String rule : rules) {
			ruleItems.add(Integer.parseInt(rule));
		}

		List<InventionVO> inventionList = new ArrayList<>();
		for (String s:inventorIdStr){
			inventionList.add(inventionService.selectInventionVOById(Integer.parseInt(s)));
		}

		List<FileNameConfig> configs = InventionFileNameRuleResolver.
				resolveRule(ruleItems, inventionList);

		String zipFilename = "/Users/apple/IdeaProjects/ruoyi_doc/profile/zipFile/tempFile.zip";
		ZipCompress zipCom = new ZipCompress(zipFilename, configs, colums);
		zipCom.zip();
		String realFileName = "发明" + zipFilename.substring(zipFilename.indexOf("."));
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
		FileUtils.writeBytes(zipFilename, response.getOutputStream());
	}
}
