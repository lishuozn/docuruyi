package com.ruoyi.project.system.teachingSubject.service;

import java.util.List;

import com.ruoyi.project.system.teachingSubject.domain.TeachingSubjectForFileNameConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.teachingSubject.mapper.TeachingSubjectMapper;
import com.ruoyi.project.system.teachingSubject.domain.TeachingSubject;
import com.ruoyi.project.system.teachingSubject.service.ITeachingSubjectService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 教改课题 服务层实现
 * 
 * @author daivd
 * @date 2019-10-20
 */
@Service
public class TeachingSubjectServiceImpl implements ITeachingSubjectService 
{
	@Autowired
	private TeachingSubjectMapper teachingSubjectMapper;

	/**
     * 查询教改课题信息
     * 
     * @param subjectId 教改课题ID
     * @return 教改课题信息
     */
    @Override
	public TeachingSubject selectTeachingSubjectById(Integer subjectId)
	{
	    return teachingSubjectMapper.selectTeachingSubjectById(subjectId);
	}
	
	/**
     * 查询教改课题列表
     * 
     * @param teachingSubject 教改课题信息
     * @return 教改课题集合
     */
	@Override
	public List<TeachingSubject> selectTeachingSubjectList(TeachingSubject teachingSubject)
	{
	    return teachingSubjectMapper.selectTeachingSubjectList(teachingSubject);
	}
	
    /**
     * 新增教改课题
     * 
     * @param teachingSubject 教改课题信息
     * @return 结果
     */
	@Override
	public int insertTeachingSubject(TeachingSubject teachingSubject)
	{
	    return teachingSubjectMapper.insertTeachingSubject(teachingSubject);
	}
	
	/**
     * 修改教改课题
     * 
     * @param teachingSubject 教改课题信息
     * @return 结果
     */
	@Override
	public int updateTeachingSubject(TeachingSubject teachingSubject)
	{
	    return teachingSubjectMapper.updateTeachingSubject(teachingSubject);
	}

	/**
     * 删除教改课题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachingSubjectByIds(String ids)
	{
		return teachingSubjectMapper.deleteTeachingSubjectByIds(Convert.toStrArray(ids));
	}
	/**
	 * 删除所有教改课题信息
	 * @return
	 */
	@Override
	public int deleteAllTeachingSubject() {
		return teachingSubjectMapper.deleteAllTeachingSubject();
	}

	/**
	 * 查询教改课题列表,为命名规则所用
	 *注：就是把表格树和字典的值拿出来
	 * @return 教改课题集合
	 */
	@Override
	public List<TeachingSubjectForFileNameConfig> selectListForFileNameConfig(List<String> subjectIdList) {
		return teachingSubjectMapper.selectListForFileNameConfig(subjectIdList);
	}
}
