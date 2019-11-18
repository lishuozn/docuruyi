package com.ruoyi.project.system.softwareCopyright.domain;

import com.ruoyi.project.system.dept.domain.Dept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 软件著作权表 sys_software_copyright
 * 
 * @author daivd
 * @date 2019-11-08
 */
public class SoftwareCopyright extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 软件著作权Id */
	private Integer copyrightId;
	/** 软件著作权名称 */
	private String copyrightName;
	/** 登记号 */
	private String registrationId;
	/** 第一著作权人 */
	private String firstCopyrightOwner;
	/** 第一著作权人专业 */
	private Integer firstCopyrightOwnerMajorId;
	/** 其他著作权人 */
	private String otherCopyrightOwner;
	/** 并发完成时间 */
	private Date concurrentCompletionDate;
	/** 登记时间 */
	private Date registrationDate;
	/** 附件 */
	private String attachFile;
	/** 专业 */
	private Dept major;

	public Dept getMajor() {
		return major;
	}

	public void setMajor(Dept major) {
		this.major = major;
	}

	public void setCopyrightId(Integer copyrightId)
	{
		this.copyrightId = copyrightId;
	}

	public Integer getCopyrightId() 
	{
		return copyrightId;
	}
	public void setCopyrightName(String copyrightName) 
	{
		this.copyrightName = copyrightName;
	}

	public String getCopyrightName() 
	{
		return copyrightName;
	}
	public void setRegistrationId(String registrationId) 
	{
		this.registrationId = registrationId;
	}

	public String getRegistrationId() 
	{
		return registrationId;
	}
	public void setFirstCopyrightOwner(String firstCopyrightOwner) 
	{
		this.firstCopyrightOwner = firstCopyrightOwner;
	}

	public String getFirstCopyrightOwner() 
	{
		return firstCopyrightOwner;
	}
	public void setFirstCopyrightOwnerMajorId(Integer firstCopyrightOwnerMajorId) 
	{
		this.firstCopyrightOwnerMajorId = firstCopyrightOwnerMajorId;
	}

	public Integer getFirstCopyrightOwnerMajorId() 
	{
		return firstCopyrightOwnerMajorId;
	}
	public void setOtherCopyrightOwner(String otherCopyrightOwner) 
	{
		this.otherCopyrightOwner = otherCopyrightOwner;
	}

	public String getOtherCopyrightOwner() 
	{
		return otherCopyrightOwner;
	}
	public void setConcurrentCompletionDate(Date concurrentCompletionDate) 
	{
		this.concurrentCompletionDate = concurrentCompletionDate;
	}

	public Date getConcurrentCompletionDate() 
	{
		return concurrentCompletionDate;
	}
	public void setRegistrationDate(Date registrationDate) 
	{
		this.registrationDate = registrationDate;
	}

	public Date getRegistrationDate() 
	{
		return registrationDate;
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
            .append("copyrightId", getCopyrightId())
            .append("copyrightName", getCopyrightName())
            .append("registrationId", getRegistrationId())
            .append("firstCopyrightOwner", getFirstCopyrightOwner())
            .append("firstCopyrightOwnerMajorId", getFirstCopyrightOwnerMajorId())
            .append("otherCopyrightOwner", getOtherCopyrightOwner())
            .append("concurrentCompletionDate", getConcurrentCompletionDate())
            .append("registrationDate", getRegistrationDate())
            .append("attachFile", getAttachFile())
            .toString();
    }
}
