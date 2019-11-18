package com.ruoyi.project.system.softwareCopyright.service;

import java.util.List;

import com.ruoyi.project.system.softwareCopyright.domain.SoftwareCopyrightForFileNameConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.softwareCopyright.mapper.SoftwareCopyrightMapper;
import com.ruoyi.project.system.softwareCopyright.domain.SoftwareCopyright;
import com.ruoyi.project.system.softwareCopyright.service.ISoftwareCopyrightService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 软件著作权 服务层实现
 * 
 * @author daivd
 * @date 2019-11-08
 */
@Service
public class SoftwareCopyrightServiceImpl implements ISoftwareCopyrightService 
{
	@Autowired
	private SoftwareCopyrightMapper softwareCopyrightMapper;

	/**
     * 查询软件著作权信息
     * 
     * @param copyrightId 软件著作权ID
     * @return 软件著作权信息
     */
    @Override
	public SoftwareCopyright selectSoftwareCopyrightById(Integer copyrightId)
	{
	    return softwareCopyrightMapper.selectSoftwareCopyrightById(copyrightId);
	}
	
	/**
     * 查询软件著作权列表
     * 
     * @param softwareCopyright 软件著作权信息
     * @return 软件著作权集合
     */
	@Override
	public List<SoftwareCopyright> selectSoftwareCopyrightList(SoftwareCopyright softwareCopyright)
	{
	    return softwareCopyrightMapper.selectSoftwareCopyrightList(softwareCopyright);
	}
	
    /**
     * 新增软件著作权
     * 
     * @param softwareCopyright 软件著作权信息
     * @return 结果
     */
	@Override
	public int insertSoftwareCopyright(SoftwareCopyright softwareCopyright)
	{
	    return softwareCopyrightMapper.insertSoftwareCopyright(softwareCopyright);
	}
	
	/**
     * 修改软件著作权
     * 
     * @param softwareCopyright 软件著作权信息
     * @return 结果
     */
	@Override
	public int updateSoftwareCopyright(SoftwareCopyright softwareCopyright)
	{
	    return softwareCopyrightMapper.updateSoftwareCopyright(softwareCopyright);
	}

	/**
     * 删除软件著作权对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSoftwareCopyrightByIds(String ids)
	{
		return softwareCopyrightMapper.deleteSoftwareCopyrightByIds(Convert.toStrArray(ids));
	}
	/**
	 * 删除所有教改课题信息
	 * @return
	 */
	@Override
	public int deleteAllSoftwareCopyright() {
		return softwareCopyrightMapper.deleteAllSoftwareCopyright();
	}
	/**
	 * 查询软件著作权列表,为命名规则所用
	 *注：就是把表格树和字典的值拿出来
	 * @return 软件著作权集合
	 */
	@Override
	public List<SoftwareCopyrightForFileNameConfig> selectListForFileNameConfig(List<String> copyrightIdList) {
		return softwareCopyrightMapper.selectListForFileNameConfig(copyrightIdList);
	}
}
