package com.ruoyi.project.system.fileNameConfig.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 文件命名配置表 sys_file_name_config
 * 
 * @author daivd
 * @date 2019-08-30
 */
public class FileNameConfig extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 序号 */
	private Integer fileNameId;
	/** 文件类型 */
	private String fileType;
	/** 命名规则 */
	private String nameRule;
    /** 文件类型 */
    private String fileDictType;

    public String getFileDictType() {
        return fileDictType;
    }

    public void setFileDictType(String fileDictType) {
        this.fileDictType = fileDictType;
    }

    public FileNameConfig(){
		super();
	}
	public FileNameConfig(String fileType) {
		super();
		this.fileType = fileType;
	}

	public void setFileNameId(Integer fileNameId)
	{
		this.fileNameId = fileNameId;
	}

	public Integer getFileNameId()
	{
		return fileNameId;
	}
	public void setFileType(String fileType)
	{
		this.fileType = fileType;
	}

	public String getFileType()
	{
		return fileType;
	}
	public void setNameRule(String nameRule)
	{
		this.nameRule = nameRule;
	}

	public String getNameRule()
	{
		return nameRule;
	}

    @Override
    public String toString() {
        return "FileNameConfig{" +
                "fileNameId=" + fileNameId +
                ", fileType='" + fileType + '\'' +
                ", nameRule='" + nameRule + '\'' +
                ", fileDictType='" + fileDictType + '\'' +
                '}';
    }
}
