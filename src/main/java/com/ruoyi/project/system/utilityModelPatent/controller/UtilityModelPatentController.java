package com.ruoyi.project.system.utilityModelPatent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.docPaper.tool.ZipCompress;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.fileNameConfig.service.IFileNameConfigService;
import com.ruoyi.project.system.utilityModelPatent.domain.UtilityModelPatentFileNameConfig;
import com.ruoyi.project.system.utilityModelPatent.tools.PatentResolvedNameRule;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.utilityModelPatent.domain.UtilityModelPatent;
import com.ruoyi.project.system.utilityModelPatent.service.IUtilityModelPatentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实用新型专利信息操作处理
 * 
 * @author daivd
 * @date 2019-11-09
 */
@Controller
@RequestMapping("/system/utilityModelPatent")
public class UtilityModelPatentController extends BaseController
{
    private String prefix = "system/utilityModelPatent";
	
	@Autowired
	private IUtilityModelPatentService utilityModelPatentService;
    @Autowired
    private IFileNameConfigService iFileNameConfigService;
	
	@RequiresPermissions("system:utilityModelPatent:view")
	@GetMapping()
	public String utilityModelPatent()
	{
	    return prefix + "/utilityModelPatent";
	}
	
	/**
	 * 查询实用新型专利列表
	 */
	@RequiresPermissions("system:utilityModelPatent:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UtilityModelPatent utilityModelPatent)
	{
		startPage();
        List<UtilityModelPatent> list = utilityModelPatentService.selectUtilityModelPatentList(utilityModelPatent);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出实用新型专利列表
	 */
	@RequiresPermissions("system:utilityModelPatent:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UtilityModelPatent utilityModelPatent)
    {
    	List<UtilityModelPatent> list = utilityModelPatentService.selectUtilityModelPatentList(utilityModelPatent);
        ExcelUtil<UtilityModelPatent> util = new ExcelUtil<UtilityModelPatent>(UtilityModelPatent.class);
        return util.exportExcel(list, "utilityModelPatent");
    }
	
	/**
	 * 新增实用新型专利
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存实用新型专利
	 */
	@RequiresPermissions("system:utilityModelPatent:add")
	@Log(title = "实用新型专利", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestParam("file") MultipartFile file,
			UtilityModelPatent utilityModelPatent) {
        String filePath = RuoYiConfig.getUploadPath();
        // 上传并返回新文件名称
        String fileName = null;
        try {
            fileName = FileUploadUtils.uploadWithPreffix(filePath, file,"utilityModelPatent");
        } catch (IOException e) {
            return toAjax(0);
        }
        utilityModelPatent.setAttachFile(fileName);
        return toAjax(utilityModelPatentService.insertUtilityModelPatent(utilityModelPatent));
//		return toAjax(utilityModelPatentService.insertUtilityModelPatent(utilityModelPatent));
	}

	/**
	 * 修改实用新型专利
	 */
	@GetMapping("/edit/{patentId}")
	public String edit(@PathVariable("patentId") Integer patentId, ModelMap mmap)
	{
		UtilityModelPatent utilityModelPatent = utilityModelPatentService.selectUtilityModelPatentById(patentId);
		mmap.put("utilityModelPatent", utilityModelPatent);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存实用新型专利
	 */
	@RequiresPermissions("system:utilityModelPatent:edit")
	@Log(title = "实用新型专利", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@RequestParam(value = "file",required = false) MultipartFile file ,
			UtilityModelPatent utilityModelPatent)
	{
        System.out.println(utilityModelPatent.toString());
        //如果文件不为空
        if (file != null) {
            //原有文件删除
            removeFile(utilityModelPatent.getPatentId(), utilityModelPatent.getAttachFile());
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = null;
            try {
                fileName = FileUploadUtils.uploadWithPreffix(filePath, file,"sciResSubject");
//                fileName = FileUploadUtilSelf.upload(filePath, file,"sciResSubject");
            } catch (IOException e) {
                System.out.println("文件上传失败");
            }
            //更新文件路径
            utilityModelPatent.setAttachFile(fileName);
        }
		return toAjax(utilityModelPatentService.updateUtilityModelPatent(utilityModelPatent));
	}
	
	/**
	 * 删除实用新型专利
	 */
	@RequiresPermissions("system:utilityModelPatent:remove")
	@Log(title = "实用新型专利", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(utilityModelPatentService.deleteUtilityModelPatentByIds(ids));
	}
    /**
     * 查询论文列表
     */
    @GetMapping("/utilityModelPatent")
    @ResponseBody
    public AjaxResult getSciResSubject(@RequestParam("pbId") int pbId)
    {
        UtilityModelPatent utilityModelPatent = utilityModelPatentService.selectUtilityModelPatentById(pbId);
        return new AjaxResult(AjaxResult.Type.SUCCESS,"",utilityModelPatent.getAttachFile());
    }
    /**
     * 查看详细
     */
    @GetMapping("/detail/{patentId}")
    public String detail(@PathVariable("patentId") Integer patentId, ModelMap mmap)
    {
        UtilityModelPatent utilityModelPatent = utilityModelPatentService.selectUtilityModelPatentById(patentId);
        mmap.put("utilityModelPatent",utilityModelPatent);
        return prefix + "/detail";
    }
    /**
     * 单个文件的下载
     * @param patentId
     * @param response
     * @param request
     * @throws Exception
     */
    @GetMapping("/downloadFile/{patentId}")
    public void downloadFile (@PathVariable("patentId") Integer patentId, HttpServletResponse response,
                              HttpServletRequest request) throws Exception
    {
        UtilityModelPatent utilityModelPatent = utilityModelPatentService.selectUtilityModelPatentById(patentId);
        String filePath = utilityModelPatent.getAttachFile();
        String realFileName = "实用新型专利" + filePath.substring(filePath.indexOf("."));
        String path = RuoYiConfig.getUploadPath() + utilityModelPatent.getAttachFile();
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
        FileUtils.writeBytes(path, response.getOutputStream());
    }

    /**
     * 用户更新文件时，上传新文件，需要删除旧文件
     * @param pbId
     * @param fileUrl
     * @return
     */
    public Map<String, Object> removeFile (int pbId, String fileUrl)
    {
        String baseDir = RuoYiConfig.getProfile();
        String filePath = baseDir + fileUrl;
        boolean deleteFile = FileUtils.deleteFile(filePath);
        if (deleteFile) {
            System.out.println("删除文件" + filePath + "成功！");
            return new AjaxResult(AjaxResult.Type.SUCCESS, "删除成功");
        } else {
            System.out.println("删除文件" + filePath + "失败");
            return new AjaxResult(AjaxResult.Type.ERROR, "删除失败");
        }
    }

	/**
	 * 论文批量下载
	 * @param attachFile 要下载的文件名
	 * @param column 文件序号
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@GetMapping("/downloadFile/batchDownload")
	public void batchDownload (@Param("attachFile") String attachFile,
							   @Param("column") String column,
							   @Param("patentId") String patentId
			, HttpServletResponse response,
							   HttpServletRequest request) throws Exception {
		String[] attachFiles = attachFile.split(",");
		String[] colums = column.split(",");
		String[] patentIds = patentId.split(",");
		List<String> subjectIdList = new ArrayList<>();
		for(int i=0;i<patentIds.length;i++) {
			subjectIdList.add(patentIds[i]);
		}
        List<UtilityModelPatentFileNameConfig> list = utilityModelPatentService.selectListForFileNameConfig(subjectIdList);
        List<String> listFilePaths = new ArrayList();
        List<String> compareFileNameList = new ArrayList<>();
        //将文件名放到数组里面
        for (int i = 0; i < attachFiles.length; i++) {
            listFilePaths.add(RuoYiConfig.getUploadPath() + attachFiles[i]);
            compareFileNameList.add(attachFiles[i]);
        }
        /**
         * 解析命名规则
         * fileNameConfigList里面每一项的数据样板
         * fileNameId=<null>
         *fileType=D:/profile/upload/docPaper/3829a141ce9c8726ca3936d4a57a22c6.pdf
         *nameRule=教研论文+李+软件工程+2019-07-31+
         */
        PatentResolvedNameRule resolvedNameRule = new PatentResolvedNameRule();
        List<FileNameConfig> fileNameConfigList = resolvedNameRule.newNameAndOldFilePath(list, compareFileNameList, "实用新型专利",
                iFileNameConfigService.selectFileNameConfigList(new FileNameConfig("实用新型专利")));
        for(int i=0;i<fileNameConfigList.size();i++) {
            System.out.println(fileNameConfigList.get(i).toString());
        }
        /**
         * 把文件进行压缩
         * 其中ZipCompress类通用
         */
        String zipFilename = "D:/profile/zipFile/tempFile.zip";
        ZipCompress zipCom = new ZipCompress(zipFilename, fileNameConfigList, colums);
        zipCom.zip();
        //把压缩包传到前台
        String realFileName = "实用新型专利" + zipFilename.substring(zipFilename.indexOf("."));
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
        FileUtils.writeBytes(zipFilename, response.getOutputStream());
	}
}
