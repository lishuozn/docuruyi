package com.ruoyi.project.system.award.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 教师奖励表 sys_award
 * 
 * @author daivd
 * @date 2019-10-27
 */
public class Award extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 奖励编号 */
	private Integer awardId;
	/** 奖励名称 */
	private String awardName;
	/** 第一完成人编号 */
	private String firstWinner;
	/** 第一完成人专业 */
	private Integer firstWinnerMajor;
	/** 第二完成人 */
	private String secondWinner;
	/** 第二完成人专业 */
	private Integer secondWinnerMajor;
	/** 第三获奖人 */
	private String thirdWinner;
	/** 第三获奖人专业 */
	private Integer thirdWinnerMajor;
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

	public void setAwardId(Integer awardId) 
	{
		this.awardId = awardId;
	}

	public Integer getAwardId() 
	{
		return awardId;
	}
	public void setAwardName(String awardName) 
	{
		this.awardName = awardName;
	}

	public String getAwardName() 
	{
		return awardName;
	}
	public void setFirstWinner(String firstWinner) 
	{
		this.firstWinner = firstWinner;
	}

	public String getFirstWinner() 
	{
		return firstWinner;
	}
	public void setFirstWinnerMajor(Integer firstWinnerMajor) 
	{
		this.firstWinnerMajor = firstWinnerMajor;
	}

	public Integer getFirstWinnerMajor() 
	{
		return firstWinnerMajor;
	}
	public void setSecondWinner(String secondWinner) 
	{
		this.secondWinner = secondWinner;
	}

	public String getSecondWinner() 
	{
		return secondWinner;
	}
	public void setSecondWinnerMajor(Integer secondWinnerMajor) 
	{
		this.secondWinnerMajor = secondWinnerMajor;
	}

	public Integer getSecondWinnerMajor() 
	{
		return secondWinnerMajor;
	}
	public void setThirdWinner(String thirdWinner) 
	{
		this.thirdWinner = thirdWinner;
	}

	public String getThirdWinner() 
	{
		return thirdWinner;
	}
	public void setThirdWinnerMajor(Integer thirdWinnerMajor) 
	{
		this.thirdWinnerMajor = thirdWinnerMajor;
	}

	public Integer getThirdWinnerMajor() 
	{
		return thirdWinnerMajor;
	}
	public void setFirstDept(String firstDept) 
	{
		this.firstDept = firstDept;
	}

	public String getFirstDept() 
	{
		return firstDept;
	}
	public void setWorkWithDept(String workWithDept) 
	{
		this.workWithDept = workWithDept;
	}

	public String getWorkWithDept() 
	{
		return workWithDept;
	}
	public void setAwardLeval(Integer awardLeval) 
	{
		this.awardLeval = awardLeval;
	}

	public Integer getAwardLeval() 
	{
		return awardLeval;
	}
	public void setAwardFrom(String awardFrom) 
	{
		this.awardFrom = awardFrom;
	}

	public String getAwardFrom() 
	{
		return awardFrom;
	}
	public void setAwardNumber(Integer awardNumber) 
	{
		this.awardNumber = awardNumber;
	}

	public Integer getAwardNumber() 
	{
		return awardNumber;
	}
	public void setAwardDate(Date awardDate) 
	{
		this.awardDate = awardDate;
	}

	public Date getAwardDate() 
	{
		return awardDate;
	}
	public void setAttachFile(String attachFile) 
	{
		this.attachFile = attachFile;
	}

	public String getAttachFile() 
	{
		return attachFile;
	}
	public void setNote(String note) 
	{
		this.note = note;
	}

	public String getNote() 
	{
		return note;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("awardId", getAwardId())
            .append("awardName", getAwardName())
            .append("firstWinner", getFirstWinner())
            .append("firstWinnerMajor", getFirstWinnerMajor())
            .append("secondWinner", getSecondWinner())
            .append("secondWinnerMajor", getSecondWinnerMajor())
            .append("thirdWinner", getThirdWinner())
            .append("thirdWinnerMajor", getThirdWinnerMajor())
            .append("firstDept", getFirstDept())
            .append("workWithDept", getWorkWithDept())
            .append("awardLeval", getAwardLeval())
            .append("awardFrom", getAwardFrom())
            .append("awardNumber", getAwardNumber())
            .append("awardDate", getAwardDate())
            .append("attachFile", getAttachFile())
            .append("note", getNote())
            .toString();
    }
}
