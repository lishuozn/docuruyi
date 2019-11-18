package com.ruoyi.project.system.teachingSubject.mapper;

import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.teachingSubject.domain.TeachingSubject;
import com.ruoyi.project.system.teachingSubject.domain.TeachingSubjectForFileNameConfig;

import java.util.List;

/**
 * 教改课题 数据层
 * 
 * @author daivd
 * @date 2019-10-20
 */
public interface TeachingSubjectMapper 
{
	/**
     * 查询教改课题信息
     * 
     * @param subjectId 教改课题ID
     * @return 教改课题信息
     */
	public TeachingSubject selectTeachingSubjectById(Integer subjectId);
	
	/**
     * 查询教改课题列表
     * 
     * @param teachingSubject 教改课题信息
     * @return 教改课题集合
     */
	public List<TeachingSubject> selectTeachingSubjectList(TeachingSubject teachingSubject);
	
	/**
     * 新增教改课题
     * 
     * @param teachingSubject 教改课题信息
     * @return 结果
     */
	public int insertTeachingSubject(TeachingSubject teachingSubject);
	
	/**
     * 修改教改课题
     * 
     * @param teachingSubject 教改课题信息
     * @return 结果
     */
	public int updateTeachingSubject(TeachingSubject teachingSubject);
	
	/**
     * 删除教改课题
     * 
     * @param subjectId 教改课题ID
     * @return 结果
     */
	public int deleteTeachingSubjectById(Integer subjectId);
	
	/**
     * 批量删除教改课题
     * 
     * @param subjectIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachingSubjectByIds(String[] subjectIds);
	/**
     * 查询教改主持人专业
     *
     * @param mod_major_id 需要查找的数据ID
     * @return 结果
     */
	public Dept selectMajor(String mod_major_id);
	/**
	 * 删除所有教改课题信息
	 * @return
	 */
	public int deleteAllTeachingSubject();
	/**
	 * 查询教改课题列表,为命名规则所用
	 *注：就是把表格树和字典的值拿出来
	 * @return 教改课题集合
	 */
	public List<TeachingSubjectForFileNameConfig> selectListForFileNameConfig(List<String> subjectIdList);


}