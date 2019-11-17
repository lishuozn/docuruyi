package com.ruoyi.project.system.utilityModelPatent.service;

import java.util.List;

import com.ruoyi.project.system.utilityModelPatent.domain.UtilityModelPatentFileNameConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.utilityModelPatent.mapper.UtilityModelPatentMapper;
import com.ruoyi.project.system.utilityModelPatent.domain.UtilityModelPatent;
import com.ruoyi.project.system.utilityModelPatent.service.IUtilityModelPatentService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 实用新型专利 服务层实现
 * 
 * @author daivd
 * @date 2019-11-09
 */
@Service
public class UtilityModelPatentServiceImpl implements IUtilityModelPatentService 
{
	@Autowired
	private UtilityModelPatentMapper utilityModelPatentMapper;

	/**
     * 查询实用新型专利信息
     * 
     * @param patentId 实用新型专利ID
     * @return 实用新型专利信息
     */
    @Override
	public UtilityModelPatent selectUtilityModelPatentById(Integer patentId)
	{
	    return utilityModelPatentMapper.selectUtilityModelPatentById(patentId);
	}
	
	/**
     * 查询实用新型专利列表
     * 
     * @param utilityModelPatent 实用新型专利信息
     * @return 实用新型专利集合
     */
	@Override
	public List<UtilityModelPatent> selectUtilityModelPatentList(UtilityModelPatent utilityModelPatent)
	{
	    return utilityModelPatentMapper.selectUtilityModelPatentList(utilityModelPatent);
	}
	
    /**
     * 新增实用新型专利
     * 
     * @param utilityModelPatent 实用新型专利信息
     * @return 结果
     */
	@Override
	public int insertUtilityModelPatent(UtilityModelPatent utilityModelPatent)
	{
	    return utilityModelPatentMapper.insertUtilityModelPatent(utilityModelPatent);
	}
	
	/**
     * 修改实用新型专利
     * 
     * @param utilityModelPatent 实用新型专利信息
     * @return 结果
     */
	@Override
	public int updateUtilityModelPatent(UtilityModelPatent utilityModelPatent)
	{
	    return utilityModelPatentMapper.updateUtilityModelPatent(utilityModelPatent);
	}

	/**
     * 删除实用新型专利对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUtilityModelPatentByIds(String ids)
	{
		return utilityModelPatentMapper.deleteUtilityModelPatentByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<UtilityModelPatentFileNameConfig> selectListForFileNameConfig(List<String> patentIdList) {
		return utilityModelPatentMapper.selectListForFileNameConfig(patentIdList);
	}

}
