package com.ruoyi.project.system.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.project.mapper.ProjectMapper;
import com.ruoyi.project.system.project.domain.Project;
import com.ruoyi.project.system.project.service.IProjectService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 平台等立项文件 服务层实现
 * 
 * @author daivd
 * @date 2019-11-10
 */
@Service
public class ProjectServiceImpl implements IProjectService 
{
	@Autowired
	private ProjectMapper projectMapper;

	/**
     * 查询平台等立项文件信息
     * 
     * @param projectId 平台等立项文件ID
     * @return 平台等立项文件信息
     */
    @Override
	public Project selectProjectById(Integer projectId)
	{
	    return projectMapper.selectProjectById(projectId);
	}
	
	/**
     * 查询平台等立项文件列表
     * 
     * @param project 平台等立项文件信息
     * @return 平台等立项文件集合
     */
	@Override
	public List<Project> selectProjectList(Project project)
	{
	    return projectMapper.selectProjectList(project);
	}
	
    /**
     * 新增平台等立项文件
     * 
     * @param project 平台等立项文件信息
     * @return 结果
     */
	@Override
	public int insertProject(Project project)
	{
	    return projectMapper.insertProject(project);
	}
	
	/**
     * 修改平台等立项文件
     * 
     * @param project 平台等立项文件信息
     * @return 结果
     */
	@Override
	public int updateProject(Project project)
	{
	    return projectMapper.updateProject(project);
	}

	/**
     * 删除平台等立项文件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProjectByIds(String ids)
	{
		return projectMapper.deleteProjectByIds(Convert.toStrArray(ids));
	}
	
}
