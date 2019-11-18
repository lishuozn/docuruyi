package com.ruoyi.project.system.softwareCopyright.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.utils.file.FileUploadUtilSelf;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.file.ZipCompress;
import com.ruoyi.common.utils.pdf.PdfFileUtil;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.fileNameConfig.service.IFileNameConfigService;
import com.ruoyi.project.system.softwareCopyright.domain.SoftwareCopyrightForFileNameConfig;
import com.ruoyi.project.system.softwareCopyright.tool.SoftwareCopyrightResolvedNameRule;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.softwareCopyright.domain.SoftwareCopyright;
import com.ruoyi.project.system.softwareCopyright.service.ISoftwareCopyrightService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 软件著作权信息操作处理
 * 
 * @author daivd
 * @date 2019-11-08
 */
@Controller
@RequestMapping("/system/softwareCopyright")
public class SoftwareCopyrightController extends BaseController
{
    private String prefix = "system/softwareCopyright";
	private String temp = null;
	private String editTemp = null;
	@Autowired
	private ISoftwareCopyrightService softwareCopyrightService;
	@Autowired
	private IFileNameConfigService iFileNameConfigService;
	@RequiresPermissions("system:softwareCopyright:view")
	@GetMapping()
	public String softwareCopyright()
	{
	    return prefix + "/softwareCopyright";
	}
	
