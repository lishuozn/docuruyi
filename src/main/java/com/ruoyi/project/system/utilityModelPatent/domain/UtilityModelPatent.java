package com.ruoyi.project.system.utilityModelPatent.domain;

import com.ruoyi.project.system.dept.domain.Dept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 实用新型专利表 sys_utility_model_patent
 * 
 * @author daivd
 * @date 2019-11-09
 */
public class UtilityModelPatent extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 专利Id */
	private Integer patentId;
	/** 专利名称 */
	private String patentName;
	/** 专利号 */
	private String patentNumber;
	/** 第一发明人 */
	private String inventor1Name;
	/** 第一发明人专业 */
	private Integer inventor1MajorId;
	/** 其它发明人 */
	private String otherInventor;
	/** 专利权人 */
	private String patentee;
	/** 授权公告日 */
	private Date accreditNoticeDate;
	/** 附件 */
	private String attachFile;
	/** 主持人专业,树的可视化用的**/
    private Dept utilityModelPatentMajor;

    public Dept getUtilityModelPatentMajor() {
        return utilityModelPatentMajor;
    }

    public void setUtilityModelPatentMajor(Dept utilityModelPatentMajor) {
        this.utilityModelPatentMajor = utilityModelPatentMajor;
    }

	public void setPatentId(Integer patentId) 
	{
		this.patentId = patentId;
	}

	public Integer getPatentId() 
	{
		return patentId;
	}
	public void setPatentName(String patentName) 
	{
		this.patentName = patentName;
	}

	public String getPatentName() 
	{
		return patentName;
	}
	public void setPatentNumber(String patentNumber) 
	{
		this.patentNumber = patentNumber;
	}

	public String getPatentNumber() 
	{
		return patentNumber;
	}
	public void setInventor1Name(String inventor1Name) 
	{
		this.inventor1Name = inventor1Name;
	}

	public String getInventor1Name() 
	{
		return inventor1Name;
	}
	public void setInventor1MajorId(Integer inventor1MajorId) 
	{
		this.inventor1MajorId = inventor1MajorId;
	}

	public Integer getInventor1MajorId() 
	{
		return inventor1MajorId;
	}
	public void setOtherInventor(String otherInventor) 
	{
		this.otherInventor = otherInventor;
	}

	public String getOtherInventor() 
	{
		return otherInventor;
	}
	public void setPatentee(String patentee) 
	{
		this.patentee = patentee;
	}

	public String getPatentee() 
	{
		return patentee;
	}
	public void setAccreditNoticeDate(Date accreditNoticeDate) 
	{
		this.accreditNoticeDate = accreditNoticeDate;
	}

	public Date getAccreditNoticeDate() 
	{
		return accreditNoticeDate;
	}
	public void setAttachFile(String attachFile) 
	{
		this.attachFile = attachFile;
	}

	public String getAttachFile() 
	{
		return attachFile;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("patentId", getPatentId())
            .append("patentName", getPatentName())
            .append("patentNumber", getPatentNumber())
            .append("inventor1Name", getInventor1Name())
            .append("inventor1MajorId", getInventor1MajorId())
            .append("otherInventor", getOtherInventor())
            .append("patentee", getPatentee())
            .append("accreditNoticeDate", getAccreditNoticeDate())
            .append("attachFile", getAttachFile())
            .toString();
    }
}
