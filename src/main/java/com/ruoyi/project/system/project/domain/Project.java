package com.ruoyi.project.system.project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 平台等立项文件表 sys_project
 * 
 * @author daivd
 * @date 2019-11-10
 */
public class Project extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 立项编号 */
	private Integer projectId;
	/** 立项名称 */
	private String projectName;
	/** 立项级别 */
	private Integer projectLevel;
	/** 立项时间 */
	private Date startDate;
	/** 资助金额 */
	private Float projectFunding;

	public void setProjectId(Integer projectId) 
	{
		this.projectId = projectId;
	}

	public Integer getProjectId() 
	{
		return projectId;
	}
	public void setProjectName(String projectName) 
	{
		this.projectName = projectName;
	}

	public String getProjectName() 
	{
		return projectName;
	}
	public void setProjectLevel(Integer projectLevel) 
	{
		this.projectLevel = projectLevel;
	}

	public Integer getProjectLevel() 
	{
		return projectLevel;
	}
	public void setStartDate(Date startDate) 
	{
		this.startDate = startDate;
	}

	public Date getStartDate() 
	{
		return startDate;
	}
	public void setProjectFunding(Float projectFunding) 
	{
		this.projectFunding = projectFunding;
	}

	public Float getProjectFunding() 
	{
		return projectFunding;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectId", getProjectId())
            .append("projectName", getProjectName())
            .append("projectLevel", getProjectLevel())
            .append("startDate", getStartDate())
            .append("projectFunding", getProjectFunding())
            .toString();
    }
}
