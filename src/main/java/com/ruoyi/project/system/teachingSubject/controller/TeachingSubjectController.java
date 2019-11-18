package com.ruoyi.project.system.teachingSubject.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.pdf.PdfFileUtil;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.common.utils.file.ZipCompress;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.fileNameConfig.service.IFileNameConfigService;
import com.ruoyi.project.system.teachingSubject.domain.TeachingSubjectForFileNameConfig;
import com.ruoyi.common.utils.file.FileUploadUtilSelf;
import com.ruoyi.project.system.teachingSubject.tool.TeachingResolvedNameRule;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.teachingSubject.domain.TeachingSubject;
import com.ruoyi.project.system.teachingSubject.service.ITeachingSubjectService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 教改课题信息操作处理
 * 
 * @author daivd
 * @date 2019-10-20
 */
@Controller
@RequestMapping("/system/teachingSubject")
public class TeachingSubjectController extends BaseController
{
    private String prefix = "system/teachingSubject";
    private String temp = null;
	private String editTemp = null;
	
	@Autowired
	private ITeachingSubjectService teachingSubjectService;
	@Autowired
	private IFileNameConfigService iFileNameConfigService;
	
	@RequiresPermissions("system:teachingSubject:view")
	@GetMapping()
	public String teachingSubject()
	{
	    return prefix + "/teachingSubject";
	}

