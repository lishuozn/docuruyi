package com.ruoyi.project.system.publication.controller;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.publication.domain.Publication;
import com.ruoyi.project.system.publication.service.IPublicationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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
        List<Publication> list = publicationService.selectPublicationList(publication);
		return getDataTable(list);
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
		pb.setPbKind(pbKind);;pb.setPbTitle(pbTitle);
		pb.setAuthor1Id(author1Id);pb.setAuthor1Name(author1Name);;
		pb.setAuthor1MajorId(author1MajorId);pb.setAuthor2Id(author2Id);
		pb.setAuthor2Name(author2Name);pb.setAuthor2MajorId(author2MajorId);
		pb.setAuthorNameOther(authorNameOther);pb.setPublisherName(publisherName);
		pb.setPublisherLevel(publisherLevel);pb.setPublishDate(publishDate);
		pb.setPublishNumber(publishNumber);pb.setIssnNumber(issnNumber);
		pb.setNotes(notes);

		String filePath = RuoYiConfig.getUploadPath();
		String fileName = null;
		fileName = FileUploadUtils.upload(filePath, file);

		pb.setAttachFile(filePath+fileName);

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
	 * 修改教材/出版物
	 */
	@GetMapping("/edit/{pbId}")
	public String edit(@PathVariable("pbId") Integer pbId, ModelMap mmap)
	{
		Publication publication = publicationService.selectPublicationById(pbId);
		mmap.put("publication", publication);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教材/出版物
	 */
	@RequiresPermissions("system:publication:edit")
	@Log(title = "教材/出版物", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Publication publication)
	{		
		return toAjax(publicationService.updatePublication(publication));
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


}
