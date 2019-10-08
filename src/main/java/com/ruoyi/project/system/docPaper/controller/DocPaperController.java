package com.ruoyi.project.system.docPaper.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.docPaper.domain.DocPaperForFileNameConfig;
import com.ruoyi.project.system.docPaper.tool.ResolvedNameRule;
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
import com.ruoyi.project.system.docPaper.domain.DocPaper;
import com.ruoyi.project.system.docPaper.service.IDocPaperService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 论文信息操作处理
 * 
 * @author daivd
 * @date 2019-08-05
 */
@Controller
@RequestMapping("/system/docPaper")
public class DocPaperController extends BaseController
{
    private String prefix = "system/docPaper";
	
	@Autowired
	private IDocPaperService docPaperService;
    @Autowired
    private IFileNameConfigService iFileNameConfigService;
	
	@RequiresPermissions("system:docPaper:view")
	@GetMapping()
	public String docPaper()
	{
	    return prefix + "/docPaper";
	}
	
	/**
	 * 查询论文列表
	 */
	@RequiresPermissions("system:docPaper:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(DocPaper docPaper)
	{
		startPage();
        List<DocPaper> list = docPaperService.selectDocPaperList(docPaper);
		return getDataTable(list);
	}

	/**
	 * 查看详细
	 */
	@GetMapping("/detail/{paperId}")
	public String detail(@PathVariable("paperId") Integer paperId, ModelMap mmap)
	{
//		DocPaper docPaper = docPaperService.selectDocPaperById(paperId);
        DocPaperForFileNameConfig docPaper = docPaperService.selectDocPaperDetailById(paperId);
		System.out.println(docPaper.getPaperKind()+"论文类别111");
		System.out.println(docPaper.getPaperTitle()+"论文题目222");
		System.out.println(docPaper.getAuthor1Name()+"一作名字");
		System.out.println(docPaper.getAuthor1MajorId()+"一作专业");
		System.out.println(docPaper.getAuthor2Name()+"二作名字");
		System.out.println(docPaper.getAuthor2MajorId()+"二作专业");
		System.out.println(docPaper.getJournalName()+"期刊名字");
		System.out.println(docPaper.getJournalNumber()+"型号");
		System.out.println(docPaper.getJournalSearchNumber()+"期刊检索号");
		System.out.println(docPaper.getPublishDate()+"出版日期");
		System.out.println(docPaper.getLevelIdCcec()+"校内认定等级");
		System.out.println(docPaper.getAttachFile()+"附件");

		mmap.put("docPaper",docPaper);
		return prefix + "/detail";
	}

	/**
	 * 导出论文列表
	 */
	@RequiresPermissions("system:docPaper:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DocPaper docPaper)
    {
    	List<DocPaper> list = docPaperService.selectDocPaperList(docPaper);
        ExcelUtil<DocPaper> util = new ExcelUtil<DocPaper>(DocPaper.class);
        return util.exportExcel(list, "docPaper");
    }
	
	/**
	 * 新增论文
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}

    /**
     * 新增保存论文
     */
    @RequiresPermissions("system:docPaper:add")
    @Log(title = "论文", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file") MultipartFile file,
                              @RequestParam("paperKind") String paperKind,
                              @RequestParam("paperTitle") String paperTitle,
                              @RequestParam("author1Id") String author1Id,
                              @RequestParam("author1Name") String author1Name,
                              @RequestParam("author1MajorId") String author1MajorId,
                              @RequestParam("author2Name") String author2Name,
                              @RequestParam("author2MajorId") String author2MajorId,
                              @RequestParam("authorNameOther") String authorNameOther,
                              @RequestParam("firstUnit") String firstUnit,
                              @RequestParam("secondUnit") String secondUnit,
                              @RequestParam("journalName") String journalName,
                              @RequestParam("journalNumber") String journalNumber,
                              @RequestParam("journalSearchNumber") String journalSearchNumber,
                              @RequestParam("publishDate") String publishDate,
                              @RequestParam("reelNumber") String reelNumber,
                              @RequestParam("pageStart") String pageStart,
                              @RequestParam("pageEnd") String pageEnd,
                              @RequestParam("funds") String funds,
                              @RequestParam("levelIdCcec") String levelIdCcec,
                              DocPaper docPaper) throws IOException, ParseException {
//        System.out.println(paperKind+"//\n"+
//                paperTitle+"//\n"+
//                author1Id+"//\n"+
//                author1Name+"//\n"+
//                author1MajorId+"//\n"+
//                author2Name+"//\n"+
//                author2MajorId+"//\n"+
//                authorNameOther+"//\n"+
//                journalName+"//\n"+
//                journalNumber+"//\n"+
//                journalSearchNumber+"//\n"+
//                publishDate+"//\n"+
//                reelNumber+"//\n"+
//                pageStart+"//\n"+
//                pageEnd+"//\n"+
//                funds+"//\n"+
//                levelIdCcec);
        docPaper.setPaperKind(Integer.parseInt(paperKind));
        if (!author1Id.equals("")){
            docPaper.setAuthor1Id(Integer.parseInt(author1Id));
        }
        docPaper.setAuthor1MajorId(Integer.parseInt(author1MajorId));
        if (!author2MajorId.equals("")){
            docPaper.setAuthor2MajorId(Integer.parseInt(author2MajorId));
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = formatter.parse(publishDate);
        docPaper.setPublishDate(newDate);
        docPaper.setPageStart(Integer.parseInt(pageStart));
        docPaper.setPageEnd(Integer.parseInt(pageEnd));
        docPaper.setLevelIdCcec(Integer.parseInt(levelIdCcec));
        docPaper.setFirstUnit(firstUnit);
        docPaper.setSecondUnit(secondUnit);
        // 上传文件路径
        String filePath = RuoYiConfig.getUploadPath();
		System.out.println(filePath+"//filePath");
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, file);
		System.out.println(fileName+"//fileName");
        docPaper.setAttachFile(fileName);
        return toAjax(docPaperService.insertDocPaper(docPaper));
    }
    /**
     * 查询论文列表
     */
    @GetMapping("/docPaper")
    @ResponseBody
    public AjaxResult getPublication(@RequestParam("pbId") int pbId)
    {
        DocPaper docPaper = docPaperService.selectDocPaperById(pbId);
        System.out.println(docPaper);
        return new AjaxResult(AjaxResult.Type.SUCCESS,"",docPaper.getAttachFile());
    }
	/**
	 * 修改论文
	 */
	@GetMapping("/edit/{paperId}")
	public String edit(@PathVariable("paperId") Integer paperId, ModelMap mmap)
	{
		DocPaper docPaper = docPaperService.selectDocPaperById(paperId);
        System.out.println(docPaper);
		mmap.put("docPaper", docPaper);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存论文
	 */
	@RequiresPermissions("system:docPaper:edit")
	@Log(title = "论文", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@RequestParam(value = "file",required = false) MultipartFile file ,
                               @RequestParam("paperId") int paperId,
                               @RequestParam("paperKind") String paperKind,
                               @RequestParam("paperTitle") String paperTitle,
                               @RequestParam("author1Id") String author1Id,
                               @RequestParam("author1Name") String author1Name,
                               @RequestParam("author1MajorId") String author1MajorId,
                               @RequestParam("author2Name") String author2Name,
                               @RequestParam("author2MajorId") String author2MajorId,
                               @RequestParam("authorNameOther") String authorNameOther,
                               @RequestParam("firstUnit") String firstUnit,
                               @RequestParam("secondUnit") String secondUnit,
                               @RequestParam("journalName") String journalName,
                               @RequestParam("journalNumber") String journalNumber,
                               @RequestParam("journalSearchNumber") String journalSearchNumber,
                               @RequestParam("publishDate") String publishDate,
                               @RequestParam("reelNumber") String reelNumber,
                               @RequestParam("pageStart") String pageStart,
                               @RequestParam("pageEnd") String pageEnd,
                               @RequestParam("funds") String funds,
                               @RequestParam("levelIdCcec") String levelIdCcec,
                               @RequestParam("attachFile")String attachFile,
                               DocPaper docPaper) {
//        System.out.println(
//                paperId+"//\n" +
//                paperKind + "//\n" +
//                paperTitle + "//\n" +
//                author1Id + "//\n" +
//                author1Name + "//\n" +
//                author1MajorId + "//\n" +
//                author2Name + "//\n" +
//                author2MajorId + "//\n" +
//                authorNameOther + "//\n" +
//                journalName + "//\n" +
//                journalNumber + "//\n" +
//                journalSearchNumber + "//\n" +
//                publishDate + "//\n" +
//                reelNumber + "//\n" +
//                pageStart + "//\n" +
//                pageEnd + "//\n" +
//                funds + "//\n" +
//                levelIdCcec+ "//\n" +
//                attachFile );
        //为DocPaper赋值
        docPaper.setPaperKind(Integer.parseInt(paperKind));
        if (!author1Id.equals("")){
            docPaper.setAuthor1Id(Integer.parseInt(author1Id));
        }
        if(!author1MajorId.equals("")) {
            docPaper.setAuthor1MajorId(Integer.parseInt(author1MajorId));
        }
        if (!author2MajorId.equals("")){
            docPaper.setAuthor2MajorId(Integer.parseInt(author2MajorId));
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = null;
        try {
            newDate = formatter.parse(publishDate);
        } catch (ParseException e) {
            System.out.println("日期转换错误");
        }
        docPaper.setPublishDate(newDate);
        docPaper.setPageStart(Integer.parseInt(pageStart));
        docPaper.setPageEnd(Integer.parseInt(pageEnd));
        docPaper.setLevelIdCcec(Integer.parseInt(levelIdCcec));
        docPaper.setFirstUnit(firstUnit);
        docPaper.setSecondUnit(secondUnit);

        //如果文件不为空
        if (file != null) {
            //原有文件删除
            removeFile(paperId, attachFile);
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = null;
            try {
                fileName = FileUploadUtils.upload(filePath, file);
            } catch (IOException e) {
                System.out.println("文件上传失败");
            }
            //更新Docpaper
            docPaper.setAttachFile(fileName);
        } else {
            //保持原有文件
            docPaper.setAttachFile(attachFile);
        }
        //更新service
        int insertPublication = docPaperService.updateDocPaper(docPaper);
        if (insertPublication == 1) {
            return toAjax(true);
        } else {
            return toAjax(false);
//            return toAjax(1);
//		return toAjax(docPaperService.updateDocPaper(docPaper));
        }
	}

        /**
         * 删除论文
         */
        @RequiresPermissions("system:docPaper:remove")
        @Log(title = "论文", businessType = BusinessType.DELETE)
        @PostMapping("/remove")
        @ResponseBody
        public AjaxResult remove (String ids)
        {
            return toAjax(docPaperService.deleteDocPaperByIds(ids));
        }

        /**
         * 附件下载
         * @param paperId
         * @param response
         * @param request
         * @throws Exception
         */
        @GetMapping("/downloadFile/{paperId}")
        public void downloadFile (@PathVariable("paperId") Integer paperId, HttpServletResponse response,
                HttpServletRequest request) throws Exception
        {

            DocPaper docPaper = docPaperService.selectDocPaperById(paperId);
            String filePath = docPaper.getAttachFile();
            String realFileName = "paperName" + filePath.substring(filePath.indexOf("."));
//        String realFileName = docPaper.getgetFileName() + filePath.substring(filePath.indexOf("."));
//        String path = RuoYiConfig.getUploadPath() + docPaper.getFilePath();
            String path = RuoYiConfig.getUploadPath() + docPaper.getAttachFile();
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            System.out.println(path + "///");
            System.out.println(realFileName + "///");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(path, response.getOutputStream());
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
                @Param("column") String column
                , HttpServletResponse response,
                HttpServletRequest request) throws Exception {
            //将下载的文件名转为字符串集合
            String[] attachFiles = attachFile.split(",");
            String[] colums = column.split(",");
            for (int i = 0; i < colums.length; i++) {
                System.out.println(colums[i] + "]]]]");
            }
            List<String> listFilePaths = new ArrayList();
            List<String> compareFileNameList = new ArrayList<>();
            for (int i = 0; i < attachFiles.length; i++) {
                listFilePaths.add(RuoYiConfig.getUploadPath() + attachFiles[i]);
                compareFileNameList.add(attachFiles[i]);

            }
            //解析命名规则
            List<DocPaperForFileNameConfig> list = docPaperService.selectListForFileNameConfig();
            ResolvedNameRule resolvedNameRule = new ResolvedNameRule();
            List<FileNameConfig> fileNameConfigList = resolvedNameRule.newNameAndOldFilePath(list, compareFileNameList, "论文",
                    iFileNameConfigService.selectFileNameConfigList(new FileNameConfig("论文")));
            //把文件进行压缩
            String zipFilename = "D:/profile/zipFile/tempFile.zip";
            ZipCompress zipCom = new ZipCompress(zipFilename, fileNameConfigList, colums);
            zipCom.zip();
            //把压缩包传到前台
            String realFileName = "论文" + zipFilename.substring(zipFilename.indexOf("."));
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(zipFilename, response.getOutputStream());
        }

//    /**
//     * 删除论文文件
//     */
//    @RequiresPermissions("system:publication:remove")
//    @Log(title = "教材/出版物", businessType = BusinessType.DELETE)
//    @PostMapping( "/removeFile")
//    @ResponseBody
//    public AjaxResult removeFile(@RequestParam("pbId")int pbId,@RequestParam("fileUrl")String fileUrl)
//    {
//        String baseDir = RuoYiConfig.getProfile();
//        String filePath = baseDir +fileUrl;
//        System.out.println(filePath);
//        boolean deleteFile = FileUtils.deleteFile(filePath);
//        int row = docPaperService.pdatePublicationAttachFilePathByPbId(pbId, "");
//        if(deleteFile&&row!=0){
//            return new AjaxResult(AjaxResult.Type.SUCCESS,"删除成功，请更新您的著作文件！");
//        }else{
//            return new AjaxResult(AjaxResult.Type.ERROR,"删除失败");
//        }
//    }

        /**
         * 用户更新文件时，上传新文件，需要删除旧文件
         * @param pbId
         * @param fileUrl
         * @return
         */
        public Map<String, Object> removeFile ( int pbId, String fileUrl)
        {
            String baseDir = RuoYiConfig.getProfile();
            String filePath = baseDir + fileUrl;

            boolean deleteFile = FileUtils.deleteFile(filePath);

            //int row = publicationService.updatePublicationAttachFilePathByPbId(pbId, "");

            if (deleteFile) {
                System.out.println("删除文件" + filePath + "成功！");
                return new AjaxResult(AjaxResult.Type.SUCCESS, "删除成功");
            } else {
                System.out.println("删除文件" + filePath + "失败");
                return new AjaxResult(AjaxResult.Type.ERROR, "删除失败");
            }

        }
}
