package com.ruoyi.project.system.docManagePaper.mapper;

import com.ruoyi.project.system.docManagePaper.domain.DocManagePaper;
import java.util.List;	

/**
 * 作证-论文 数据层
 * 
 * @author daivd
 * @date 2019-07-08
 */
public interface DocManagePaperMapper 
{
	/**
     * 查询作证-论文信息
     * 
     * @param paperId 作证-论文ID
     * @return 作证-论文信息
     */
	public DocManagePaper selectDocManagePaperById(Integer paperId);
	
	/**
     * 查询作证-论文列表
     * 
     * @param docManagePaper 作证-论文信息
     * @return 作证-论文集合
     */
	public List<DocManagePaper> selectDocManagePaperList(DocManagePaper docManagePaper);
	
	/**
     * 新增作证-论文
     * 
     * @param docManagePaper 作证-论文信息
     * @return 结果
     */
	public int insertDocManagePaper(DocManagePaper docManagePaper);
	
	/**
     * 修改作证-论文
     * 
     * @param docManagePaper 作证-论文信息
     * @return 结果
     */
	public int updateDocManagePaper(DocManagePaper docManagePaper);
	
	/**
     * 删除作证-论文
     * 
     * @param paperId 作证-论文ID
     * @return 结果
     */
	public int deleteDocManagePaperById(Integer paperId);
	
	/**
     * 批量删除作证-论文
     * 
     * @param paperIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteDocManagePaperByIds(String[] paperIds);
	
}