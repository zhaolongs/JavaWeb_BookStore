package com.androidlongs.book.common.model.selfs;

import java.util.HashSet;
import java.util.Set;

import com.androidlongs.book.common.model.book.BookModel;

public class BookClassModel {

	private Integer bcid;
	private String bcname;
	private String bcdesc;
	
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
