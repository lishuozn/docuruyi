package com.ruoyi.project.system.award.service;

import java.util.List;

import com.ruoyi.project.system.award.domain.AwardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.award.mapper.AwardMapper;
import com.ruoyi.project.system.award.domain.Award;
import com.ruoyi.project.system.award.service.IAwardService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 教师奖励 服务层实现
 * 
 * @author daivd
 * @date 2019-10-27
 */
@Service
public class AwardServiceImpl implements IAwardService 
{
	@Autowired
	private AwardMapper awardMapper;

	/**
     * 查询教师奖励信息
     * 
     * @param awardId 教师奖励ID
     * @return 教师奖励信息
     */
    @Override
	public Award selectAwardById(Integer awardId)
	{
	    return awardMapper.selectAwardById(awardId);
	}

	/**
	 * 查询教师奖励信息——ViewObject
	 *
	 * @param awardId 教师奖励ID
	 * @return 教师奖励信息
	 */
	@Override
	public AwardVO selectAwardVOById(Integer awardId) {
		return awardMapper.selectAwardVOById(awardId);
	}

	/**
     * 查询教师奖励列表
     * 
     * @param award 教师奖励信息
     * @return 教师奖励集合
     */
	@Override
	public List<Award> selectAwardList(Award award)
	{
	    return awardMapper.selectAwardList(award);
	}

    @Override
    public List<AwardVO> selectAwardVOList(Award award) {
        return awardMapper.selectAwardVOList(award);
    }

    /**
     * 新增教师奖励
     * 
     * @param award 教师奖励信息
     * @return 结果
     */
	@Override
	public int insertAward(Award award)
	{
	    return awardMapper.insertAward(award);
	}
	
	/**
     * 修改教师奖励
     * 
     * @param award 教师奖励信息
     * @return 结果
     */
	@Override
	public int updateAward(Award award)
	{
	    return awardMapper.updateAward(award);
	}

	/**
     * 删除教师奖励对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAwardByIds(String ids)
	{
		return awardMapper.deleteAwardByIds(Convert.toStrArray(ids));
	}
	
}