	/**
	 * 查看详细
	 */
	@GetMapping("/detail/{teachingSubjectId}")
	public String detail(@PathVariable("teachingSubjectId") Integer teachingSubjectId, ModelMap mmap)
	{
		System.out.println("查看专著详细");
		TeachingSubject teachingSubject = teachingSubjectService.selectTeachingSubjectById(teachingSubjectId);
		System.out.println(teachingSubject.getAttachFile());

		mmap.put("teachingSubject",teachingSubject);
		return prefix + "/detail";
	}
	/**
	 * 查询专著文件
	 */
	@RequiresPermissions("system:teachingSubject:teachingSubject")
	@GetMapping("/teachingSubject")
	@ResponseBody
	public AjaxResult getPublication(@RequestParam("sTId") int sTId)
	{
		TeachingSubject teachingSubject = teachingSubjectService.selectTeachingSubjectById(sTId);
		System.out.println("++++++++++++++++++++++++++++");
		System.out.println(teachingSubject);
		System.out.println("++++++++++++++++++++++++++++");
		return new AjaxResult(AjaxResult.Type.SUCCESS,"",teachingSubject.getAttachFile());
	}
	/**
	 * 查询教改课题列表
	 */
	@RequiresPermissions("system:teachingSubject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachingSubject teachingSubject)
	{
		startPage();
		System.out.println("---------------------");
        List<TeachingSubject> list = teachingSubjectService.selectTeachingSubjectList(teachingSubject);
        for (TeachingSubject teachingSubject1:list){
			System.out.println("------------------------");
			System.out.println(teachingSubject1.getSubjectName());
			System.out.println(teachingSubject1.getAttachFile());
		}
		return getDataTable(list);
	}
	
	
	/**
	 * 导出教改课题列表
	 */
	@RequiresPermissions("system:teachingSubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachingSubject teachingSubject)
    {
    	List<TeachingSubject> list = teachingSubjectService.selectTeachingSubjectList(teachingSubject);
        ExcelUtil<TeachingSubject> util = new ExcelUtil<TeachingSubject>(TeachingSubject.class);
        return util.exportExcel(list, "teachingSubject");
    }
	
	/**
	 * 新增教改课题
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存教改课题
	 */
	@RequiresPermissions("system:teachingSubject:add")
	@Log(title = "教改课题", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachingSubject teachingSubject)
	{
		teachingSubject.setAttachFile(temp);
		temp = null;
		return toAjax(teachingSubjectService.insertTeachingSubject(teachingSubject));
	}

	/**
	 * 修改教改课题
	 */
	@GetMapping("/edit/{subjectId}")
	public String edit(@PathVariable("subjectId") Integer subjectId, ModelMap mmap)
	{
		TeachingSubject teachingSubject = teachingSubjectService.selectTeachingSubjectById(subjectId);
		mmap.put("teachingSubject", teachingSubject);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教改课题
	 */
	@RequiresPermissions("system:teachingSubject:edit")
	@Log(title = "教改课题", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachingSubject teachingSubject)
	{
		teachingSubject.setAttachFile(editTemp);
		editTemp = null;
		return toAjax(teachingSubjectService.updateTeachingSubject(teachingSubject));
	}
	
	/**
	 * 删除教改课题
	 */
	@RequiresPermissions("system:teachingSubject:remove")
	@Log(title = "教改课题", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachingSubjectService.deleteTeachingSubjectByIds(ids));
	}

	/**
	 * 文件上传
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresPermissions("system:teachingSubject:add")
	@Log(title = "教改课题", businessType = BusinessType.INSERT)
	@PostMapping("/addFile")
	@ResponseBody
	public Map<String,Object> addFile(HttpServletRequest request, HttpServletResponse response)throws IOException {
		//转型为MultipartHttpRequest：
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 获得文件：
		MultipartFile file= multipartRequest.getFile("attachFile");
		// 上传文件路径
		String filePath = RuoYiConfig.getUploadPath();
//		System.out.println(filePath+"//filePath");
		// 上传并返回新文件名称
		String fileName = FileUploadUtilSelf.upload(filePath, file,"teachingSubject");
//		System.out.println(fileName+"//fileName");
		temp = fileName;
		Map<String,Object> result= new HashMap<String, Object>();
		result.put("msg","上传成功！");
		return result;

	}
	@RequiresPermissions("system:teachingSubject:reorderList")
	@PostMapping("/reorderList")
	@ResponseBody
	public TableDataInfo reorderList(String jsonData){
		System.out.println(jsonData);
		List<TeachingSubject> list = JSONArray.parseArray(jsonData,TeachingSubject.class);
		teachingSubjectService.deleteAllTeachingSubject();
		for (TeachingSubject teachingSubject:list){
			teachingSubjectService.insertTeachingSubject(teachingSubject);
			System.out.println(teachingSubject.getSubjectName());
		}
		return getDataTable(list);
	}

	/**
	 * 附件下载
	 * @param subjectId
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@GetMapping("/downloadFile/{subjectId}")
	public void downloadFile (@PathVariable("subjectId") Integer subjectId, HttpServletResponse response,
							  HttpServletRequest request) throws Exception
	{

		TeachingSubject teachingSubject = teachingSubjectService.selectTeachingSubjectById(subjectId);
		String filePath = teachingSubject.getAttachFile();
		String realFileName = "文档" + filePath.substring(filePath.indexOf("."));
//        String realFileName = docPaper.getgetFileName() + filePath.substring(filePath.indexOf("."));
//        String path = RuoYiConfig.getUploadPath() + docPaper.getFilePath();
		String path = RuoYiConfig.getUploadPath() + teachingSubject.getAttachFile();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		System.out.println(path + "///");
		System.out.println(realFileName + "///");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
		FileUtils.writeBytes(path, response.getOutputStream());
	}
	/**
	 * 附件拆分下载
	 * @param subjectId
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@GetMapping("/downloadSplitFile/{subjectId}")
	public void downloadSplitFile (@PathVariable("subjectId") Integer subjectId, HttpServletResponse response,
								   HttpServletRequest request) throws Exception
	{

		TeachingSubject teachingSubject = teachingSubjectService.selectTeachingSubjectById(subjectId);
		String filePath = teachingSubject.getAttachFile();
		String path = RuoYiConfig.getUploadPath() + teachingSubject.getAttachFile();
		/**
		 * 拆分文件
		 */
		List<File> fileList = PdfFileUtil.SplitPages(path);
		String[] colums= new String[fileList.size()];
		FileNameConfig fileNameConfig ;
		List<FileNameConfig> fileNameConfigList2 = new ArrayList<>();
		for (int i=1;i<=fileList.size();i++){
			colums[i-1] = Integer.toString(i) ;
			fileNameConfig = new FileNameConfig();
			fileNameConfig.setFileType("D:/profile/splitFile/sample"+i+".pdf");
			fileNameConfig.setNameRule("");
			fileNameConfigList2.add(fileNameConfig);
		}

		/**
		 * 把文件进行压缩
		 * 其中ZipCompress类通用
		 */
		String zipFilename = "D:/profile/zipFile/tempFile.zip";
		ZipCompress zipCom = new ZipCompress(zipFilename, fileNameConfigList2, colums);
		zipCom.zip();
		//把压缩包传到前台
		String realFileName = "教改课题" + zipFilename.substring(zipFilename.indexOf("."));
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
		FileUtils.writeBytes(zipFilename, response.getOutputStream());
	}
	/**
	 * 用户更新文件时，上传新文件，需要删除旧文件
	 * @param
	 * @param fileUrl
	 * @return
	 */
	public Map<String, Object> removeFile (String fileUrl)
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
	 * 编辑文件上传
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresPermissions("system:teachingSubject:edit")
	@Log(title = "教改课题", businessType = BusinessType.INSERT)
	@PostMapping("/updateFile")
	@ResponseBody
	public Map<String,Object> updateFile(HttpServletRequest request, HttpServletResponse response)throws IOException {

		System.out.println("---编辑文件上传---");

		//转型为MultipartHttpRequest：
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 获得文件：
		MultipartFile file= multipartRequest.getFile("attachFile");

		// 上传文件路径
		String filePath = RuoYiConfig.getUploadPath();
		// 上传并返回新文件名称
		String fileName = FileUploadUtilSelf.upload(filePath, file,"teachingSubject");
		editTemp = fileName;
		Map<String,Object> result= new HashMap<String, Object>();
		result.put("msg","上传成功！");
		return result;

	}
	/**
	 * 论文批量下载
	 * @param attachFile
	 * @param column
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
		List<TeachingSubjectForFileNameConfig> list = teachingSubjectService.selectListForFileNameConfig(subjectIdList);
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
		TeachingResolvedNameRule resolvedNameRule = new TeachingResolvedNameRule();
		List<FileNameConfig> fileNameConfigList = resolvedNameRule.newNameAndOldFilePath(list, compareFileNameList, "教改课题",
				iFileNameConfigService.selectFileNameConfigList(new FileNameConfig("教改课题")));
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
		String realFileName = "教改课题" + zipFilename.substring(zipFilename.indexOf("."));
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
		FileUtils.writeBytes(zipFilename, response.getOutputStream());
	}
	/**
	 * 论文批量下载
	 * @param attachFile
	 * @param column
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@GetMapping("/downloadFile/mergeDownload")
	public void mergeDownload (@Param("attachFile") String attachFile,
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
		List<TeachingSubjectForFileNameConfig> list = teachingSubjectService.selectListForFileNameConfig(subjectIdList);
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
		TeachingResolvedNameRule resolvedNameRule = new TeachingResolvedNameRule();
		List<FileNameConfig> fileNameConfigList = resolvedNameRule.newNameAndOldFilePath(list, compareFileNameList, "教改课题",
				iFileNameConfigService.selectFileNameConfigList(new FileNameConfig("教改课题")));
		for(int i=0;i<fileNameConfigList.size();i++) {
			System.out.println(fileNameConfigList.get(i).toString());
		}


		/**
		 * 把多个pdf文件合并
		 */
		List<File> fileList = new ArrayList<>();
		File file;
		for (int i=0;i<fileNameConfigList.size();i++){
			file = new File(fileNameConfigList.get(i).getFileType());
			fileList.add(file);
		}
		String mergeFileName = "D:/profile/mergeFile/mergeFile.pdf";

		File fileParent = new File("D:/profile/mergeFile");
		if(!fileParent.exists()){
			fileParent.mkdirs();
		}
		PdfFileUtil.mulFile2One(fileList,mergeFileName);
		FileNameConfig fileNameConfig = new FileNameConfig();
		List<FileNameConfig> fileNameConfigList2 = new ArrayList<>();
		fileNameConfig.setFileType(mergeFileName);
		fileNameConfig.setNameRule("教改课题");
		fileNameConfigList2.add(fileNameConfig);
		/**
		 * 把文件进行压缩
		 * 其中ZipCompress类通用
		 */
		String zipFilename = "D:/profile/zipFile/tempFile.zip";
		ZipCompress zipCom = new ZipCompress(zipFilename, fileNameConfigList2, colums);
		zipCom.zip();
		//把压缩包传到前台
		String realFileName = "教改课题" + zipFilename.substring(zipFilename.indexOf("."));
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
		FileUtils.writeBytes(zipFilename, response.getOutputStream());
	}
}
