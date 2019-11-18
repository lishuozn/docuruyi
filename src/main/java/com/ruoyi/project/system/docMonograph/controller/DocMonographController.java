package com.ruoyi.project.system.docMonograph.controller;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.file.ZipCompress;
import com.ruoyi.common.utils.pdf.PdfFileUtil;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.docMonograph.domain.DocMonograph;
import com.ruoyi.project.system.docMonograph.domain.DocMonographForFileNameConfig;
import com.ruoyi.project.system.docMonograph.service.IDocMonographService;


import com.ruoyi.common.utils.file.FileUploadUtilSelf;
import com.ruoyi.project.system.docMonograph.tool.DocMonographResolvedNameRule;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.fileNameConfig.service.IFileNameConfigService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 专著信息操作处理
 * 
 * @author daivd
 * @date 2019-08-01
 */
@Controller
@RequestMapping("/system/docMonograph")
public class DocMonographController extends BaseController
{
    private String prefix = "system/docMonograph";
	private String temp = null;
	private String editTemp = null;

	@Autowired
	private IDocMonographService docMonographService;
	@Autowired
	private IFileNameConfigService iFileNameConfigService;
	@RequiresPermissions("system:docMonograph:view")
	@GetMapping()
	public String docMonograph()
	{
	    return prefix + "/docMonograph";
	}
	
