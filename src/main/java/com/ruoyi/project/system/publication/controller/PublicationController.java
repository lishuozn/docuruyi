package com.ruoyi.project.system.publication.controller;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.dept.service.IDeptService;
import com.ruoyi.project.system.docPaper.tool.ZipCompress;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.fileNameConfig.service.IFileNameConfigService;
import com.ruoyi.project.system.publication.domain.Publication;
import com.ruoyi.project.system.publication.domain.PublicationVO;
import com.ruoyi.project.system.publication.service.IPublicationService;
import com.ruoyi.project.system.publication.tools.PublicationFileNameRuleResolver;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 教材/出版物信息操作处理
 * 
 * @author daivd
 * @date 2019-08-01
 */
@Controller
@RequestMapping("/system/publication")
public class PublicationController extends BaseController
{
    private String prefix = "system/publication";

	@Autowired
	private IPublicationService publicationService;

	@Autowired
	private IFileNameConfigService iFileNameConfigService;


	private IDeptService deptService;
	private MultipartFile file;
	private Publication publication;

	@RequiresPermissions("system:publication:view")
	@GetMapping()
	public String publication()
	{
	    return prefix + "/publication";
	}
	
	/**
	 * 查询教材/出版物列表
	 */
	@RequiresPermissions("system:publication:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Publication publication)
	{
		startPage();
        //List<Publication> list = publicationService.selectPublicationList(publication);
        List<PublicationVO> list = publicationService.selectPublicationVOList(publication);

		return getDataTable(list);
	}


	/**
	 * 查询教材/出版物列表
	 */
	@GetMapping("/detail/{pbId}")
	public String detail(@PathVariable("pbId") Integer pbId, ModelMap mmap)
	{
		PublicationVO publicationVO = publicationService.selectPublicatioVOById(pbId);
		System.out.println(publicationVO);
		mmap.put("publication", publicationVO);

		return prefix + "/detail";
	}

	@GetMapping("/getAttachFile")
	@ResponseBody
	public AjaxResult getAttachFile(@RequestParam("pbId") Integer pbId)
	{
		Publication publication = publicationService.selectPublicationById(pbId);
		return new AjaxResult(AjaxResult.Type.SUCCESS,"",publication.getAttachFile());
	}


	/**
	 * 导出教材/出版物列表
	 */
	@RequiresPermissions("system:publication:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Publication publication)
    {
    	List<Publication> list = publicationService.selectPublicationList(publication);
        ExcelUtil<Publication> util = new ExcelUtil<Publication>(Publication.class);
        return util.exportExcel(list, "publication");
    }
	
	/**
	 * 新增教材/出版物
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存教材/出版物
	 */
	@RequiresPermissions("system:publication:add")
	@Log(title = "教材/出版物", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestParam("file") MultipartFile file, @RequestParam("pbKind") String pbKind,
                              @RequestParam("pbTitle") String pbTitle , @RequestParam("author1Id")int author1Id,
                              @RequestParam("author1Name")String author1Name, @RequestParam("author1MajorId")int author1MajorId,
                              @RequestParam("author2Id")int author2Id, @RequestParam("author2Name")String author2Name,
                              @RequestParam("author2MajorId")int author2MajorId , @RequestParam("authorNameOther")String authorNameOther,
                              @RequestParam("publisherName")String publisherName  , @RequestParam("publisherLevel")String publisherLevel ,
                              @RequestParam("publishDate")Date publishDate, @RequestParam("issnNumber")String issnNumber,
                              @RequestParam("publishNumber")String publishNumber, @RequestParam("notes")String notes) throws IOException {

		Publication pb = new Publication();
		pb.setPbKind(pbKind);pb.setPbTitle(pbTitle);
		pb.setAuthor1Id(author1Id);pb.setAuthor1Name(author1Name);;
		pb.setAuthor1MajorId(author1MajorId);pb.setAuthor2Id(author2Id);
		pb.setAuthor2Name(author2Name);pb.setAuthor2MajorId(author2MajorId);
		pb.setAuthorNameOther(authorNameOther);pb.setPublisherName(publisherName);
		pb.setPublisherLevel(publisherLevel);pb.setPublishDate(publishDate);
		pb.setPublishNumber(publishNumber);pb.setIssnNumber(issnNumber);
		pb.setNotes(notes);

		String filePath = RuoYiConfig.getUploadPath();
		String fileName = FileUploadUtils.uploadWithPreffix(filePath, file,"publication");

		pb.setAttachFile(fileName);

		System.out.println("============="+pb);

		if (fileName != null) {
			int insertPublication = publicationService.insertPublication(pb);

			if(insertPublication==1){
				return toAjax(true);
			}else {
				return toAjax(false);
			}
		}else {
			return toAjax(false);
		}
	}


	/**
	 * @param column
	 * @param pbId
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@GetMapping("/downloadFile/batchDownload")
	public void batchDownload (@Param("column") String column,
							   @Param("pbId") String pbId, HttpServletResponse response, HttpServletRequest request) throws Exception {
		Map<Integer,String>[] nameMaps;

		String[] colums = column.split(",");
		String[] pbIdStr = pbId.split(",");

		//获取规则对象
		List<FileNameConfig> fileNameConfigs = iFileNameConfigService.selectFileNameConfigList(new FileNameConfig("出版物"));
		String[] rules=fileNameConfigs.get(0).getNameRule().split("\\+");
		List<Integer> ruleItems = new ArrayList<>();

		for (String rule : rules) {
			ruleItems.add(Integer.parseInt(rule));
		}

		List<PublicationVO> publicationVOList = new ArrayList<>();
		for (String s:pbIdStr){
			publicationVOList.add(publicationService.selectPublicatioVOById(Integer.parseInt(s)));
		}

		List<FileNameConfig> configs = PublicationFileNameRuleResolver.resolveRule(ruleItems, publicationVOList);

		String zipFilename = "/Users/apple/IdeaProjects/ruoyi_doc/profile/zipFile/tempFile.zip";
		ZipCompress zipCom = new ZipCompress(zipFilename, configs, colums);
		zipCom.zip();
		String realFileName = "出版物" + zipFilename.substring(zipFilename.indexOf("."));
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
		FileUtils.writeBytes(zipFilename, response.getOutputStream());
	}
	/**
	 * 修改教材/出版物
	 */
	@GetMapping("/edit/{pbId}")
	public String edit(@PathVariable("pbId") Integer pbId, ModelMap mmap)
	{
		PublicationVO publicationVO = publicationService.selectPublicatioVOById(pbId);
		System.out.println(publicationVO);
		mmap.put("publication", publicationVO);

	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教材/出版物
	 */
	@RequiresPermissions("system:publication:edit")
	@Log(title = "教材/出版物", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@RequestParam("pbId") int pbId,@RequestParam(value = "file",required = false) MultipartFile file, @RequestParam("pbKind") String pbKind,
							   @RequestParam("pbTitle") String pbTitle , @RequestParam("author1Id")int author1Id,
							   @RequestParam("author1Name")String author1Name, @RequestParam("author1MajorId")int author1MajorId,
							   @RequestParam("author2Id")int author2Id, @RequestParam("author2Name")String author2Name,
							   @RequestParam("author2MajorId")int author2MajorId , @RequestParam("authorNameOther")String authorNameOther,
							   @RequestParam("publisherName")String publisherName  , @RequestParam("publisherLevel")String publisherLevel ,
							   @RequestParam("publishDate")Date publishDate, @RequestParam("issnNumber")String issnNumber,
							   @RequestParam("publishNumber")String publishNumber, @RequestParam("notes")String notes,@RequestParam("attachFile")String attachFile) throws IOException {

		//采集publication
		Publication pb = new Publication();
		pb.setPbId(pbId);
		pb.setPbKind(pbKind);
		pb.setPbTitle(pbTitle);
		pb.setAuthor1Id(author1Id);pb.setAuthor1Name(author1Name);;
		pb.setAuthor1MajorId(author1MajorId);pb.setAuthor2Id(author2Id);
		pb.setAuthor2Name(author2Name);pb.setAuthor2MajorId(author2MajorId);
		pb.setAuthorNameOther(authorNameOther);pb.setPublisherName(publisherName);
		pb.setPublisherLevel(publisherLevel);pb.setPublishDate(publishDate);
		pb.setPublishNumber(publishNumber);pb.setIssnNumber(issnNumber);
		pb.setNotes(notes);

		//如果文件不为空
		if(file!=null){
			//原有文件删除
		    removeFile(pbId, attachFile);

		    //上传文件
			String filePath = RuoYiConfig.getUploadPath();
			String fileName = FileUploadUtils.uploadWithPreffix(filePath, file,"publication");

			//更新publication
			pb.setAttachFile(fileName);
		}else {

			//保持原有文件
			pb.setAttachFile(attachFile);
		}

		//更新service
		int insertPublication = publicationService.updatePublication(pb);
		if(insertPublication==1){
			return toAjax(true);
		}else {
			return toAjax(false);
		}

	}
	
	/**
	 * 删除教材/出版物
	 */
	@RequiresPermissions("system:publication:remove")
	@Log(title = "教材/出版物", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(publicationService.deletePublicationByIds(ids));
	}


	/**
	 * @param pbId
	 * @param fileUrl
	 * @return
			 */
	public Map<String,Object> removeFile(int pbId,String fileUrl)
	{
		String baseDir = RuoYiConfig.getProfile();
		String filePath = baseDir +fileUrl;

		boolean deleteFile = FileUtils.deleteFile(filePath);
		if(deleteFile){
			System.out.println("删除文件"+filePath+"成功！");
			return new AjaxResult(AjaxResult.Type.SUCCESS,"删除成功");
		}else{
			System.out.println("删除文件"+filePath+"失败");
			return new AjaxResult(AjaxResult.Type.ERROR,"删除失败");
		}

	}



}
