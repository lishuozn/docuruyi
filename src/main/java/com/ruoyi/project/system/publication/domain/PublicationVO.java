package com.ruoyi.project.system.publication.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.system.dept.domain.Dept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PublicationVO extends BaseEntity
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
	private Dept author1Major;
	/** 第二作者编号 */
	private Integer author2Id;
	/** 第二作者姓名 */
	private String author2Name;
	/** 第二作者所在专业 */
	private Dept author2Major;
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

	public PublicationVO( ) {
	}

	public PublicationVO(Integer pbId, String pbKind, String pbTitle, Integer author1Id, String author1Name, Dept author1Major, Integer author2Id, String author2Name, Dept author2Major, String authorNameOther, String publisherName, String publishNumber, String publisherLevel, Date publishDate, String issnNumber, String attachFile, String notes) {
		this.pbId = pbId;
		this.pbKind = pbKind;
		this.pbTitle = pbTitle;
		this.author1Id = author1Id;
		this.author1Name = author1Name;
		this.author1Major = author1Major;
		this.author2Id = author2Id;
		this.author2Name = author2Name;
		this.author2Major = author2Major;
		this.authorNameOther = authorNameOther;
		this.publisherName = publisherName;
		this.publishNumber = publishNumber;
		this.publisherLevel = publisherLevel;
		this.publishDate = publishDate;
		this.issnNumber = issnNumber;
		this.attachFile = attachFile;
		this.notes = notes;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getPbId() {
		return pbId;
	}

	public void setPbId(Integer pbId) {
		this.pbId = pbId;
	}

	public String getPbKind() {
		return pbKind;
	}

	public void setPbKind(String pbKind) {
		this.pbKind = pbKind;
	}

	public String getPbTitle() {
		return pbTitle;
	}

	public void setPbTitle(String pbTitle) {
		this.pbTitle = pbTitle;
	}

	public Integer getAuthor1Id() {
		return author1Id;
	}

	public void setAuthor1Id(Integer author1Id) {
		this.author1Id = author1Id;
	}

	public String getAuthor1Name() {
		return author1Name;
	}

	public void setAuthor1Name(String author1Name) {
		this.author1Name = author1Name;
	}

	public Dept getAuthor1Major() {
		return author1Major;
	}

	public void setAuthor1Major(Dept author1Major) {
		this.author1Major = author1Major;
	}

	public Integer getAuthor2Id() {
		return author2Id;
	}

	public void setAuthor2Id(Integer author2Id) {
		this.author2Id = author2Id;
	}

	public String getAuthor2Name() {
		return author2Name;
	}

	public void setAuthor2Name(String author2Name) {
		this.author2Name = author2Name;
	}

	public Dept getAuthor2Major() {
		return author2Major;
	}

	public void setAuthor2Major(Dept author2Major) {
		this.author2Major = author2Major;
	}

	public String getAuthorNameOther() {
		return authorNameOther;
	}

	public void setAuthorNameOther(String authorNameOther) {
		this.authorNameOther = authorNameOther;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublishNumber() {
		return publishNumber;
	}

	public void setPublishNumber(String publishNumber) {
		this.publishNumber = publishNumber;
	}

	public String getPublisherLevel() {
		return publisherLevel;
	}

	public void setPublisherLevel(String publisherLevel) {
		this.publisherLevel = publisherLevel;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getIssnNumber() {
		return issnNumber;
	}

	public void setIssnNumber(String issnNumber) {
		this.issnNumber = issnNumber;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "PublicationVO{" +
				"pbId=" + pbId +
				", pbKind='" + pbKind + '\'' +
				", pbTitle='" + pbTitle + '\'' +
				", author1Id=" + author1Id +
				", author1Name='" + author1Name + '\'' +
				", author1Major=" + author1Major +
				", author2Id=" + author2Id +
				", author2Name='" + author2Name + '\'' +
				", author2Major=" + author2Major+
				", authorNameOther='" + authorNameOther + '\'' +
				", publisherName='" + publisherName + '\'' +
				", publishNumber='" + publishNumber + '\'' +
				", publisherLevel='" + publisherLevel + '\'' +
				", publishDate=" + publishDate +
				", issnNumber='" + issnNumber + '\'' +
				", attachFile='" + attachFile + '\'' +
				", notes='" + notes + '\'' +
				'}';
	}
}
