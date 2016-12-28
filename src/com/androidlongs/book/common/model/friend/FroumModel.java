package com.androidlongs.book.common.model.friend;

import java.io.Serializable;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.user.UserModel;

public class FroumModel extends BaseModel implements Serializable {

	//表序号
	private Integer fuid;
	//内容uuid
	private String fuuid;
	//对应用户uuid
	private String userUuid;
	//内容描述
	private String fDesc;
	public String getFuuid() {
		return fuuid;
	}
	public void setFuuid(String fuuid) {
		this.fuuid = fuuid;
	}
	public String getUserUuid() {
		return userUuid;
	}
	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}
	/**
	 * 论坛内容 
	 * 与用户是多对一关系
	 */
	//private UserModel userModel;
	//时间
	private String uFromTime;
	public Integer getFuid() {
		return fuid;
	}
	public void setFuid(Integer fuid) {
		this.fuid = fuid;
	}
	public String getfDesc() {
		return fDesc;
	}
	public void setfDesc(String fDesc) {
		this.fDesc = fDesc;
	}
	public String getuFromTime() {
		return uFromTime;
	}
	public void setuFromTime(String uFromTime) {
		this.uFromTime = uFromTime;
	}
	@Override
	public String toString() {
		return "FroumModel [fuid=" + fuid + ", fuuid=" + fuuid + ", userUuid="
				+ userUuid + ", fDesc=" + fDesc + ", uFromTime=" + uFromTime
				+ "]";
	}
	
	
	
	
	
}
