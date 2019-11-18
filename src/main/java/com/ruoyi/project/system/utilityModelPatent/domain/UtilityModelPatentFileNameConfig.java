package com.ruoyi.project.system.utilityModelPatent.domain;

public class UtilityModelPatentFileNameConfig {
    /** 专利Id */
    private Integer patentId;
    /** 专利名称 */
    private String patentName;
    /** 专利号 */
    private String patentNumber;
    /** 第一发明人 */
    private String inventor1Name;
    /** 第一发明人专业 */
    private String inventor1MajorId;
    /** 其它发明人 */
    private String otherInventor;
    /** 专利权人 */
    private String patentee;
    /** 授权公告日 */
    private String accreditNoticeDate;
    /** 附件 */
    private String attachFile;

    public Integer getPatentId() {
        return patentId;
    }

    public void setPatentId(Integer patentId) {
        this.patentId = patentId;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getPatentNumber() {
        return patentNumber;
    }

    public void setPatentNumber(String patentNumber) {
        this.patentNumber = patentNumber;
    }

    public String getInventor1Name() {
        return inventor1Name;
    }

    public void setInventor1Name(String inventor1Name) {
        this.inventor1Name = inventor1Name;
    }

    public String getInventor1MajorId() {
        return inventor1MajorId;
    }

    public void setInventor1MajorId(String inventor1MajorId) {
        this.inventor1MajorId = inventor1MajorId;
    }

    public String getOtherInventor() {
        return otherInventor;
    }

    public void setOtherInventor(String otherInventor) {
        this.otherInventor = otherInventor;
    }

    public String getPatentee() {
        return patentee;
    }

    public void setPatentee(String patentee) {
        this.patentee = patentee;
    }

    public String getAccreditNoticeDate() {
        return accreditNoticeDate;
    }

    public void setAccreditNoticeDate(String accreditNoticeDate) {
        this.accreditNoticeDate = accreditNoticeDate;
    }

    public String getAttachFile() {
        return attachFile;
    }

    public void setAttachFile(String attachFile) {
        this.attachFile = attachFile;
    }

    @Override
    public String toString() {
        return "UtilityModelPatentFileNameConfig{" +
                "patentId=" + patentId +
                ", patentName='" + patentName + '\'' +
                ", patentNumber='" + patentNumber + '\'' +
                ", inventor1Name='" + inventor1Name + '\'' +
                ", inventor1MajorId='" + inventor1MajorId + '\'' +
                ", otherInventor='" + otherInventor + '\'' +
                ", patentee='" + patentee + '\'' +
                ", accreditNoticeDate='" + accreditNoticeDate + '\'' +
                ", attachFile='" + attachFile + '\'' +
                '}';
    }
}
