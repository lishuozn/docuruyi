package com.ruoyi.project.system.publication.service;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.publication.domain.Publication;
import com.ruoyi.project.system.publication.mapper.PublicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教材/出版物 服务层实现
 * 
 * @author daivd
 * @date 2019-08-01
 */
@Service
public class PublicationServiceImpl implements IPublicationService
{
	@Autowired
	private PublicationMapper publicationMapper;

	/**
     * 查询教材/出版物信息
     * 
     * @param pbId 教材/出版物ID
     * @return 教材/出版物信息
     */
    @Override
	public Publication selectPublicationById(Integer pbId)
	{
	    return publicationMapper.selectPublicationById(pbId);
	}
	
	/**
     * 查询教材/出版物列表
     * 
     * @param publication 教材/出版物信息
     * @return 教材/出版物集合
     */
	@Override
	public List<Publication> selectPublicationList(Publication publication)
	{
	    return publicationMapper.selectPublicationList(publication);
	}
	
    /**
     * 新增教材/出版物
     * 
     * @param publication 教材/出版物信息
     * @return 结果
     */
	@Override
	public int insertPublication(Publication publication)
	{
	    return publicationMapper.insertPublication(publication);
	}
	
	/**
     * 修改教材/出版物
     * 
     * @param publication 教材/出版物信息
     * @return 结果
     */
	@Override
	public int updatePublication(Publication publication)
	{
	    return publicationMapper.updatePublication(publication);
	}

	/**
     * 删除教材/出版物对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePublicationByIds(String ids)
	{
		return publicationMapper.deletePublicationByIds(Convert.toStrArray(ids));
	}

	@Override
	public int updatePublicationAttachFilePathByPbId(int pbId, String filePath) {
		return publicationMapper.updatePublicationAttachFilePathByPbId(pbId,filePath);
	}

}
