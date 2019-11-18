package com.ruoyi.project.system.invention.service;

import java.util.List;

import com.ruoyi.project.system.invention.domain.InventionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.invention.mapper.InventionMapper;
import com.ruoyi.project.system.invention.domain.Invention;
import com.ruoyi.project.system.invention.service.IInventionService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 发明专利 服务层实现
 * 
 * @author daivd
 * @date 2019-11-16
 */
@Service
public class InventionServiceImpl implements IInventionService 
{
	@Autowired
	private InventionMapper inventionMapper;

	/**
     * 查询发明专利信息
     * 
     * @param inventionId 发明专利ID
     * @return 发明专利信息
     */
    @Override
	public Invention selectInventionById(Integer inventionId)
	{
	    return inventionMapper.selectInventionById(inventionId);
	}

    @Override
    public InventionVO selectInventionVOById(Integer inventionId) {
        return inventionMapper.selectInventionVOById(inventionId);
    }

    /**
     * 查询发明专利列表
     * 
     * @param invention 发明专利信息
     * @return 发明专利集合
     */
	@Override
	public List<Invention> selectInventionList(Invention invention)
	{
	    return inventionMapper.selectInventionList(invention);
	}

    @Override
    public List<InventionVO> selectInventionVOList(Invention invention) {
        return inventionMapper.selectInventionVOList(invention);
    }

    /**
     * 新增发明专利
     * 
     * @param invention 发明专利信息
     * @return 结果
     */
	@Override
	public int insertInvention(Invention invention)
	{
	    return inventionMapper.insertInvention(invention);
	}
	
	/**
     * 修改发明专利
     * 
     * @param invention 发明专利信息
     * @return 结果
     */
	@Override
	public int updateInvention(Invention invention)
	{
	    return inventionMapper.updateInvention(invention);
	}

	/**
     * 删除发明专利对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteInventionByIds(String ids)
	{
		return inventionMapper.deleteInventionByIds(Convert.toStrArray(ids));
	}
	
}
