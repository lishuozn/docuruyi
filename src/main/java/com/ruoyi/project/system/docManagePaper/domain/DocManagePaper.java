package com.ruoyi.project.system.docManagePaper.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 作证-论文表 doc_manage_paper
 * 
 * @author daivd
 * @date 2019-07-08
 */
public class DocManagePaper extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 论文Id */
	private Integer paperId;
	/** 论文类别 */
	private Integer paperKind;
	/** 论文题目 */
	private String paperTitle;
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
	/** 期刊名字 */
	private String journalName;
	/** 刊号 */
	private String journalNumber;
	/** 期刊检索号 */
	private String journalSearchNumber;
	/** 出版时间 */
	private Date publishDate;
	/** 卷号 */
	private String reelNumber;
	/** 起始页码 */
	private Integer pageStart;
	/** 终止页码 */
	private Integer pageEnd;
	/** 基金 */
	private String funds;
	/** 校内认定级别 */
	private Integer levelIdCcec;
	/** 附件 */
	private String attachFile;
	/** 备注 */
	private String notes;

	public void setPaperId(Integer paperId) 
	{
		this.paperId = paperId;
	}

	public Integer getPaperId() 
	{
		return paperId;
	}
	public void setPaperKind(Integer paperKind) 
	{
		this.paperKind = paperKind;
	}

	public Integer getPaperKind() 
	{
		return paperKind;
	}
	public void setPaperTitle(String paperTitle) 
	{
		this.paperTitle = paperTitle;
	}

	public String getPaperTitle() 
	{
		return paperTitle;
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
	public void setJournalName(String journalName) 
	{
		this.journalName = journalName;
	}

	public String getJournalName() 
	{
		return journalName;
	}
	public void setJournalNumber(String journalNumber) 
	{
		this.journalNumber = journalNumber;
	}

	public String getJournalNumber() 
	{
		return journalNumber;
	}
	public void setJournalSearchNumber(String journalSearchNumber) 
	{
		this.journalSearchNumber = journalSearchNumber;
	}

	public String getJournalSearchNumber() 
	{
		return journalSearchNumber;
	}
	public void setPublishDate(Date publishDate) 
	{
		this.publishDate = publishDate;
	}

	public Date getPublishDate() 
	{
		return publishDate;
	}
	public void setReelNumber(String reelNumber) 
	{
		this.reelNumber = reelNumber;
	}

	public String getReelNumber() 
	{
		return reelNumber;
	}
	public void setPageStart(Integer pageStart) 
	{
		this.pageStart = pageStart;
	}

	public Integer getPageStart() 
	{
		return pageStart;
	}
	public void setPageEnd(Integer pageEnd) 
	{
		this.pageEnd = pageEnd;
	}

	public Integer getPageEnd() 
	{
		return pageEnd;
	}
	public void setFunds(String funds) 
	{
		this.funds = funds;
	}

	public String getFunds() 
	{
		return funds;
	}
	public void setLevelIdCcec(Integer levelIdCcec) 
	{
		this.levelIdCcec = levelIdCcec;
	}

	public Integer getLevelIdCcec() 
	{
		return levelIdCcec;
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
            .append("paperId", getPaperId())
            .append("paperKind", getPaperKind())
            .append("paperTitle", getPaperTitle())
            .append("author1Id", getAuthor1Id())
            .append("author1Name", getAuthor1Name())
            .append("author1MajorId", getAuthor1MajorId())
            .append("author2Name", getAuthor2Name())
            .append("author2MajorId", getAuthor2MajorId())
            .append("authorNameOther", getAuthorNameOther())
            .append("journalName", getJournalName())
            .append("journalNumber", getJournalNumber())
            .append("journalSearchNumber", getJournalSearchNumber())
            .append("publishDate", getPublishDate())
            .append("reelNumber", getReelNumber())
            .append("pageStart", getPageStart())
            .append("pageEnd", getPageEnd())
            .append("funds", getFunds())
            .append("levelIdCcec", getLevelIdCcec())
            .append("attachFile", getAttachFile())
            .append("notes", getNotes())
            .toString();
    }
}
