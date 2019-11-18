package com.ruoyi.project.system.award.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.award.domain.AwardVO;
import com.ruoyi.project.system.award.tools.AwardFileNameRuleResolver;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.dept.service.IDeptService;
import com.ruoyi.project.system.docPaper.tool.ZipCompress;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.fileNameConfig.service.IFileNameConfigService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.award.domain.Award;
import com.ruoyi.project.system.award.service.IAwardService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 教师奖励信息操作处理
 * 
 * @author yelihu
 * @date 2019-10-27
 */
@Controller
@RequestMapping("/system/award")
public class AwardController extends BaseController
{
    private String prefix = "system/award";
	
	@Autowired
	private IAwardService awardService;

	@Autowired
	private IDeptService deptService;

	@Autowired
	private IFileNameConfigService iFileNameConfigService;



	@RequiresPermissions("system:award:view")
	@GetMapping()
	public String award()
	{
	    return prefix + "/award";
	}
	
	/**
	 * 查询教师奖励列表
	 */
	@RequiresPermissions("system:award:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Award award)
	{
		startPage();
        List<AwardVO> list = awardService.selectAwardVOList(award);
		return getDataTable(list);
	}

	@GetMapping("/getAttachFile")
	@ResponseBody
	public AjaxResult getAttachFile(@RequestParam Integer awardId)
	{
		String filePath = awardService.selectAwardById(awardId).getAttachFile();
		return new AjaxResult(AjaxResult.Type.SUCCESS,"",filePath);
	}


	/**
	 * 导出教师奖励列表
	 */
	@RequiresPermissions("system:award:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Award award)
    {
    	List<Award> list = awardService.selectAwardList(award);
        ExcelUtil<Award> util = new ExcelUtil<Award>(Award.class);
        return util.exportExcel(list, "award");
    }

	@GetMapping("/detail/{awardId}")
	public String detail(@PathVariable("awardId") Integer awardId, ModelMap mmap)
	{
		Award award = awardService.selectAwardById(awardId);
		Dept dept1 = deptService.selectDeptById(award.getFirstWinnerMajor().longValue());
		Dept dept2 = deptService.selectDeptById(award.getSecondWinnerMajor().longValue());
		Dept dept3 = deptService.selectDeptById(award.getThirdWinnerMajor().longValue());

		mmap.put("award", award);
		mmap.put("dept1", dept1);
		mmap.put("dept2", dept2);
		mmap.put("dept3", dept3);

		return prefix + "/detail";
	}
	/**
	 * 新增教师奖励
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存教师奖励
	 */
	@RequiresPermissions("system:award:add")
	@Log(title = "教师奖励", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestParam String awardName,
							  @RequestParam String firstWinner, @RequestParam Integer firstWinnerMajor,
							  @RequestParam String secondWinner, @RequestParam Integer secondWinnerMajor,
							  @RequestParam String thirdWinner, @RequestParam Integer thirdWinnerMajor,
							  @RequestParam String firstDept, @RequestParam String workWithDept,
							  @RequestParam Integer awardLeval, @RequestParam String awardFrom,
							  @RequestParam Integer awardNumber, @RequestParam Date awardDate,
							  @RequestParam MultipartFile file,@RequestParam String note){
		Award award = new Award();
		try {
		//文件上传
		String filePath = RuoYiConfig.getUploadPath();
		String fileName = FileUploadUtils.uploadWithPreffix(filePath, file,"award");
		//属性装配
		award.setAttachFile(fileName);
		award.setAwardName(awardName);
		award.setFirstWinner(firstWinner);
		award.setSecondWinner(secondWinner);
		award.setThirdWinner(thirdWinner);
		award.setFirstWinnerMajor(firstWinnerMajor);
		award.setSecondWinnerMajor(secondWinnerMajor);
		award.setThirdWinnerMajor(thirdWinnerMajor);
		award.setFirstDept(firstDept);
		award.setWorkWithDept(workWithDept);
		award.setAwardLeval(awardLeval);
		award.setAwardFrom(awardFrom);
		award.setAwardNumber(awardNumber);
		award.setAwardDate(awardDate);
		award.setNote(note);

		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(AjaxResult.Type.ERROR,e.toString());
		}

		return toAjax(awardService.insertAward(award));
	}

	/**
	 * 修改教师奖励
	 */
	@GetMapping("/edit/{awardId}")
	public String edit(@PathVariable("awardId") Integer awardId, ModelMap mmap)
	{
		Award award = awardService.selectAwardById(awardId);
		Dept dept1 = deptService.selectDeptById(award.getFirstWinnerMajor().longValue());
		Dept dept2 = deptService.selectDeptById(award.getSecondWinnerMajor().longValue());
		Dept dept3 = deptService.selectDeptById(award.getThirdWinnerMajor().longValue());

		mmap.put("award", award);
		mmap.put("dept1", dept1);
		mmap.put("dept2", dept2);
		mmap.put("dept3", dept3);

	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教师奖励
	 */
	@RequiresPermissions("system:award:edit")
	@Log(title = "教师奖励", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@RequestParam Integer awardId,@RequestParam String awardName,
							   @RequestParam String firstWinner, @RequestParam Integer firstWinnerMajor,
							   @RequestParam String secondWinner, @RequestParam Integer secondWinnerMajor,
							   @RequestParam String thirdWinner, @RequestParam Integer thirdWinnerMajor,
							   @RequestParam String firstDept, @RequestParam String workWithDept,
							   @RequestParam Integer awardLeval, @RequestParam String awardFrom,
							   @RequestParam Integer awardNumber, @RequestParam Date awardDate,
							   @RequestParam(value = "file",required = false) MultipartFile file,@RequestParam String note,@RequestParam String attachFile){
		Award award = new Award();

		try {
			if(file!=null){
				//原有文件删除
				String baseDir = RuoYiConfig.getProfile();
				String filePath = baseDir+attachFile;
				FileUtils.deleteFile(filePath);

				//上传文件
				String newFilePath = FileUploadUtils.uploadWithPreffix(baseDir, file,"award");

				//更新
				award.setAttachFile(newFilePath);
			}else {
				//保持原有文件
				award.setAttachFile(attachFile);
			}


			//属性装配
			award.setAwardId(awardId);
			award.setAwardName(awardName);
			award.setFirstWinner(firstWinner);
			award.setSecondWinner(secondWinner);
			award.setThirdWinner(thirdWinner);
			award.setFirstWinnerMajor(firstWinnerMajor);
			award.setSecondWinnerMajor(secondWinnerMajor);
			award.setThirdWinnerMajor(thirdWinnerMajor);
			award.setFirstDept(firstDept);
			award.setWorkWithDept(workWithDept);
			award.setAwardLeval(awardLeval);
			award.setAwardFrom(awardFrom);
			award.setAwardNumber(awardNumber);
			award.setAwardDate(awardDate);
			award.setNote(note);

		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(AjaxResult.Type.ERROR,e.toString());
		}
		return toAjax(awardService.updateAward(award));
	}
	
	/**
	 * 删除教师奖励
	 */
	@RequiresPermissions("system:award:remove")
	@Log(title = "教师奖励", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(awardService.deleteAwardByIds(ids));
	}



	@GetMapping("/downloadFile/batchDownload")
	public void batchDownload (@Param("column") String column,
							   @Param("awardId") String awardId, HttpServletResponse response, HttpServletRequest request) throws Exception {
		Map<Integer,String>[] nameMaps;

		String[] colums = column.split(",");
		String[] pbIdStr = awardId.split(",");

		//获取规则对象
		List<FileNameConfig> fileNameConfigs = iFileNameConfigService.selectFileNameConfigList(new FileNameConfig("奖励"));
		String[] rules=fileNameConfigs.get(0).getNameRule().split("\\+");
		List<Integer> ruleItems = new ArrayList<>();

		for (String rule : rules) {
			ruleItems.add(Integer.parseInt(rule));
		}

		List<AwardVO> awardList = new ArrayList<>();
		for (String s:pbIdStr){
			awardList.add(awardService.selectAwardVOById(Integer.parseInt(s)));
		}

		List<FileNameConfig> configs = AwardFileNameRuleResolver.
				resolveRule(ruleItems, awardList);

		String zipFilename = "/Users/apple/IdeaProjects/ruoyi_doc/profile/zipFile/tempFile.zip";
		ZipCompress zipCom = new ZipCompress(zipFilename, configs, colums);
		zipCom.zip();
		String realFileName = "奖励" + zipFilename.substring(zipFilename.indexOf("."));
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
		FileUtils.writeBytes(zipFilename, response.getOutputStream());
	}
}
