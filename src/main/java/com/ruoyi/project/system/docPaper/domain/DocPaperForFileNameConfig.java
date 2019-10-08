package com.ruoyi.project.system.docPaper.domain;

import java.util.Date;

public class DocPaperForFileNameConfig {
    /** 论文Id */
    private Integer paperId;
    /** 论文类别 */
    private String paperKind;
    /** 论文题目 */
    private String paperTitle;
    /** 作者id-备用 */
    private Integer author1Id;
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
    /** 第一单位 */
    private String firstUnit;
    /** 第二单位 */
    private String secondUnit;
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
    private String levelIdCcec;
    /** 附件 */
    private String attachFile;
    /** 备注 */
    private String notes;

    @Override
    public String toString() {
        return "DocPaperForFileNameConfig{" +
                "paperId=" + paperId +
                ", paperKind='" + paperKind + '\'' +
                ", paperTitle='" + paperTitle + '\'' +
                ", author1Id=" + author1Id +
                ", author1Name='" + author1Name + '\'' +
                ", author1MajorId='" + author1MajorId + '\'' +
                ", author2Name='" + author2Name + '\'' +
                ", author2MajorId='" + author2MajorId + '\'' +
                ", authorNameOther='" + authorNameOther + '\'' +
                ", firstUnit='" + firstUnit + '\'' +
                ", secondUnit='" + secondUnit + '\'' +
                ", journalName='" + journalName + '\'' +
                ", journalNumber='" + journalNumber + '\'' +
                ", journalSearchNumber='" + journalSearchNumber + '\'' +
                ", publishDate=" + publishDate +
                ", reelNumber='" + reelNumber + '\'' +
                ", pageStart=" + pageStart +
                ", pageEnd=" + pageEnd +
                ", funds='" + funds + '\'' +
                ", levelIdCcec='" + levelIdCcec + '\'' +
                ", attachFile='" + attachFile + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperKind() {
        return paperKind;
    }

    public void setPaperKind(String paperKind) {
        this.paperKind = paperKind;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
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

    public String getFirstUnit() {
        return firstUnit;
    }

    public void setFirstUnit(String firstUnit) {
        this.firstUnit = firstUnit;
    }

    public String getSecondUnit() {
        return secondUnit;
    }

    public void setSecondUnit(String secondUnit) {
        this.secondUnit = secondUnit;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public String getJournalNumber() {
        return journalNumber;
    }

    public void setJournalNumber(String journalNumber) {
        this.journalNumber = journalNumber;
    }

    public String getJournalSearchNumber() {
        return journalSearchNumber;
    }

    public void setJournalSearchNumber(String journalSearchNumber) {
        this.journalSearchNumber = journalSearchNumber;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getReelNumber() {
        return reelNumber;
    }

    public void setReelNumber(String reelNumber) {
        this.reelNumber = reelNumber;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(Integer pageEnd) {
        this.pageEnd = pageEnd;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    public String getLevelIdCcec() {
        return levelIdCcec;
    }

    public void setLevelIdCcec(String levelIdCcec) {
        this.levelIdCcec = levelIdCcec;
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
}
