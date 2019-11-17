package com.ruoyi.project.system.sciResSubject.mapper;

import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.sciResSubject.domain.SciResSubject;
import com.ruoyi.project.system.sciResSubject.domain.SciResSubjectFileNameConfig;

import java.util.List;

/**
 * 科研课题 数据层
 * 
 * @author daivd
 * @date 2019-10-19
 */
public interface SciResSubjectMapper 
{
	/**
     * 查询科研课题信息
     * 
     * @param subjectId 科研课题ID
     * @return 科研课题信息
     */
	public SciResSubject selectSciResSubjectById(Integer subjectId);
	
	/**
     * 查询科研课题列表
     * 
     * @param sciResSubject 科研课题信息
     * @return 科研课题集合
     */
	public List<SciResSubject> selectSciResSubjectList(SciResSubject sciResSubject);
	
	/**
     * 新增科研课题
     * 
     * @param sciResSubject 科研课题信息
     * @return 结果
     */
	public int insertSciResSubject(SciResSubject sciResSubject);
	
	/**
     * 修改科研课题
     * 
     * @param sciResSubject 科研课题信息
     * @return 结果
     */
	public int updateSciResSubject(SciResSubject sciResSubject);
	
	/**
     * 删除科研课题
     * 
     * @param subjectId 科研课题ID
     * @return 结果
     */
	public int deleteSciResSubjectById(Integer subjectId);
	
	/**
     * 批量删除科研课题
     * 
     * @param subjectIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSciResSubjectByIds(String[] subjectIds);

	public Dept selectMajor1(String mod_major_id);
	/**
	 * 查询科研课题列表,为命名规则所用
	 *注：就是把表格树和字典的值拿出来
	 * @return 科研课题集合
	 */
	public List<SciResSubjectFileNameConfig> selectListForFileNameConfig(List<String> subjectIdList);
}