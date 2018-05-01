package com.valen.future.bean.yd;

import java.io.Serializable;
import java.sql.Timestamp;

public class Option implements Serializable {
	private static final long serialVersionUID = 300002018022701L;
	
	//private byte infoType;
	private String region; //几期
	private int house; //楼栋
	private int cell;  //单元
	private int homeNumber; //房号
	private String name;
	private String phoneId;
	private String info;
	private Timestamp createDate; 
	
	/*public byte getInfoType()
	{
		return this.infoType;
	}
	
	public void setInfoType(byte infoType)
	{
		this.infoType=infoType;
	}*/
	
	public Timestamp getCreateDate()
	{
		return this.createDate;
	}
	
	public void setCreateDate(Timestamp createDate)
	{
		this.createDate=createDate;
	}	
	public void setRegion(String region)
	{
		this.region = region;
	}
	public String getRegion()
	{
		return this.region;
	}
	
	public void setHouse(int house)
	{
		this.house = house;
	}
	public int getHouse()
	{
		return this.house;
	}
	
	public void setCell(int cell)
	{
		this.cell = cell;
	}	
	public int getCell()
	{
		return this.cell;
	}	
	
	/*public void setLayer(String layer)
	{
		this.layer = layer;
	}	
	public String getLayer()
	{
		return this.layer;
	}	*/
	
	public void setHomeNumber(int homeNumber)
	{
		this.homeNumber = homeNumber;
	}	
	
	public int geHomeNumber()
	{
		return this.homeNumber;
	}		
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public void setPhoneId(String phoneId)
	{
		this.phoneId = phoneId;
	}
	
	public String getPhoneId()
	{
		return phoneId;
	}	
	
	public String getInfo()
	{
		return this.info;
	}
	
	public void setInfo(String info)
	{
		this.info=info;
	}	
}
