package com.ruoyi.project.system.docPaper.service;

import java.util.List;

import com.ruoyi.project.system.docPaper.domain.DocPaperForFileNameConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.docPaper.mapper.DocPaperMapper;
import com.ruoyi.project.system.docPaper.domain.DocPaper;
import com.ruoyi.project.system.docPaper.service.IDocPaperService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 论文 服务层实现
 * 
 * @author daivd
 * @date 2019-08-05
 */
@Service
public class DocPaperServiceImpl implements IDocPaperService 
{
	@Autowired
	private DocPaperMapper docPaperMapper;

	/**
     * 查询论文信息
     * 
     * @param paperId 论文ID
     * @return 论文信息
     */
    @Override
	public DocPaper selectDocPaperById(Integer paperId)
	{
	    return docPaperMapper.selectDocPaperById(paperId);
	}

	@Override
	public DocPaperForFileNameConfig selectDocPaperDetailById(Integer paperId) {
		return docPaperMapper.selectDocPaperDetailById(paperId);
	}

	/**
     * 查询论文列表
     * 
     * @param docPaper 论文信息
     * @return 论文集合
     */
	@Override
	public List<DocPaper> selectDocPaperList(DocPaper docPaper)
	{
	    return docPaperMapper.selectDocPaperList(docPaper);
	}
	
    /**
     * 新增论文
     * 
     * @param docPaper 论文信息
     * @return 结果
     */
	@Override
	public int insertDocPaper(DocPaper docPaper)
	{
	    return docPaperMapper.insertDocPaper(docPaper);
	}
	
	/**
     * 修改论文
     * 
     * @param docPaper 论文信息
     * @return 结果
     */
	@Override
	public int updateDocPaper(DocPaper docPaper)
	{
	    return docPaperMapper.updateDocPaper(docPaper);
	}

	/**
     * 删除论文对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDocPaperByIds(String ids)
	{
		return docPaperMapper.deleteDocPaperByIds(Convert.toStrArray(ids));
	}
	/**
	 * 查询论文列表,为命名规则所用
	 *注：就是把表格树和字典的值拿出来
	 * @return 论文集合
	 */
	@Override
	public List<DocPaperForFileNameConfig> selectListForFileNameConfig() {
		return docPaperMapper.selectListForFileNameConfig();
	}

	@Override
	public int pdatePublicationAttachFilePathByPbId(int paperid, String attchFile) {
		return docPaperMapper.pdatePublicationAttachFilePathByPbId(paperid,attchFile);
	}

}
