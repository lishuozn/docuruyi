package com.ruoyi.project.system.teachingSubject.domain;

import com.ruoyi.project.system.dept.domain.Dept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class TeachingSubjectForFileNameConfig {

    /** 教改课题Id */
    private Integer subjectId;
    /** 课题名称 */
    private String subjectName;
    /** 课题级别 */
    private String subjectLevel;
    /** 主持人 */
    private String moderator;
    /** 主持人专业 */
    private String modMajorId;
    /** 参与人 */
    private String modParticipant;
    /** 第一单位 */
    private String firstUnit;
    /** 立项时间 */
    private String projectDate;
    /** 资助金额(万元) */
    private String grants;
    /** 到账金额(万元) */
    private String arrivalAmount;
    /** 结题时间 */
    private Date concludingDate;
    /** 项目来源 */
    private String projectSource;
    /** 是否结题 */
    private String isFinished;
    /** 是否按期结题 */
    private String isFinishedOnTime;
    /** 附件 */
    private String attachFile;
    /** 备注 */
    private String notes;

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectLevel() {
        return subjectLevel;
    }

    public void setSubjectLevel(String subjectLevel) {
        this.subjectLevel = subjectLevel;
    }

    public String getModerator() {
        return moderator;
    }

    public void setModerator(String moderator) {
        this.moderator = moderator;
    }

    public String getModMajorId() {
        return modMajorId;
    }

    public void setModMajorId(String modMajorId) {
        this.modMajorId = modMajorId;
    }

    public String getModParticipant() {
        return modParticipant;
    }

    public void setModParticipant(String modParticipant) {
        this.modParticipant = modParticipant;
    }

    public String getFirstUnit() {
        return firstUnit;
    }

    public void setFirstUnit(String firstUnit) {
        this.firstUnit = firstUnit;
    }

    public String getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(String projectDate) {
        this.projectDate = projectDate;
    }

    public String getGrants() {
        return grants;
    }

    public void setGrants(String grants) {
        this.grants = grants;
    }

    public String getArrivalAmount() {
        return arrivalAmount;
    }

    public void setArrivalAmount(String arrivalAmount) {
        this.arrivalAmount = arrivalAmount;
    }

    public Date getConcludingDate() {
        return concludingDate;
    }

    public void setConcludingDate(Date concludingDate) {
        this.concludingDate = concludingDate;
    }

    public String getProjectSource() {
        return projectSource;
    }

    public void setProjectSource(String projectSource) {
        this.projectSource = projectSource;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished;
    }

    public String getIsFinishedOnTime() {
        return isFinishedOnTime;
    }

    public void setIsFinishedOnTime(String isFinishedOnTime) {
        this.isFinishedOnTime = isFinishedOnTime;
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
                .append("subjectId", getSubjectId())
                .append("subjectName", getSubjectName())
                .append("subjectLevel", getSubjectLevel())
                .append("moderator", getModerator())
                .append("modMajorId", getModMajorId())
                .append("modParticipant", getModParticipant())
                .append("firstUnit", getFirstUnit())
                .append("projectDate", getProjectDate())
                .append("grants", getGrants())
                .append("arrivalAmount", getArrivalAmount())
                .append("concludingDate", getConcludingDate())
                .append("projectSource", getProjectSource())
                .append("isFinished", getIsFinished())
                .append("isFinishedOnTime", getIsFinishedOnTime())
                .append("attachFile", getAttachFile())
                .append("notes", getNotes())
                .toString();
    }
}
