package com.ruoyi.project.system.sciResSubject.service;

import java.util.List;

import com.ruoyi.project.system.sciResSubject.domain.SciResSubjectFileNameConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.sciResSubject.mapper.SciResSubjectMapper;
import com.ruoyi.project.system.sciResSubject.domain.SciResSubject;
import com.ruoyi.project.system.sciResSubject.service.ISciResSubjectService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 科研课题 服务层实现
 * 
 * @author daivd
 * @date 2019-10-19
 */
@Service
public class SciResSubjectServiceImpl implements ISciResSubjectService 
{
	@Autowired
	private SciResSubjectMapper sciResSubjectMapper;

	/**
     * 查询科研课题信息
     * 
     * @param subjectId 科研课题ID
     * @return 科研课题信息
     */
    @Override
	public SciResSubject selectSciResSubjectById(Integer subjectId)
	{
	    return sciResSubjectMapper.selectSciResSubjectById(subjectId);
	}
	
	/**
     * 查询科研课题列表
     * 
     * @param sciResSubject 科研课题信息
     * @return 科研课题集合
     */
	@Override
	public List<SciResSubject> selectSciResSubjectList(SciResSubject sciResSubject)
	{
	    return sciResSubjectMapper.selectSciResSubjectList(sciResSubject);
	}
	
    /**
     * 新增科研课题
     * 
     * @param sciResSubject 科研课题信息
     * @return 结果
     */
	@Override
	public int insertSciResSubject(SciResSubject sciResSubject)
	{
	    return sciResSubjectMapper.insertSciResSubject(sciResSubject);
	}
	
	/**
     * 修改科研课题
     * 
     * @param sciResSubject 科研课题信息
     * @return 结果
     */
	@Override
	public int updateSciResSubject(SciResSubject sciResSubject)
	{
	    return sciResSubjectMapper.updateSciResSubject(sciResSubject);
	}

	/**
     * 删除科研课题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSciResSubjectByIds(String ids)
	{
		return sciResSubjectMapper.deleteSciResSubjectByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<SciResSubjectFileNameConfig> selectListForFileNameConfig(List<String> subjectIdList) {
		return sciResSubjectMapper.selectListForFileNameConfig(subjectIdList);
	}

}
