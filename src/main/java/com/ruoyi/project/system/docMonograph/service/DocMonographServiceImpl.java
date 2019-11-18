package com.ruoyi.project.system.docMonograph.service;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.docMonograph.domain.DocMonograph;
import com.ruoyi.project.system.docMonograph.domain.DocMonographForFileNameConfig;
import com.ruoyi.project.system.docMonograph.mapper.DocMonographMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专著 服务层实现
 * 
 * @author daivd
 * @date 2019-08-01
 */
@Service
public class DocMonographServiceImpl implements IDocMonographService
{
	@Autowired
	private DocMonographMapper docMonographMapper;

	/**
     * 查询专著信息
     * 
     * @param monographId 专著ID
     * @return 专著信息
     */
    @Override
	public DocMonograph selectDocMonographById(Integer monographId)
	{
	    return docMonographMapper.selectDocMonographById(monographId);
	}
	
	/**
     * 查询专著列表
     * 
     * @param docMonograph 专著信息
     * @return 专著集合
     */
	@Override
	public List<DocMonograph> selectDocMonographList(DocMonograph docMonograph)
	{
	    return docMonographMapper.selectDocMonographList(docMonograph);
	}
	
    /**
     * 新增专著
     * 
     * @param docMonograph 专著信息
     * @return 结果
     */
	@Override
	public int insertDocMonograph(DocMonograph docMonograph)
	{
	    return docMonographMapper.insertDocMonograph(docMonograph);
	}
	
	/**
     * 修改专著
     * 
     * @param docMonograph 专著信息
     * @return 结果
     */
	@Override
	public int updateDocMonograph(DocMonograph docMonograph)
	{
	    return docMonographMapper.updateDocMonograph(docMonograph);
	}

	/**
     * 删除专著对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDocMonographByIds(String ids)
	{
		return docMonographMapper.deleteDocMonographByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除所有专著信息
	 * @return
	 */
	@Override
	public int deleteAllDocMonograph() {
		return docMonographMapper.deleteAllDocMonograph();
	}

	/**
	 * 查询专著列表,为命名规则所用
	 *注：就是把表格树和字典的值拿出来
	 * @return 专著列表
	 */
	@Override
	public List<DocMonographForFileNameConfig> selectListForFileNameConfig(List<String> docMonographIdList) {
		return docMonographMapper.selectListForFileNameConfig(docMonographIdList);
	}
}
