package com.ruoyi.project.system.utilityModelPatent.mapper;

import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.utilityModelPatent.domain.UtilityModelPatent;
import com.ruoyi.project.system.utilityModelPatent.domain.UtilityModelPatentFileNameConfig;

import java.util.List;

/**
 * 实用新型专利 数据层
 * 
 * @author daivd
 * @date 2019-11-09
 */
public interface UtilityModelPatentMapper 
{
	/**
     * 查询实用新型专利信息
     * 
     * @param patentId 实用新型专利ID
     * @return 实用新型专利信息
     */
	public UtilityModelPatent selectUtilityModelPatentById(Integer patentId);
	
	/**
     * 查询实用新型专利列表
     * 
     * @param utilityModelPatent 实用新型专利信息
     * @return 实用新型专利集合
     */
	public List<UtilityModelPatent> selectUtilityModelPatentList(UtilityModelPatent utilityModelPatent);
	
	/**
     * 新增实用新型专利
     * 
     * @param utilityModelPatent 实用新型专利信息
     * @return 结果
     */
	public int insertUtilityModelPatent(UtilityModelPatent utilityModelPatent);
	
	/**
     * 修改实用新型专利
     * 
     * @param utilityModelPatent 实用新型专利信息
     * @return 结果
     */
	public int updateUtilityModelPatent(UtilityModelPatent utilityModelPatent);
	
	/**
     * 删除实用新型专利
     * 
     * @param patentId 实用新型专利ID
     * @return 结果
     */
	public int deleteUtilityModelPatentById(Integer patentId);
	
	/**
     * 批量删除实用新型专利
     * 
     * @param patentIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteUtilityModelPatentByIds(String[] patentIds);
	public Dept selectUtilityModelPatentMajor(String inventor1_major_id);
	/**
	 * 查询科研课题列表,为命名规则所用
	 * *注：就是把表格树和字典的值拿出来
	 * @param patentIdList
	 * @return 实用新型专利集合
	 */
	public List<UtilityModelPatentFileNameConfig> selectListForFileNameConfig(List<String> patentIdList);
}