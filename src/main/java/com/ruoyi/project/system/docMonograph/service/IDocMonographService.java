package com.ruoyi.project.system.docMonograph.service;

import com.ruoyi.project.system.docMonograph.domain.DocMonograph;
import com.ruoyi.project.system.docMonograph.domain.DocMonographForFileNameConfig;

import java.util.List;

/**
 * 专著 服务层
 * 
 * @author daivd
 * @date 2019-08-01
 */
public interface IDocMonographService 
{
	/**
     * 查询专著信息
     * 
     * @param monographId 专著ID
     * @return 专著信息
     */
	public DocMonograph selectDocMonographById(Integer monographId);
	
	/**
     * 查询专著列表
     * 
     * @param docMonograph 专著信息
     * @return 专著集合
     */
	public List<DocMonograph> selectDocMonographList(DocMonograph docMonograph);
	
	/**
     * 新增专著
     * 
     * @param docMonograph 专著信息
     * @return 结果
     */
	public int insertDocMonograph(DocMonograph docMonograph);
	
	/**
     * 修改专著
     * 
     * @param docMonograph 专著信息
     * @return 结果
     */
	public int updateDocMonograph(DocMonograph docMonograph);
		
	/**
     * 删除专著信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteDocMonographByIds(String ids);

	/**
	 * 删除所有专著信息
	 * @return
	 */
	public int deleteAllDocMonograph();
	/**
	 * 查询专著列表,为命名规则所用
	 *注：就是把表格树和字典的值拿出来
	 * @return 专著列表
	 */
	public List<DocMonographForFileNameConfig> selectListForFileNameConfig(List<String> docMonographIdList);
	
}
