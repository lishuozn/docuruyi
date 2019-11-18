package com.ruoyi.project.system.softwareCopyright.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.system.dept.domain.Dept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 软件著作权表 sys_software_copyright
 * 
 * @author daivd
 * @date 2019-11-08
 */
public class SoftwareCopyrightForFileNameConfig extends BaseEntity
{
	
	/** 软件著作权Id */
	private String copyrightId;
	/** 软件著作权名称 */
	private String copyrightName;
	/** 登记号 */
	private String registrationId;
	/** 第一著作权人 */
	private String firstCopyrightOwner;
	/** 第一著作权人专业 */
	private String firstCopyrightOwnerMajorId;
	/** 其他著作权人 */
	private String otherCopyrightOwner;
	/** 并发完成时间 */
	private String concurrentCompletionDate;
	/** 登记时间 */
	private String registrationDate;
	/** 附件 */
	private String attachFile;

	public String getCopyrightId() {
		return copyrightId;
	}

	public void setCopyrightId(String copyrightId) {
		this.copyrightId = copyrightId;
	}

	public String getCopyrightName() {
		return copyrightName;
	}

	public void setCopyrightName(String copyrightName) {
		this.copyrightName = copyrightName;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getFirstCopyrightOwner() {
		return firstCopyrightOwner;
	}

	public void setFirstCopyrightOwner(String firstCopyrightOwner) {
		this.firstCopyrightOwner = firstCopyrightOwner;
	}

	public String getFirstCopyrightOwnerMajorId() {
		return firstCopyrightOwnerMajorId;
	}

	public void setFirstCopyrightOwnerMajorId(String firstCopyrightOwnerMajorId) {
		this.firstCopyrightOwnerMajorId = firstCopyrightOwnerMajorId;
	}

	public String getOtherCopyrightOwner() {
		return otherCopyrightOwner;
	}

	public void setOtherCopyrightOwner(String otherCopyrightOwner) {
		this.otherCopyrightOwner = otherCopyrightOwner;
	}

	public String getConcurrentCompletionDate() {
		return concurrentCompletionDate;
	}

	public void setConcurrentCompletionDate(String concurrentCompletionDate) {
		this.concurrentCompletionDate = concurrentCompletionDate;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
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
