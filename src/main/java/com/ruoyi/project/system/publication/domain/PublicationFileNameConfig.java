package com.ruoyi.project.system.publication.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class PublicationFileNameConfig
{
	/** 教材Id */
	private String pbId;
	/** 类别 */
	private String pbKind;
	/** 题目 */
	private String pbTitle;
	/** 第一作者编号 */
	private String author1Id;
	/** 第一作者姓名 */
	private String author1Name;
	/** 第一作者所在专业 */
	private String author1MajorId;
	/** 第二作者编号 */
	private String author2Id;
	/** 第二作者姓名 */
	private String author2Name;
	/** 第二作者所在专业 */
	private String author2MajorId;
	/** 其他作者名字 */
	private String authorNameOther;
	/** 期刊名字 */
	private String publisherName;
	/** 刊号 */
	private String publishNumber;
	/** 出版社级别 */
	private String publisherLevel;
	/** 出版时间 */
	private String publishDate;
	/** ISSN编号 */
	private String issnNumber;
	/** 附件 */
	private String attachFile;
	/** 备注 */
	private String notes;

	public String getPbId() {
		return pbId;
	}

	public String getPbKind() {
		return pbKind;
	}

	public String getPbTitle() {
		return pbTitle;
	}

	public String getAuthor1Id() {
		return author1Id;
	}

	public String getAuthor1Name() {
		return author1Name;
	}

	public String getAuthor1MajorId() {
		return author1MajorId;
	}

	public String getAuthor2Id() {
		return author2Id;
	}

	public String getAuthor2Name() {
		return author2Name;
	}

	public String getAuthor2MajorId() {
		return author2MajorId;
	}

	public String getAuthorNameOther() {
		return authorNameOther;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public String getPublishNumber() {
		return publishNumber;
	}

	public String getPublisherLevel() {
		return publisherLevel;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public String getIssnNumber() {
		return issnNumber;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public String getNotes() {
		return notes;
	}

	public void setPbId(String pbId) {
		this.pbId = pbId;
	}

	public void setPbKind(String pbKind) {
		this.pbKind = pbKind;
	}

	public void setPbTitle(String pbTitle) {
		this.pbTitle = pbTitle;
	}

	public void setAuthor1Id(String author1Id) {
		this.author1Id = author1Id;
	}

	public void setAuthor1Name(String author1Name) {
		this.author1Name = author1Name;
	}

	public void setAuthor1MajorId(String author1MajorId) {
		this.author1MajorId = author1MajorId;
	}

	public void setAuthor2Id(String author2Id) {
		this.author2Id = author2Id;
	}

	public void setAuthor2Name(String author2Name) {
		this.author2Name = author2Name;
	}

	public void setAuthor2MajorId(String author2MajorId) {
		this.author2MajorId = author2MajorId;
	}

	public void setAuthorNameOther(String authorNameOther) {
		this.authorNameOther = authorNameOther;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public void setPublishNumber(String publishNumber) {
		this.publishNumber = publishNumber;
	}

	public void setPublisherLevel(String publisherLevel) {
		this.publisherLevel = publisherLevel;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public void setIssnNumber(String issnNumber) {
		this.issnNumber = issnNumber;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
