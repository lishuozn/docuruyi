package com.ruoyi.project.system.user.domain;

import java.util.Date;

public class AttachFileNumber {
    private int award;
    private int publication;
    private int docPaper;
    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public int getDocPaper() {
        return docPaper;
    }

    public void setDocPaper(int docPaper) {
        this.docPaper = docPaper;
    }
}
