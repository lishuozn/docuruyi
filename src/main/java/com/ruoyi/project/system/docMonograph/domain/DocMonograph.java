package com.ruoyi.project.system.docMonograph.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.system.dept.domain.Dept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 专著表 sys_doc_monograph
 * 
 * @author daivd
 * @date 2019-08-01
 */
public class DocMonograph extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 专著Id */
	private Integer monographId;
	/** 专著名称 */
	private String monographName;
	/** 作者id-备用 */
	private Integer author1Id;
	/** 一作名字 */
	private String author1Name;
	/** 一作专业 */
	private Integer author1MajorId;
	/** 二作名字 */
	private String author2Name;
	/** 二作专业 */
	private Integer author2MajorId;
	/** 其他作者名字 */
	private String authorNameOther;
	/** 出版社名称 */
	private String pressName;
	/** 出版时间 */
	private Date publishDate;
	/** 出版社级别 */
	private String pressLevel;
	/** 附件 */
	private String attachFile;
	/** 备注 */
	private String notes;
	private Dept major1;
	private Dept major2;

	public Dept getMajor1() {
		return major1;
	}

	public void setMajor1(Dept major1) {
		this.major1 = major1;
	}

	public Dept getMajor2() {
		return major2;
	}

	public void setMajor2(Dept major2) {
		this.major2 = major2;
	}

	public void setMonographId(Integer monographId)
	{
		this.monographId = monographId;
	}


	public Integer getMonographId()
	{
		return monographId;
	}
	public void setMonographName(String monographName) 
	{
		this.monographName = monographName;
	}

	public String getMonographName() 
	{
		return monographName;
	}
	public void setAuthor1Id(Integer author1Id) 
	{
		this.author1Id = author1Id;
	}

	public Integer getAuthor1Id() 
	{
		return author1Id;
	}
	public void setAuthor1Name(String author1Name) 
	{
		this.author1Name = author1Name;
	}

	public String getAuthor1Name() 
	{
		return author1Name;
	}
	public void setAuthor1MajorId(Integer author1MajorId) 
	{
		this.author1MajorId = author1MajorId;
	}

	public Integer getAuthor1MajorId() 
	{
		return author1MajorId;
	}
	public void setAuthor2Name(String author2Name) 
	{
		this.author2Name = author2Name;
	}

	public String getAuthor2Name() 
	{
		return author2Name;
	}
	public void setAuthor2MajorId(Integer author2MajorId) 
	{
		this.author2MajorId = author2MajorId;
	}

	public Integer getAuthor2MajorId() 
	{
		return author2MajorId;
	}
	public void setAuthorNameOther(String authorNameOther) 
	{
		this.authorNameOther = authorNameOther;
	}

	public String getAuthorNameOther() 
	{
		return authorNameOther;
	}
	public void setPressName(String pressName) 
	{
		this.pressName = pressName;
	}

	public String getPressName() 
	{
		return pressName;
	}
	public void setPublishDate(Date publishDate) 
	{
		this.publishDate = publishDate;
	}

	public Date getPublishDate() 
	{
		return publishDate;
	}
	public void setPressLevel(String pressLevel) 
	{
		this.pressLevel = pressLevel;
	}

	public String getPressLevel() 
	{
		return pressLevel;
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

    @Override
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("monographId", getMonographId())
            .append("monographName", getMonographName())
            .append("author1Id", getAuthor1Id())
            .append("author1Name", getAuthor1Name())
            .append("author1MajorId", getAuthor1MajorId())
            .append("author2Name", getAuthor2Name())
            .append("author2MajorId", getAuthor2MajorId())
            .append("authorNameOther", getAuthorNameOther())
            .append("pressName", getPressName())
            .append("publishDate", getPublishDate())
            .append("pressLevel", getPressLevel())
            .append("attachFile", getAttachFile())
            .append("notes", getNotes())
            .toString();
    }
}
