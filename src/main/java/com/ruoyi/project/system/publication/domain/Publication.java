package com.ruoyi.project.system.publication.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class Publication extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 教材Id */
	private Integer pbId;
	/** 类别 */
	private String pbKind;
	/** 题目 */
	private String pbTitle;
	/** 第一作者编号 */
	private Integer author1Id;
	/** 第一作者姓名 */
	private String author1Name;
	/** 第一作者所在专业 */
	private Integer author1MajorId;
	/** 第二作者编号 */
	private Integer author2Id;
	/** 第二作者姓名 */
	private String author2Name;
	/** 第二作者所在专业 */
	private Integer author2MajorId;
	/** 其他作者名字 */
	private String authorNameOther;
	/** 期刊名字 */
	private String publisherName;
	/** 刊号 */
	private String publishNumber;
	/** 出版社级别 */
	private String publisherLevel;
	/** 出版时间 */
	private Date publishDate;
	/** ISSN编号 */
	private String issnNumber;
	/** 附件 */
	private String attachFile;
	/** 备注 */
	private String notes;

	public void setPbId(Integer pbId) 
	{
		this.pbId = pbId;
	}

	public Integer getPbId() 
	{
		return pbId;
	}
	public void setPbKind(String pbKind) 
	{
		this.pbKind = pbKind;
	}

	public String getPbKind() 
	{
		return pbKind;
	}
	public void setPbTitle(String pbTitle) 
	{
		this.pbTitle = pbTitle;
	}

	public String getPbTitle() 
	{
		return pbTitle;
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
	public void setAuthor2Id(Integer author2Id) 
	{
		this.author2Id = author2Id;
	}

	public Integer getAuthor2Id() 
	{
		return author2Id;
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
	public void setPublisherName(String publisherName) 
	{
		this.publisherName = publisherName;
	}

	public String getPublisherName() 
	{
		return publisherName;
	}
	public void setPublishNumber(String publishNumber) 
	{
		this.publishNumber = publishNumber;
	}

	public String getPublishNumber() 
	{
		return publishNumber;
	}
	public void setPublisherLevel(String publisherLevel) 
	{
		this.publisherLevel = publisherLevel;
	}

	public String getPublisherLevel() 
	{
		return publisherLevel;
	}
	public void setPublishDate(Date publishDate) 
	{
		this.publishDate = publishDate;
	}

	public Date getPublishDate() 
	{
		return publishDate;
	}
	public void setIssnNumber(String issnNumber) 
	{
		this.issnNumber = issnNumber;
	}

	public String getIssnNumber() 
	{
		return issnNumber;
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
            .append("pbId", getPbId())
            .append("pbKind", getPbKind())
            .append("pbTitle", getPbTitle())
            .append("author1Id", getAuthor1Id())
            .append("author1Name", getAuthor1Name())
            .append("author1MajorId", getAuthor1MajorId())
            .append("author2Id", getAuthor2Id())
            .append("author2Name", getAuthor2Name())
            .append("author2MajorId", getAuthor2MajorId())
            .append("authorNameOther", getAuthorNameOther())
            .append("publisherName", getPublisherName())
            .append("publishNumber", getPublishNumber())
            .append("publisherLevel", getPublisherLevel())
            .append("publishDate", getPublishDate())
            .append("issnNumber", getIssnNumber())
            .append("attachFile", getAttachFile())
            .append("notes", getNotes())
            .toString();
    }
}
