package com.ruoyi.project.system.sciResSubject.domain;

import com.ruoyi.project.system.dept.domain.Dept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 科研课题表 sys_sci_res_subject
 * 
 * @author daivd
 * @date 2019-10-19
 */
public class SciResSubject extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 科研课题Id */
	private Integer subjectId;
	/** 课题名称 */
	private String subjectName;
	/** 课题级别 */
	private Integer subjectLevel;
	/** 主持人 */
	private String moderator;
	/** 主持人专业 */
	private Integer modMajorId;
	/** 主持人参与人 */
	private String modParticipant;
	/** 第一单位 */
	private String firstUnit;
	/** 合作单位 */
	private String cooperUnit;
	/** 立项时间 */
	private Date projectDate;
	/** 资助金额(万元) */
	private Float grants;
	/** 到账金额(万元) */
	private Float arrivalAmount;
	/** 结题时间 */
	private Date concludingDate;
	/** 项目来源 */
	private String projectSource;
	/** 是否结题 */
	private Integer isFinished;
	/** 是否按期结题 */
	private Integer isFinishedOnTime;
	/** 附件 */
	private String attachFile;
	/** 备注 */
	private String notes;
	/** 主持人专业,树的可视化用的**/
	/****/
	private Dept sciResSubjectMajor;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Dept getSciResSubjectMajor() {
        return sciResSubjectMajor;
    }

    public void setSciResSubjectMajor(Dept sciResSubjectMajor) {
        this.sciResSubjectMajor = sciResSubjectMajor;
    }

    public void setSubjectId(Integer subjectId)
	{
		this.subjectId = subjectId;
	}

	public Integer getSubjectId() 
	{
		return subjectId;
	}
	public void setSubjectName(String subjectName) 
	{
		this.subjectName = subjectName;
	}

	public String getSubjectName() 
	{
		return subjectName;
	}
	public void setSubjectLevel(Integer subjectLevel) 
	{
		this.subjectLevel = subjectLevel;
	}

	public Integer getSubjectLevel() 
	{
		return subjectLevel;
	}
	public void setModerator(String moderator) 
	{
		this.moderator = moderator;
	}

	public String getModerator() 
	{
		return moderator;
	}
	public void setModMajorId(Integer modMajorId) 
	{
		this.modMajorId = modMajorId;
	}

	public Integer getModMajorId() 
	{
		return modMajorId;
	}
	public void setModParticipant(String modParticipant) 
	{
		this.modParticipant = modParticipant;
	}

	public String getModParticipant() 
	{
		return modParticipant;
	}
	public void setFirstUnit(String firstUnit) 
	{
		this.firstUnit = firstUnit;
	}

	public String getFirstUnit() 
	{
		return firstUnit;
	}
	public void setCooperUnit(String cooperUnit) 
	{
		this.cooperUnit = cooperUnit;
	}

	public String getCooperUnit() 
	{
		return cooperUnit;
	}
	public void setProjectDate(Date projectDate) 
	{
		this.projectDate = projectDate;
	}

	public Date getProjectDate() 
	{
		return projectDate;
	}
	public void setGrants(Float grants) 
	{
		this.grants = grants;
	}

	public Float getGrants() 
	{
		return grants;
	}
	public void setArrivalAmount(Float arrivalAmount) 
	{
		this.arrivalAmount = arrivalAmount;
	}

	public Float getArrivalAmount() 
	{
		return arrivalAmount;
	}
	public void setConcludingDate(Date concludingDate) 
	{
		this.concludingDate = concludingDate;
	}

	public Date getConcludingDate() 
	{
		return concludingDate;
	}
	public void setProjectSource(String projectSource) 
	{
		this.projectSource = projectSource;
	}

	public String getProjectSource() 
	{
		return projectSource;
	}
	public void setIsFinished(Integer isFinished) 
	{
		this.isFinished = isFinished;
	}

	public Integer getIsFinished() 
	{
		return isFinished;
	}
	public void setIsFinishedOnTime(Integer isFinishedOnTime) 
	{
		this.isFinishedOnTime = isFinishedOnTime;
	}

	public Integer getIsFinishedOnTime() 
	{
		return isFinishedOnTime;
	}
	public void setAttachFile(String attachFile) 
	{
		this.attachFile = attachFile;
	}

	public String getAttachFile() 
	{
		return attachFile;
	}
	public void setNotes(String notes) 
	{
		this.notes = notes;
	}

	public String getNotes() 
	{
		return notes;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("subjectId", getSubjectId())
            .append("subjectName", getSubjectName())
            .append("subjectLevel", getSubjectLevel())
            .append("moderator", getModerator())
            .append("modMajorId", getModMajorId())
            .append("modParticipant", getModParticipant())
            .append("firstUnit", getFirstUnit())
            .append("cooperUnit", getCooperUnit())
            .append("projectDate", getProjectDate())
            .append("grants", getGrants())
            .append("arrivalAmount", getArrivalAmount())
            .append("concludingDate", getConcludingDate())
            .append("projectSource", getProjectSource())
            .append("isFinished", getIsFinished())
            .append("isFinishedOnTime", getIsFinishedOnTime())
            .append("attachFile", getAttachFile())
            .append("notes", getNotes())
            .toString();
    }
}
