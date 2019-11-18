package com.ruoyi.project.system.invention.mapper;

import com.ruoyi.project.system.invention.domain.Invention;
import com.ruoyi.project.system.invention.domain.InventionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 发明专利 数据层
 * 
 * @author daivd
 * @date 2019-11-16
 */
public interface InventionMapper 
{
	/**
     * 查询发明专利信息
     * 
     * @param inventionId 发明专利ID
     * @return 发明专利信息
     */
	public Invention selectInventionById(Integer inventionId);

	/**
     * 查询发明专利信息View Object
     *
     * @param inventionId 发明专利ID
     * @return 发明专利信息
     */
	public InventionVO selectInventionVOById(@Param("inventionId") Integer inventionId);

	/**
     * 查询发明专利列表
     * 
     * @param invention 发明专利信息
     * @return 发明专利集合
     */
	public List<Invention> selectInventionList(Invention invention);


	/**
	 * 查询发明专利列表 view object
	 *
	 * @param invention 发明专利信息
	 * @return 发明专利集合
	 */
	public List<InventionVO> selectInventionVOList(Invention invention);
	/**
     * 新增发明专利
     * 
     * @param invention 发明专利信息
     * @return 结果
     */
	public int insertInvention(Invention invention);
	
	/**
     * 修改发明专利
     * 
     * @param invention 发明专利信息
     * @return 结果
     */
	public int updateInvention(Invention invention);
	
	/**
     * 删除发明专利
     * 
     * @param inventionId 发明专利ID
     * @return 结果
     */
	public int deleteInventionById(Integer inventionId);
	
	/**
     * 批量删除发明专利
     * 
     * @param inventionIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteInventionByIds(String[] inventionIds);
	
}