	/**
	 * 查询专著列表
	 */
	@RequiresPermissions("system:docMonograph:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(DocMonograph docMonograph)
	{
		startPage();
        List<DocMonograph> list = docMonographService.selectDocMonographList(docMonograph);
		return getDataTable(list);
	}
	/**
	 * 查看详细
	 */
	@GetMapping("/detail/{monographId}")
	public String detail(@PathVariable("monographId") Integer monographId, ModelMap mmap)
	{
		System.out.println("查看专著详细");
		DocMonograph monograph = docMonographService.selectDocMonographById(monographId);
//		DocPaperForFileNameConfig docPaper = docPaperService.selectDocPaperDetailById(paperId);
//		System.out.println(docPaper.getPaperKind()+"论文类别111");
//		System.out.println(docPaper.getPaperTitle()+"论文题目222");
//		System.out.println(docPaper.getAuthor1Name()+"一作名字");
//		System.out.println(docPaper.getAuthor1MajorId()+"一作专业");
//		System.out.println(docPaper.getAuthor2Name()+"二作名字");
//		System.out.println(docPaper.getAuthor2MajorId()+"二作专业");
//		System.out.println(docPaper.getJournalName()+"期刊名字");
//		System.out.println(docPaper.getJournalNumber()+"型号");
//		System.out.println(docPaper.getJournalSearchNumber()+"期刊检索号");
//		System.out.println(docPaper.getPublishDate()+"出版日期");
//		System.out.println(docPaper.getLevelIdCcec()+"校内认定等级");
//		System.out.println(docPaper.getAttachFile()+"附件");

		mmap.put("docMonograph",monograph);
		return prefix + "/detail";
	}


	/**
	 * 导出专著列表
	 */
	@RequiresPermissions("system:docMonograph:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DocMonograph docMonograph)
    {
    	List<DocMonograph> list = docMonographService.selectDocMonographList(docMonograph);
        ExcelUtil<DocMonograph> util = new ExcelUtil<DocMonograph>(DocMonograph.class);
        return util.exportExcel(list, "docMonograph");
    }
	
	/**
	 * 新增专著
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存专著
	 */
	@RequiresPermissions("system:docMonograph:add")
	@Log(title = "专著", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(DocMonograph docMonograph)
	{
		System.out.println("------------------------------");
		docMonograph.setAttachFile(temp);
		temp = null;
		System.out.println(docMonograph.getAttachFile());
		System.out.println("------------------------------");
		return toAjax(docMonographService.insertDocMonograph(docMonograph));
	}

	/**
	 * 查询专著文件
	 */
	@RequiresPermissions("system:docMonograph:docMonograph")
	@GetMapping("/docMonograph")
	@ResponseBody
	public AjaxResult getPublication(@RequestParam("dMId") int dMId)
	{
		DocMonograph docMonograph = docMonographService.selectDocMonographById(dMId);
		System.out.println("++++++++++++++++++++++++++++");
		System.out.println(docMonograph);
		System.out.println("++++++++++++++++++++++++++++");
		return new AjaxResult(AjaxResult.Type.SUCCESS,"",docMonograph.getAttachFile());
	}

	/**
	 * 修改专著
	 */
	@GetMapping("/edit/{monographId}")
	public String edit(@PathVariable("monographId") Integer monographId, ModelMap mmap)
	{
		System.out.println("++++++++++++++++++");
		System.out.println(monographId);
		DocMonograph docMonograph = docMonographService.selectDocMonographById(monographId);
		mmap.put("docMonograph", docMonograph);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存专著
	 */
	@RequiresPermissions("system:docMonograph:edit")
	@Log(title = "专著", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(DocMonograph docMonograph)
	{
		System.out.println(docMonograph.getAuthor1MajorId()+"------");
		docMonograph.setAttachFile(editTemp);
		editTemp = null;
		return toAjax(docMonographService.updateDocMonograph(docMonograph));
	}
	
	/**
	 * 删除专著
	 */
	@RequiresPermissions("system:docMonograph:remove")
	@Log(title = "专著", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(docMonographService.deleteDocMonographByIds(ids));
	}

	/**
	 * 文件上传
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresPermissions("system:docMonograph:add")
	@Log(title = "专著", businessType = BusinessType.INSERT)
	@PostMapping("/addFile")
	@ResponseBody
	public Map<String,Object> addFile(HttpServletRequest request, HttpServletResponse response)throws IOException{
 		//转型为MultipartHttpRequest：
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 获得文件：
		MultipartFile file= multipartRequest.getFile("attachFile");
		// 上传文件路径
		String filePath = RuoYiConfig.getUploadPath();
		System.out.println(filePath+"//filePath");
		// 上传并返回新文件名称
		String fileName = FileUploadUtilSelf.upload(filePath, file,"docMonograph");
		System.out.println(fileName+"//fileName");
		temp = fileName;
		Map<String,Object> result= new HashMap<String, Object>();
		result.put("msg","上传成功！");
		return result;

	}
	@RequiresPermissions("system:docMonograph:reorderList")
	@PostMapping("/reorderList")
	@ResponseBody
	public TableDataInfo reorderList(String jsonData){
		System.out.println(jsonData);

		List<DocMonograph> list = JSONArray.parseArray(jsonData,DocMonograph.class);
		docMonographService.deleteAllDocMonograph();
		for (DocMonograph docMonograph:list){
			docMonographService.insertDocMonograph(docMonograph);
			System.out.println(docMonograph.getMonographName());
		}
		return getDataTable(list);
	}

	/**
	 * 附件下载
	 * @param docMonographId
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@GetMapping("/downloadFile/{docMonographId}")
	public void downloadFile (@PathVariable("docMonographId") Integer docMonographId, HttpServletResponse response,
							  HttpServletRequest request) throws Exception
	{

		DocMonograph docMonograph = docMonographService.selectDocMonographById(docMonographId);
		String filePath = docMonograph.getAttachFile();
		String realFileName = "文档" + filePath.substring(filePath.indexOf("."));
//        String realFileName = docPaper.getgetFileName() + filePath.substring(filePath.indexOf("."));
//        String path = RuoYiConfig.getUploadPath() + docPaper.getFilePath();
		String path = RuoYiConfig.getUploadPath() + docMonograph.getAttachFile();
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
	 * @param docMonographId
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@GetMapping("/downloadSplitFile/{docMonographId}")
	public void downloadSplitFile (@PathVariable("docMonographId") Integer docMonographId, HttpServletResponse response,
								   HttpServletRequest request) throws Exception
	{

		DocMonograph docMonograph = docMonographService.selectDocMonographById(docMonographId);
		String filePath = docMonograph.getAttachFile();
		String path = RuoYiConfig.getUploadPath() + docMonograph.getAttachFile();
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
			fileNameConfig.setNameRule("专著");
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
		String realFileName = "专著" + zipFilename.substring(zipFilename.indexOf("."));
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
		FileUtils.writeBytes(zipFilename, response.getOutputStream());
	}

	/**
	 * 删除专著
	 */
	@RequiresPermissions("system:docMonograph:removeFile")
	@Log(title = "专著", businessType = BusinessType.DELETE)
	@PostMapping( "/removeFile")
	@ResponseBody
	public AjaxResult removeFile(String ids)
	{
		return toAjax(docMonographService.deleteDocMonographByIds(ids));
	}

	/**
	 * 编辑文件上传
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresPermissions("system:docMonograph:edit")
	@Log(title = "专著", businessType = BusinessType.INSERT)
	@PostMapping("/updateFile")
	@ResponseBody
	public Map<String,Object> updateFile(HttpServletRequest request, HttpServletResponse response)throws IOException {
		System.out.println("--编辑文件上传---");
		//转型为MultipartHttpRequest：
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 获得文件：
		MultipartFile file= multipartRequest.getFile("attachFile");
		// 上传文件路径
		String filePath = RuoYiConfig.getUploadPath();
		// 上传并返回新文件名称
		String fileName = FileUploadUtilSelf.upload(filePath, file,"docMonograph");
		editTemp = fileName;
		Map<String,Object> result= new HashMap<String, Object>();
		result.put("msg","上传成功！");
		return result;

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
							   @Param("monographId") String monographId
			, HttpServletResponse response,
							   HttpServletRequest request) throws Exception {
		String[] attachFiles = attachFile.split(",");
		String[] colums = column.split(",");
		String[] docMonographIds = monographId.split(",");
		List<String> docMonographIdList = new ArrayList<>();
		for(int i=0;i<docMonographIds.length;i++) {
			docMonographIdList.add(docMonographIds[i]);
		}
		List<DocMonographForFileNameConfig> list = docMonographService.selectListForFileNameConfig(docMonographIdList);
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
		DocMonographResolvedNameRule resolvedNameRule = new DocMonographResolvedNameRule();
		List<FileNameConfig> fileNameConfigList = resolvedNameRule.newNameAndOldFilePath(list, compareFileNameList, "专著",
				iFileNameConfigService.selectFileNameConfigList(new FileNameConfig("专著")));
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
		String realFileName = "专著" + zipFilename.substring(zipFilename.indexOf("."));
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
		FileUtils.writeBytes(zipFilename, response.getOutputStream());
	}

	/**
	 * 论文批量下载
	 * @param attachFile 要下载的文件名
	 * @param column 文件序号
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@GetMapping("/downloadFile/mergeDownload")
	public void mergeDownload (@Param("attachFile") String attachFile,
							   @Param("column") String column,
							   @Param("monographId") String monographId
			, HttpServletResponse response,
							   HttpServletRequest request) throws Exception {
		String[] attachFiles = attachFile.split(",");
		String[] colums = column.split(",");
		System.out.println("-----------"+monographId);
		String[] docMonographIds = monographId.split(",");
		List<String> docMonographIdList = new ArrayList<>();
		for(int i=0;i<docMonographIds.length;i++) {
			docMonographIdList.add(docMonographIds[i]);
		}
		List<DocMonographForFileNameConfig> list = docMonographService.selectListForFileNameConfig(docMonographIdList);
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
		DocMonographResolvedNameRule resolvedNameRule = new DocMonographResolvedNameRule();
		List<FileNameConfig> fileNameConfigList = resolvedNameRule.newNameAndOldFilePath(list, compareFileNameList, "专著",
				iFileNameConfigService.selectFileNameConfigList(new FileNameConfig("专著")));
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
		fileNameConfig.setNameRule("专著");
		fileNameConfigList2.add(fileNameConfig);
		/**
		 * 把文件进行压缩
		 * 其中ZipCompress类通用
		 */
		String zipFilename = "D:/profile/zipFile/tempFile.zip";
		ZipCompress zipCom = new ZipCompress(zipFilename, fileNameConfigList2, colums);
		zipCom.zip();
		//把压缩包传到前台
		String realFileName = "专著" + zipFilename.substring(zipFilename.indexOf("."));
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
		FileUtils.writeBytes(zipFilename, response.getOutputStream());
	}
}
