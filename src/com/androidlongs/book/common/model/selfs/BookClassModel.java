package com.androidlongs.book.common.model.selfs;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.book.BookModel;

public class BookClassModel extends BaseModel implements Serializable{

	private Integer bcid;
	private String bcuuid;
	private String bcname;
	private String bcdesc;
	private String bcaddTime;
	private String bclastUpdateTime;
	
	
	
	public String getBcuuid() {
		return bcuuid;
	}
	public void setBcuuid(String bcuuid) {
		this.bcuuid = bcuuid;
	}
	public String getBcaddTime() {
		return bcaddTime;
	}
	public void setBcaddTime(String bcaddTime) {
		this.bcaddTime = bcaddTime;
	}
	public String getBclastUpdateTime() {
		return bclastUpdateTime;
	}
	public void setBclastUpdateTime(String bclastUpdateTime) {
		this.bclastUpdateTime = bclastUpdateTime;
	}
	private Set<BookModel> bBookSet = new HashSet<>();
	
	

	public Set<BookModel> getbBookSet() {
		return bBookSet;
	}
	public void setbBookSet(Set<BookModel> bBookSet) {
		this.bBookSet = bBookSet;
	}
	public Integer getBcid() {
		return bcid;
	}
	public void setBcid(Integer bcid) {
		this.bcid = bcid;
	}
	public String getBcname() {
		return bcname;
	}
	public void setBcname(String bcname) {
		this.bcname = bcname;
	}
	public String getBcdesc() {
		return bcdesc;
	}
	public void setBcdesc(String bcdesc) {
		this.bcdesc = bcdesc;
	}
	@Override
	public String toString() {
		return "BookClassModel [bcid=" + bcid + ", bcname=" + bcname
				+ ", bcdesc=" + bcdesc + "]";
	}
	
	
	
	
	
	
}
