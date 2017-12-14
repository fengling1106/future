package com.valen.future.bean.work;


import java.io.Serializable;
import java.sql.Timestamp;



/**
 * @author fengling
 * @create 2017-11-23
 * @Description 定义工作记录模型
 */
public class WorkRecord implements Serializable {
	

	private static final long serialVersionUID = 300002017120201L;
	
	
	private Long workId;
	private String userName;
	private String noteDate;
	private Integer state;
	private String comment;
	private Timestamp createDate;	
	private Timestamp modifyDate;
	
	public Long getWorkId()
	{	
		return workId;
	}
	public void setWorkId(Long workId)
	{
		this.workId =workId;
	}		
	
	public String getNoteDate()
	{	
		return noteDate;
	}
	public void setNoteDate(String noteDate)
	{
		this.noteDate =noteDate;
	}	
	
	public String getUserName()
	{	
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName =userName;
	}	

	
	public Timestamp getCreateDate()
	{
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate)
	{
		this.createDate=createDate;
	}
	
	public Integer getState()
	{
		return this.state;
	}
	public void setState(Integer state)
	{
		this.state=state;
	}
	
	public String getComment()
	{	
		return comment;
	}
	public void setComment(String comment)
	{
		this.comment=comment;
	}	
	
	public Timestamp getModifyDate()
	{
		return this.modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate)
	{
		this.modifyDate=modifyDate;
	}	
	
}
