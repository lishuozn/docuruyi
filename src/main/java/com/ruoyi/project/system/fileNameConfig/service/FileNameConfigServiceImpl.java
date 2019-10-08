package com.ruoyi.project.system.fileNameConfig.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.fileNameConfig.mapper.FileNameConfigMapper;
import com.ruoyi.project.system.fileNameConfig.domain.FileNameConfig;
import com.ruoyi.project.system.fileNameConfig.service.IFileNameConfigService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 文件命名配置 服务层实现
 * 
 * @author daivd
 * @date 2019-08-30
 */
@Service
public class FileNameConfigServiceImpl implements IFileNameConfigService 
{
	@Autowired
	private FileNameConfigMapper fileNameConfigMapper;

	/**
     * 查询文件命名配置信息
     * 
     * @param fileNameId 文件命名配置ID
     * @return 文件命名配置信息
     */
    @Override
	public FileNameConfig selectFileNameConfigById(Integer fileNameId)
	{
	    return fileNameConfigMapper.selectFileNameConfigById(fileNameId);
	}
	
	/**
     * 查询文件命名配置列表
     * 
     * @param fileNameConfig 文件命名配置信息
     * @return 文件命名配置集合
     */
	@Override
	public List<FileNameConfig> selectFileNameConfigList(FileNameConfig fileNameConfig)
	{
	    return fileNameConfigMapper.selectFileNameConfigList(fileNameConfig);
	}
	
    /**
     * 新增文件命名配置
     * 
     * @param fileNameConfig 文件命名配置信息
     * @return 结果
     */
	@Override
	public int insertFileNameConfig(FileNameConfig fileNameConfig)
	{
	    return fileNameConfigMapper.insertFileNameConfig(fileNameConfig);
	}
	
	/**
     * 修改文件命名配置
     * 
     * @param fileNameConfig 文件命名配置信息
     * @return 结果
     */
	@Override
	public int updateFileNameConfig(FileNameConfig fileNameConfig)
	{
	    return fileNameConfigMapper.updateFileNameConfig(fileNameConfig);
	}

	/**
     * 删除文件命名配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFileNameConfigByIds(String ids)
	{
		return fileNameConfigMapper.deleteFileNameConfigByIds(Convert.toStrArray(ids));
	}
	
}
