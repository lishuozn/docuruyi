package com.ruoyi.project.system.docManagePaper.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.docManagePaper.mapper.DocManagePaperMapper;
import com.ruoyi.project.system.docManagePaper.domain.DocManagePaper;
import com.ruoyi.project.system.docManagePaper.service.IDocManagePaperService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 作证-论文 服务层实现
 * 
 * @author daivd
 * @date 2019-07-08
 */
@Service
public class DocManagePaperServiceImpl implements IDocManagePaperService 
{
	@Autowired
	private DocManagePaperMapper docManagePaperMapper;

	/**
     * 查询作证-论文信息
     * 
     * @param paperId 作证-论文ID
     * @return 作证-论文信息
     */
    @Override
	public DocManagePaper selectDocManagePaperById(Integer paperId)
	{
	    return docManagePaperMapper.selectDocManagePaperById(paperId);
	}
	
	/**
     * 查询作证-论文列表
     * 
     * @param docManagePaper 作证-论文信息
     * @return 作证-论文集合
     */
	@Override
	public List<DocManagePaper> selectDocManagePaperList(DocManagePaper docManagePaper)
	{
	    return docManagePaperMapper.selectDocManagePaperList(docManagePaper);
	}
	
    /**
     * 新增作证-论文
     * 
     * @param docManagePaper 作证-论文信息
     * @return 结果
     */
	@Override
	public int insertDocManagePaper(DocManagePaper docManagePaper)
	{
	    return docManagePaperMapper.insertDocManagePaper(docManagePaper);
	}
	
	/**
     * 修改作证-论文
     * 
     * @param docManagePaper 作证-论文信息
     * @return 结果
     */
	@Override
	public int updateDocManagePaper(DocManagePaper docManagePaper)
	{
	    return docManagePaperMapper.updateDocManagePaper(docManagePaper);
	}

	/**
     * 删除作证-论文对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDocManagePaperByIds(String ids)
	{
		return docManagePaperMapper.deleteDocManagePaperByIds(Convert.toStrArray(ids));
	}
	
}
