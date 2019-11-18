package com.ruoyi.project.system.softwareCopyright.mapper;

import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.softwareCopyright.domain.SoftwareCopyright;
import com.ruoyi.project.system.softwareCopyright.domain.SoftwareCopyrightForFileNameConfig;

import java.util.List;

/**
 * 软件著作权 数据层
 * 
 * @author daivd
 * @date 2019-11-08
 */
public interface SoftwareCopyrightMapper 
{
	/**
     * 查询软件著作权信息
     * 
     * @param copyrightId 软件著作权ID
     * @return 软件著作权信息
     */
	public SoftwareCopyright selectSoftwareCopyrightById(Integer copyrightId);
	
	/**
     * 查询软件著作权列表
     * 
     * @param softwareCopyright 软件著作权信息
     * @return 软件著作权集合
     */
	public List<SoftwareCopyright> selectSoftwareCopyrightList(SoftwareCopyright softwareCopyright);
	
	/**
     * 新增软件著作权
     * 
     * @param softwareCopyright 软件著作权信息
     * @return 结果
     */
	public int insertSoftwareCopyright(SoftwareCopyright softwareCopyright);
	
	/**
     * 修改软件著作权
     * 
     * @param softwareCopyright 软件著作权信息
     * @return 结果
     */
	public int updateSoftwareCopyright(SoftwareCopyright softwareCopyright);
	
	/**
     * 删除软件著作权
     * 
     * @param copyrightId 软件著作权ID
     * @return 结果
     */
	public int deleteSoftwareCopyrightById(Integer copyrightId);
	
	/**
     * 批量删除软件著作权
     * 
     * @param copyrightIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSoftwareCopyrightByIds(String[] copyrightIds);
	/**
	 * 删除所有软著信息
	 * @return
	 */
	public int deleteAllSoftwareCopyright();
	/**
	 * 查询软著作人专业
	 *
	 * @param software_copyright_major_id 需要查找的数据ID
	 * @return 结果
	 */
	public Dept selectSoftwareCopyrightMajor(String software_copyright_major_id);

	/**
	 * 查询软件著作权列表,为命名规则所用
	 *注：就是把表格树和字典的值拿出来
	 * @return 软件著作权集合
	 */
	public List<SoftwareCopyrightForFileNameConfig> selectListForFileNameConfig(List<String> subjectIdList);
	
}