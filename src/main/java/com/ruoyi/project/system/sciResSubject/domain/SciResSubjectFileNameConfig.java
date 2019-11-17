package com.ruoyi.project.system.sciResSubject.domain;


public class SciResSubjectFileNameConfig {
    /** 科研课题Id */
    private Integer subjectId;
    /** 课题名称 */
    private String subjectName;
    /** 课题级别 */
    private String subjectLevel;
    /** 主持人 */
    private String moderator;
    /** 主持人专业 */
    private String modMajorId;
    /** 主持人参与人 */
    private String modParticipant;
    /** 第一单位 */
    private String firstUnit;
    /** 合作单位 */
    private String cooperUnit;
    /** 立项时间 */
    private String projectDate;
    /** 资助金额(万元) */
    private String grants;
    /** 到账金额(万元) */
    private String arrivalAmount;
    /** 结题时间 */
    private String concludingDate;
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

    public String getCooperUnit() {
        return cooperUnit;
    }

    public void setCooperUnit(String cooperUnit) {
        this.cooperUnit = cooperUnit;
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

    public String getConcludingDate() {
        return concludingDate;
    }

    public void setConcludingDate(String concludingDate) {
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
        return "SciResSubjectFileNameConfig{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectLevel='" + subjectLevel + '\'' +
                ", moderator='" + moderator + '\'' +
                ", modMajorId='" + modMajorId + '\'' +
                ", modParticipant='" + modParticipant + '\'' +
                ", firstUnit='" + firstUnit + '\'' +
                ", cooperUnit='" + cooperUnit + '\'' +
                ", projectDate='" + projectDate + '\'' +
                ", grants='" + grants + '\'' +
                ", arrivalAmount='" + arrivalAmount + '\'' +
                ", concludingDate='" + concludingDate + '\'' +
                ", projectSource='" + projectSource + '\'' +
                ", isFinished='" + isFinished + '\'' +
                ", isFinishedOnTime='" + isFinishedOnTime + '\'' +
                ", attachFile='" + attachFile + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