	/**
	 * 查询软件著作权列表
	 */
	@RequiresPermissions("system:softwareCopyright:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SoftwareCopyright softwareCopyright)
	{
		startPage();
        List<SoftwareCopyright> list = softwareCopyrightService.selectSoftwareCopyrightList(softwareCopyright);
		return getDataTable(list);
	}

	/**
	 * 查看详细
	 */
	@GetMapping("/detail/{softwareCopyrightId}")
	public String detail(@PathVariable("softwareCopyrightId") Integer softwareCopyrightId, ModelMap mmap)
	{
		System.out.println("查看软著详细");
		SoftwareCopyright softwareCopyright = softwareCopyrightService.selectSoftwareCopyrightById(softwareCopyrightId);
		System.out.println(softwareCopyright.getAttachFile());

		mmap.put("softwareCopyright",softwareCopyright);
		return prefix + "/detail";
	}
	/**
	 * 导出软件著作权列表
	 */
	@RequiresPermissions("system:softwareCopyright:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SoftwareCopyright softwareCopyright)
    {
    	List<SoftwareCopyright> list = softwareCopyrightService.selectSoftwareCopyrightList(softwareCopyright);
        ExcelUtil<SoftwareCopyright> util = new ExcelUtil<SoftwareCopyright>(SoftwareCopyright.class);
        return util.exportExcel(list, "softwareCopyright");
    }
	
	/**
	 * 新增软件著作权
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存软件著作权
	 */
	@RequiresPermissions("system:softwareCopyright:add")
	@Log(title = "软件著作权", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SoftwareCopyright softwareCopyright)
	{
		softwareCopyright.setAttachFile(temp);
		return toAjax(softwareCopyrightService.insertSoftwareCopyright(softwareCopyright));
	}
	/**
	 * 查询专著文件
	 */
	@RequiresPermissions("system:softwareCopyright:softwareCopyright")
	@GetMapping("/softwareCopyright")
	@ResponseBody
	public AjaxResult getPublication(@RequestParam("sCId") int sCId)
	{
		SoftwareCopyright softwareCopyright = softwareCopyrightService.selectSoftwareCopyrightById(sCId);
		System.out.println("++++++++++++++++++++++++++++");
		System.out.println(softwareCopyright);
		System.out.println("++++++++++++++++++++++++++++");
		return new AjaxResult(AjaxResult.Type.SUCCESS,"",softwareCopyright.getAttachFile());
	}
	/**
	 * 修改软件著作权
	 */
	@GetMapping("/edit/{copyrightId}")
	public String edit(@PathVariable("copyrightId") Integer copyrightId, ModelMap mmap)
	{
		SoftwareCopyright softwareCopyright = softwareCopyrightService.selectSoftwareCopyrightById(copyrightId);
		mmap.put("softwareCopyright", softwareCopyright);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存软件著作权
	 */
	@RequiresPermissions("system:softwareCopyright:edit")
	@Log(title = "软件著作权", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SoftwareCopyright softwareCopyright)
	{
		softwareCopyright.setAttachFile(editTemp);
		editTemp = null;
		return toAjax(softwareCopyrightService.updateSoftwareCopyright(softwareCopyright));
	}
	
	/**
	 * 删除软件著作权
	 */
	@RequiresPermissions("system:softwareCopyright:remove")
	@Log(title = "软件著作权", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(softwareCopyrightService.deleteSoftwareCopyrightByIds(ids));
	}

	/**
	 * 文件上传
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresPermissions("system:softwareCopyright:add")
	@Log(title = "软件著作权", businessType = BusinessType.INSERT)
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
		String fileName = FileUploadUtilSelf.upload(filePath, file,"softwareCopyright");
//		System.out.println(fileName+"//fileName");
		temp = fileName;
		Map<String,Object> result= new HashMap<String, Object>();
		result.put("msg","上传成功！");
		return result;

	}
	@RequiresPermissions("system:softwareCopyright:reorderList")
	@PostMapping("/reorderList")
	@ResponseBody
	public TableDataInfo reorderList(String jsonData){
		System.out.println(jsonData);
		List<SoftwareCopyright> list = JSONArray.parseArray(jsonData,SoftwareCopyright.class);
		softwareCopyrightService.deleteAllSoftwareCopyright();
		for (SoftwareCopyright softwareCopyright:list){
			softwareCopyrightService.insertSoftwareCopyright(softwareCopyright);
			System.out.println(softwareCopyright.getCopyrightName());
		}
		return getDataTable(list);
	}

	/**
	 * 附件下载
	 * @param copyrightId
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@GetMapping("/downloadFile/{copyrightId}")
	public void downloadFile (@PathVariable("copyrightId") Integer copyrightId, HttpServletResponse response,
							  HttpServletRequest request) throws Exception
	{

		SoftwareCopyright softwareCopyright = softwareCopyrightService.selectSoftwareCopyrightById(copyrightId);
		String filePath = softwareCopyright.getAttachFile();
		String realFileName = "软著" + filePath.substring(filePath.indexOf("."));
//        String realFileName = docPaper.getgetFileName() + filePath.substring(filePath.indexOf("."));
//        String path = RuoYiConfig.getUploadPath() + docPaper.getFilePath();
		String path = RuoYiConfig.getUploadPath() + softwareCopyright.getAttachFile();
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
	 * @param copyrightId
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@GetMapping("/downloadSplitFile/{copyrightId}")
	public void downloadSplitFile (@PathVariable("copyrightId") Integer copyrightId, HttpServletResponse response,
							  HttpServletRequest request) throws Exception
	{

		SoftwareCopyright softwareCopyright = softwareCopyrightService.selectSoftwareCopyrightById(copyrightId);
		String filePath = softwareCopyright.getAttachFile();
		String path = RuoYiConfig.getUploadPath() + softwareCopyright.getAttachFile();
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
			fileNameConfig.setNameRule("软件著作权");
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
		String realFileName = "软件著作权" + zipFilename.substring(zipFilename.indexOf("."));
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
	@RequiresPermissions("system:softwareCopyright:edit")
	@Log(title = "软件著作权", businessType = BusinessType.INSERT)
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
		String fileName = FileUploadUtilSelf.upload(filePath, file,"softwareCopyright");
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
							   @Param("copyrightId") String copyrightId
			, HttpServletResponse response,
							   HttpServletRequest request) throws Exception {
		String[] attachFiles = attachFile.split(",");
		String[] colums = column.split(",");
		String[] copyrightIds = copyrightId.split(",");
		List<String> copyrightIdsList = new ArrayList<>();
		for(int i=0;i<copyrightIds.length;i++) {
			copyrightIdsList.add(copyrightIds[i]);
		}
		List<SoftwareCopyrightForFileNameConfig> list = softwareCopyrightService.selectListForFileNameConfig(copyrightIdsList);
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
		SoftwareCopyrightResolvedNameRule resolvedNameRule = new SoftwareCopyrightResolvedNameRule();
		List<FileNameConfig> fileNameConfigList = resolvedNameRule.newNameAndOldFilePath(list, compareFileNameList, "软件著作权",
				iFileNameConfigService.selectFileNameConfigList(new FileNameConfig("软件著作权")));
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
		String realFileName = "软件著作权" + zipFilename.substring(zipFilename.indexOf("."));
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
		FileUtils.writeBytes(zipFilename, response.getOutputStream());
	}


	/**
	 * 论文合并下载
	 * @param attachFile
	 * @param column
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@GetMapping("/downloadFile/mergeDownload")
	public void mergeDownload (@Param("attachFile") String attachFile,
							   @Param("column") String column,
							   @Param("copyrightId") String copyrightId
			, HttpServletResponse response,
							   HttpServletRequest request) throws Exception {
		String[] attachFiles = attachFile.split(",");
		String[] colums = column.split(",");
		String[] copyrightIds = copyrightId.split(",");
		List<String> copyrightIdsList = new ArrayList<>();
		for(int i=0;i<copyrightIds.length;i++) {
			copyrightIdsList.add(copyrightIds[i]);
		}
		List<SoftwareCopyrightForFileNameConfig> list = softwareCopyrightService.selectListForFileNameConfig(copyrightIdsList);
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
		SoftwareCopyrightResolvedNameRule resolvedNameRule = new SoftwareCopyrightResolvedNameRule();
		List<FileNameConfig> fileNameConfigList = resolvedNameRule.newNameAndOldFilePath(list, compareFileNameList, "软件著作权",
				iFileNameConfigService.selectFileNameConfigList(new FileNameConfig("软件著作权")));
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
		fileNameConfig.setNameRule("软件著作权");
		fileNameConfigList2.add(fileNameConfig);
		/**
		 * 把文件进行压缩
		 * 其中ZipCompress类通用
		 */
		String zipFilename = "D:/profile/zipFile/tempFile.zip";
		ZipCompress zipCom = new ZipCompress(zipFilename, fileNameConfigList2, colums);
		zipCom.zip();
		//把压缩包传到前台
		String realFileName = "软件著作权" + zipFilename.substring(zipFilename.indexOf("."));
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
		FileUtils.writeBytes(zipFilename, response.getOutputStream());
	}
}
