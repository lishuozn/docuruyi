package com.ruoyi.project.system.sciResSubject.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.ruoyi.project.system.sciResSubject.domain.SciResSubjectFileNameConfig;
import com.ruoyi.project.system.sciResSubject.tools.FileUploadUtilSelf;
import com.ruoyi.project.system.sciResSubject.tools.SciResResolvedNameRule;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.sciResSubject.domain.SciResSubject;
import com.ruoyi.project.system.sciResSubject.service.ISciResSubjectService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 科研课题信息操作处理
 * 
 * @author daivd
 * @date 2019-10-19
 */
@Controller
@RequestMapping("/system/sciResSubject")
public class SciResSubjectController extends BaseController
{
    private String prefix = "system/sciResSubject";
	
	@Autowired
	private ISciResSubjectService sciResSubjectService;
    @Autowired
    private IFileNameConfigService iFileNameConfigService;
	
	@RequiresPermissions("system:sciResSubject:view")
	@GetMapping()
	public String sciResSubject()
	{
	    return prefix + "/sciResSubject";
	}
	
	/**
	 * 查询科研课题列表
	 */
	@RequiresPermissions("system:sciResSubject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SciResSubject sciResSubject)
	{
		startPage();
        List<SciResSubject> list = sciResSubjectService.selectSciResSubjectList(sciResSubject);
		return getDataTable(list);
	}
    /**
     * 查看详细
     */
    @GetMapping("/detail/{subjectId}")
    public String detail(@PathVariable("subjectId") Integer subjectId, ModelMap mmap)
    {
		SciResSubject sciResSubject = sciResSubjectService.selectSciResSubjectById(subjectId);
//        DocPaperForFileNameConfig docPaper = docPaperService.selectDocPaperDetailById(paperId);
        mmap.put("sciResSubject",sciResSubject);
        return prefix + "/detail";
    }
	
	/**
	 * 导出科研课题列表
	 */
	@RequiresPermissions("system:sciResSubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SciResSubject sciResSubject)
    {
    	List<SciResSubject> list = sciResSubjectService.selectSciResSubjectList(sciResSubject);
        ExcelUtil<SciResSubject> util = new ExcelUtil<SciResSubject>(SciResSubject.class);
        return util.exportExcel(list, "sciResSubject");
    }
	
	/**
	 * 新增科研课题
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存科研课题
	 */
	@RequiresPermissions("system:sciResSubject:add")
	@Log(title = "科研课题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestParam("file") MultipartFile file,
							  SciResSubject sciResSubject)
	{
        String filePath = RuoYiConfig.getUploadPath();
        // 上传并返回新文件名称
        String fileName = null;
        try {
            fileName = FileUploadUtilSelf.upload(filePath, file,"sciResSubject");
        } catch (IOException e) {
            return toAjax(0);
        }
        sciResSubject.setAttachFile(fileName);
		return toAjax(sciResSubjectService.insertSciResSubject(sciResSubject));
	}

	/**
	 * 修改科研课题
	 */
	@GetMapping("/edit/{subjectId}")
	public String edit(@PathVariable("subjectId") Integer subjectId, ModelMap mmap)
	{
		SciResSubject sciResSubject = sciResSubjectService.selectSciResSubjectById(subjectId);
		mmap.put("sciResSubject", sciResSubject);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存科研课题
	 */
	@RequiresPermissions("system:sciResSubject:edit")
	@Log(title = "科研课题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@RequestParam(value = "file",required = false) MultipartFile file ,
                               @RequestParam("subjectId") String subjectId,
                               @RequestParam("subjectName") String subjectName,
                               @RequestParam("subjectLevel") String subjectLevel,
                               @RequestParam("moderator") String moderator,
                               @RequestParam("modMajorId") String modMajorId,
                               @RequestParam("modParticipant") String modParticipant,
                               @RequestParam("firstUnit") String firstUnit,
                               @RequestParam("projectDate") String projectDate,
                               @RequestParam("grants") String grants,
                               @RequestParam("arrivalAmount") String arrivalAmount,
                               @RequestParam("concludingDate") String concludingDate,
                               @RequestParam("projectSource") String projectSource,
                               @RequestParam("isFinished") String isFinished,
                               @RequestParam("isFinishedOnTime") String isFinishedOnTime,
                               @RequestParam("notes") String notes,
                               @RequestParam("attachFile") String attachFile)
	{
//        System.out.println(subjectId+"\n"+
//                subjectName+"\n"+
//                subjectLevel+"\n"+
//                moderator+"\n"+
//                modMajorId+"\n"+
//                modParticipant+"\n"+
//                firstUnit+"\n"+
//                projectDate+"\n"+
//                grants+"\n"+
//                arrivalAmount+"\n"+
//                concludingDate+"\n"+
//                projectSource+"\n"+
//                isFinished+"\n"+
//                isFinishedOnTime+"\n"+
//                notes
//        );
        DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        SciResSubject sciResSubject = new SciResSubject();
        sciResSubject.setSubjectId(Integer.parseInt(subjectId));
        sciResSubject.setSubjectName(subjectName);
        sciResSubject.setSubjectLevel(Integer.parseInt(subjectLevel));
        sciResSubject.setModerator(moderator);
        if (!modMajorId.equals("")) {
            sciResSubject.setModMajorId(Integer.parseInt(modMajorId));
        }
        sciResSubject.setModParticipant(modParticipant);
        sciResSubject.setFirstUnit(firstUnit);
        Date projejct = null,concluding = null;
        try {
            projejct = format.parse(projectDate);
            concluding = format.parse(concludingDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sciResSubject.setProjectDate(projejct);
		sciResSubject.setGrants(Float.valueOf(grants));
		sciResSubject.setArrivalAmount(Float.valueOf(arrivalAmount));
		sciResSubject.setConcludingDate(concluding);
		sciResSubject.setProjectSource(projectSource);
		sciResSubject.setIsFinished(Integer.parseInt(isFinished));
		sciResSubject.setIsFinishedOnTime(Integer.parseInt(isFinishedOnTime));
		sciResSubject.setNotes(notes);
        //如果文件不为空
        if (file != null) {
            //原有文件删除
            removeFile(Integer.parseInt(subjectId), attachFile);
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
            //更新Docpaper
            sciResSubject.setAttachFile(fileName);
        } else {
            //保持原有文件
            sciResSubject.setAttachFile(attachFile);
        }
		return toAjax(sciResSubjectService.updateSciResSubject(sciResSubject));
	}
	
	/**
	 * 删除科研课题
	 */
	@RequiresPermissions("system:sciResSubject:remove")
	@Log(title = "科研课题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(sciResSubjectService.deleteSciResSubjectByIds(ids));
	}

    /**
     * 单个文件的下载
     * @param subjectId
     * @param response
     * @param request
     * @throws Exception
     */
    @GetMapping("/downloadFile/{subjectId}")
    public void downloadFile (@PathVariable("subjectId") Integer subjectId, HttpServletResponse response,
                              HttpServletRequest request) throws Exception
    {
        SciResSubject sciResSubject = sciResSubjectService.selectSciResSubjectById(subjectId);
        String filePath = sciResSubject.getAttachFile();
        System.out.println(filePath+"///////");
        String realFileName = "科研课题" + filePath.substring(filePath.indexOf("."));
        String path = RuoYiConfig.getUploadPath() + sciResSubject.getAttachFile();
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
        FileUtils.writeBytes(path, response.getOutputStream());
    }

	/**
	 * 查询论文列表
	 */
	@GetMapping("/sciResSubject")
	@ResponseBody
	public AjaxResult getSciResSubject(@RequestParam("pbId") int pbId)
	{
		SciResSubject sciResSubject = sciResSubjectService.selectSciResSubjectById(pbId);
		return new AjaxResult(AjaxResult.Type.SUCCESS,"",sciResSubject.getAttachFile());
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
                               @Param("subjectId") String subjectId
                                , HttpServletResponse response,
                               HttpServletRequest request) throws Exception {
        String[] attachFiles = attachFile.split(",");
        String[] colums = column.split(",");
        String[] subjectIds = subjectId.split(",");
        List<String> subjectIdList = new ArrayList<>();
        for(int i=0;i<subjectIds.length;i++) {
            subjectIdList.add(subjectIds[i]);
        }
        List<SciResSubjectFileNameConfig> list = sciResSubjectService.selectListForFileNameConfig(subjectIdList);
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
        SciResResolvedNameRule resolvedNameRule = new SciResResolvedNameRule();
        List<FileNameConfig> fileNameConfigList = resolvedNameRule.newNameAndOldFilePath(list, compareFileNameList, "科研课题",
                iFileNameConfigService.selectFileNameConfigList(new FileNameConfig("科研课题")));
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
        String realFileName = "科研课题" + zipFilename.substring(zipFilename.indexOf("."));
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
        FileUtils.writeBytes(zipFilename, response.getOutputStream());
    }
}
