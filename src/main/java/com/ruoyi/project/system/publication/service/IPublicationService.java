package com.ruoyi.project.system.publication.service;

import com.ruoyi.project.system.publication.domain.Publication;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 教材/出版物 服务层
 * 
 * @author daivd
 * @date 2019-08-01
 */
public interface IPublicationService 
{
	/**
     * 查询教材/出版物信息
     * 
     * @param pbId 教材/出版物ID
     * @return 教材/出版物信息
     */
	public Publication selectPublicationById(Integer pbId);
	
	/**
     * 查询教材/出版物列表
     * 
     * @param publication 教材/出版物信息
     * @return 教材/出版物集合
     */
	public List<Publication> selectPublicationList(Publication publication);
	
	/**
     * 新增教材/出版物
     * 
     * @param publication 教材/出版物信息
     * @return 结果
     */
	public int insertPublication(Publication publication);
	
	/**
     * 修改教材/出版物
     * 
     * @param publication 教材/出版物信息
     * @return 结果
     */
	public int updatePublication(Publication publication);
		
	/**
     * 删除教材/出版物信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePublicationByIds(String ids);

	/**
	 * @param pbId
	 * @return
	 */
	public int updatePublicationAttachFilePathByPbId(@Param("pbId") int pbId, @Param("filePath") String filePath);
	
}
