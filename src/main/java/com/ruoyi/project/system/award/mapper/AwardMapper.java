package com.ruoyi.project.system.award.mapper;

import com.ruoyi.project.system.award.domain.Award;
import com.ruoyi.project.system.award.domain.AwardVO;

import java.util.List;

/**
 * 教师奖励 数据层
 * 
 * @author daivd
 * @date 2019-10-27
 */
public interface AwardMapper 
{
	/**
     * 查询教师奖励信息
     *
     * @param awardId 教师奖励ID
     * @return 教师奖励信息
     */
	public Award selectAwardById(Integer awardId);

	/**
     * 查询教师奖励信息——ViewObject
     *
     * @param awardId 教师奖励ID
     * @return 教师奖励信息
     */
	public AwardVO selectAwardVOById(Integer awardId);

	/**
     * 查询教师奖励列表
     * 
     * @param award 教师奖励信息
     * @return 教师奖励集合
     */
	public List<Award> selectAwardList(Award award);

	/**
     * 查询教师奖励列表
     *
     * @param award 教师奖励信息
     * @return 教师奖励集合
     */
	public List<AwardVO> selectAwardVOList(Award award);

	/**
     * 新增教师奖励
     * 
     * @param award 教师奖励信息
     * @return 结果
     */
	public int insertAward(Award award);
	
	/**
     * 修改教师奖励
     * 
     * @param award 教师奖励信息
     * @return 结果
     */
	public int updateAward(Award award);
	
	/**
     * 删除教师奖励
     * 
     * @param awardId 教师奖励ID
     * @return 结果
     */
	public int deleteAwardById(Integer awardId);
	
	/**
     * 批量删除教师奖励
     * 
     * @param awardIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteAwardByIds(String[] awardIds);
	
}