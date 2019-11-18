package com.ruoyi.project.system.award.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.system.dept.domain.Dept;

import java.util.Date;

/**
 *
 */
public class AwardVO extends BaseEntity
{
	/** 奖励编号 */
	private Integer awardId;
	/** 奖励名称 */
	private String awardName;
	/** 第一完成人编号 */
	private String firstWinner;
	/** 第一完成人专业 */
	private Dept firstWinnerMajor;
	/** 第二完成人 */
	private String secondWinner;
	/** 第二完成人专业 */
	private Dept secondWinnerMajor;
	/** 第三获奖人 */
	private String thirdWinner;
	/** 第三获奖人专业 */
	private Dept thirdWinnerMajor;
	/** 第一单位 */
	private String firstDept;
	/** 合作单位 */
	private String workWithDept;
	/** 奖励级别 */
	private Integer awardLeval;
	/** 奖励来源 */
	private String awardFrom;
	/** 奖励等级 */
	private Integer awardNumber;
	/** 获奖时间 */
	private Date awardDate;
	/** 附件 */
	private String attachFile;
	/** 备注 */
	private String note;


	public Integer getAwardId() {
		return awardId;
	}

	public void setAwardId(Integer awardId) {
		this.awardId = awardId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getFirstWinner() {
		return firstWinner;
	}

	public void setFirstWinner(String firstWinner) {
		this.firstWinner = firstWinner;
	}

	public Dept getFirstWinnerMajor() {
		return firstWinnerMajor;
	}

	public void setFirstWinnerMajor(Dept firstWinnerMajor) {
		this.firstWinnerMajor = firstWinnerMajor;
	}

	public String getSecondWinner() {
		return secondWinner;
	}

	public void setSecondWinner(String secondWinner) {
		this.secondWinner = secondWinner;
	}

	public Dept getSecondWinnerMajor() {
		return secondWinnerMajor;
	}

	public void setSecondWinnerMajor(Dept secondWinnerMajor) {
		this.secondWinnerMajor = secondWinnerMajor;
	}

	public String getThirdWinner() {
		return thirdWinner;
	}

	public void setThirdWinner(String thirdWinner) {
		this.thirdWinner = thirdWinner;
	}

	public Dept getThirdWinnerMajor() {
		return thirdWinnerMajor;
	}

	public void setThirdWinnerMajor(Dept thirdWinnerMajor) {
		this.thirdWinnerMajor = thirdWinnerMajor;
	}

	public String getFirstDept() {
		return firstDept;
	}

	public void setFirstDept(String firstDept) {
		this.firstDept = firstDept;
	}

	public String getWorkWithDept() {
		return workWithDept;
	}

	public void setWorkWithDept(String workWithDept) {
		this.workWithDept = workWithDept;
	}

	public Integer getAwardLeval() {
		return awardLeval;
	}

	public void setAwardLeval(Integer awardLeval) {
		this.awardLeval = awardLeval;
	}

	public String getAwardFrom() {
		return awardFrom;
	}

	public void setAwardFrom(String awardFrom) {
		this.awardFrom = awardFrom;
	}

	public Integer getAwardNumber() {
		return awardNumber;
	}

	public void setAwardNumber(Integer awardNumber) {
		this.awardNumber = awardNumber;
	}

	public Date getAwardDate() {
		return awardDate;
	}

	public void setAwardDate(Date awardDate) {
		this.awardDate = awardDate;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
