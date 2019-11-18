package com.ruoyi.project.system.invention.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 发明专利表 sys_invention
 * 
 * @author daivd
 * @date 2019-11-16
 */
public class Invention extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 发明id */
	private Integer inventionId;
	/** 发明名称 */
	private String inventionName;
	/** 发明状态 */
	private Integer inventionState;
	/** 专利号 */
	private String patentNumber;
	/** 第一发明人 */
	private String firstInventor;
	/** 第一发明人专业 */
	private Integer firstInventorMajor;
	/** 其他发明人 */
	private String otherInventor;
	/** 专利权所有人 */
	private String patentRightBelongsTo;
	/** 申请时间 */
	private Date appliedDate;
	/** 实审时间 */
	private Date examDate;
	/** 授权公告日 */
	private Date announcementDate;
	/** 附件 */
	private String attachFile;
	/** 备注 */
	private String note;
	/** 创建者 */
	private String createdBy;
	/** 创建时间 */
	private Date createdDate;
	/** 最近修改者 */
	private String modifiedBy;
	/** 最近修改时间 */
	private Date modifiedDate;

	public void setInventionId(Integer inventionId) 
	{
		this.inventionId = inventionId;
	}

	public Integer getInventionId() 
	{
		return inventionId;
	}
	public void setInventionName(String inventionName) 
	{
		this.inventionName = inventionName;
	}

	public String getInventionName() 
	{
		return inventionName;
	}
	public void setInventionState(Integer inventionState) 
	{
		this.inventionState = inventionState;
	}

	public Integer getInventionState() 
	{
		return inventionState;
	}
	public void setPatentNumber(String patentNumber) 
	{
		this.patentNumber = patentNumber;
	}

	public String getPatentNumber() 
	{
		return patentNumber;
	}
	public void setFirstInventor(String firstInventor) 
	{
		this.firstInventor = firstInventor;
	}

	public String getFirstInventor() 
	{
		return firstInventor;
	}
	public void setFirstInventorMajor(Integer firstInventorMajor) 
	{
		this.firstInventorMajor = firstInventorMajor;
	}

	public Integer getFirstInventorMajor() 
	{
		return firstInventorMajor;
	}
	public void setOtherInventor(String otherInventor) 
	{
		this.otherInventor = otherInventor;
	}

	public String getOtherInventor() 
	{
		return otherInventor;
	}
	public void setPatentRightBelongsTo(String patentRightBelongsTo) 
	{
		this.patentRightBelongsTo = patentRightBelongsTo;
	}

	public String getPatentRightBelongsTo() 
	{
		return patentRightBelongsTo;
	}
	public void setAppliedDate(Date appliedDate) 
	{
		this.appliedDate = appliedDate;
	}

	public Date getAppliedDate() 
	{
		return appliedDate;
	}
	public void setExamDate(Date examDate) 
	{
		this.examDate = examDate;
	}

	public Date getExamDate() 
	{
		return examDate;
	}
	public void setAnnouncementDate(Date announcementDate) 
	{
		this.announcementDate = announcementDate;
	}

	public Date getAnnouncementDate() 
	{
		return announcementDate;
	}
	public void setAttachFile(String attachFile) 
	{
		this.attachFile = attachFile;
	}

	public String getAttachFile() 
	{
		return attachFile;
	}
	public void setNote(String note) 
	{
		this.note = note;
	}

	public String getNote() 
	{
		return note;
	}
	public void setCreatedBy(String createdBy) 
	{
		this.createdBy = createdBy;
	}

	public String getCreatedBy() 
	{
		return createdBy;
	}
	public void setCreatedDate(Date createdDate) 
	{
		this.createdDate = createdDate;
	}

	public Date getCreatedDate() 
	{
		return createdDate;
	}
	public void setModifiedBy(String modifiedBy) 
	{
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedBy() 
	{
		return modifiedBy;
	}
	public void setModifiedDate(Date modifiedDate) 
	{
		this.modifiedDate = modifiedDate;
	}

	public Date getModifiedDate() 
	{
		return modifiedDate;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("inventionId", getInventionId())
            .append("inventionName", getInventionName())
            .append("inventionState", getInventionState())
            .append("patentNumber", getPatentNumber())
            .append("firstInventor", getFirstInventor())
            .append("firstInventorMajor", getFirstInventorMajor())
            .append("otherInventor", getOtherInventor())
            .append("patentRightBelongsTo", getPatentRightBelongsTo())
            .append("appliedDate", getAppliedDate())
            .append("examDate", getExamDate())
            .append("announcementDate", getAnnouncementDate())
            .append("attachFile", getAttachFile())
            .append("note", getNote())
            .append("createdBy", getCreatedBy())
            .append("createdDate", getCreatedDate())
            .append("modifiedBy", getModifiedBy())
            .append("modifiedDate", getModifiedDate())
            .toString();
    }
}
