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
public class DocMonographForFileNameConfig
{
	
	/** 专著Id */
	private String monographId;
	/** 专著名称 */
	private String monographName;
	/** 作者id-备用 */
	private String author1Id;
	/** 一作名字 */
	private String author1Name;
	/** 一作专业 */
	private String author1MajorId;
	/** 二作名字 */
	private String author2Name;
	/** 二作专业 */
	private String author2MajorId;
	/** 其他作者名字 */
	private String authorNameOther;
	/** 出版社名称 */
	private String pressName;
	/** 出版时间 */
	private String publishDate;
	/** 出版社级别 */
	private String pressLevel;
	/** 附件 */
	private String attachFile;
	/** 备注 */
	private String notes;

	public String getMonographId() {
		return monographId;
	}

	public void setMonographId(String monographId) {
		this.monographId = monographId;
	}

	public String getMonographName() {
		return monographName;
	}

	public void setMonographName(String monographName) {
		this.monographName = monographName;
	}

	public String getAuthor1Id() {
		return author1Id;
	}

	public void setAuthor1Id(String author1Id) {
		this.author1Id = author1Id;
	}

	public String getAuthor1Name() {
		return author1Name;
	}

	public void setAuthor1Name(String author1Name) {
		this.author1Name = author1Name;
	}

	public String getAuthor1MajorId() {
		return author1MajorId;
	}

	public void setAuthor1MajorId(String author1MajorId) {
		this.author1MajorId = author1MajorId;
	}

	public String getAuthor2Name() {
		return author2Name;
	}

	public void setAuthor2Name(String author2Name) {
		this.author2Name = author2Name;
	}

	public String getAuthor2MajorId() {
		return author2MajorId;
	}

	public void setAuthor2MajorId(String author2MajorId) {
		this.author2MajorId = author2MajorId;
	}

	public String getAuthorNameOther() {
		return authorNameOther;
	}

	public void setAuthorNameOther(String authorNameOther) {
		this.authorNameOther = authorNameOther;
	}

	public String getPressName() {
		return pressName;
	}

	public void setPressName(String pressName) {
		this.pressName = pressName;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getPressLevel() {
		return pressLevel;
	}

	public void setPressLevel(String pressLevel) {
		this.pressLevel = pressLevel;
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
