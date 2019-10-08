package com.ruoyi.project.system.docPaper.mapper;

import com.ruoyi.project.system.docPaper.domain.DocPaper;
import com.ruoyi.project.system.docPaper.domain.DocPaperForFileNameConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 论文 数据层
 * 
 * @author daivd
 * @date 2019-08-05
 */
public interface DocPaperMapper 
{
	/**
     * 查询论文信息
     * 
     * @param paperId 论文ID
     * @return 论文信息
     */
	public DocPaper selectDocPaperById(Integer paperId);
	/**
	 * 查询论文详细信息（为详细按钮所用）
	 *
	 * @param paperId
	 * @return论文信息
	 */
	public DocPaperForFileNameConfig selectDocPaperDetailById(Integer paperId);
	/**
     * 查询论文列表
     * 
     * @param docPaper 论文信息
     * @return 论文集合
     */
	public List<DocPaper> selectDocPaperList(DocPaper docPaper);
	
	/**
     * 新增论文
     * 
     * @param docPaper 论文信息
     * @return 结果
     */
	public int insertDocPaper(DocPaper docPaper);
	
	/**
     * 修改论文
     * 
     * @param docPaper 论文信息
     * @return 结果
     */
	public int updateDocPaper(DocPaper docPaper);
	
	/**
     * 删除论文
     * 
     * @param paperId 论文ID
     * @return 结果
     */
	public int deleteDocPaperById(Integer paperId);
	
	/**
     * 批量删除论文
     * 
     * @param paperIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteDocPaperByIds(String[] paperIds);

	/**
	 * 查询论文列表,为命名规则所用
	 *注：就是把表格树和字典的值拿出来
	 * @return 论文集合
	 */
	public List<DocPaperForFileNameConfig> selectListForFileNameConfig();

    /**
     * 根据文件id删除文件路径
     * @param paperid
     * @param attchFile
     * @return
     */
    public int pdatePublicationAttachFilePathByPbId(@Param("paperid") int paperid,@Param("attchFile") String attchFile);
}