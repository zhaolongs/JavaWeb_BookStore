package com.androidlongs.book.common.model.book;

import java.util.HashSet;
import java.util.Set;

import com.androidlongs.book.common.model.selfs.BookClassModel;
import com.androidlongs.book.common.model.user.UserModel;

public class BookModel {

	private Integer bid;
	private String bname;
	private String bauthor;
	private String bdesc;
	private Set<UserModel> bUserSet = new HashSet<>();

	private Set<BookClassModel> bBookClassSet = new HashSet<>();

	public void addUserModel(UserModel model){
		bUserSet.add(model);
	}
	public void addBookClassModel(BookClassModel model){
		bBookClassSet.add(model);
	}
	
	

	public Set<BookClassModel> getbBookClassSet() {
		return bBookClassSet;
	}
	public void setbBookClassSet(Set<BookClassModel> bBookClassSet) {
		this.bBookClassSet = bBookClassSet;
	}
	public Set<UserModel> getbUserSet() {
		return bUserSet;
	}
	public void setbUserSet(Set<UserModel> bUserSet) {
		this.bUserSet = bUserSet;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBdesc() {
		return bdesc;
	}
	public void setBdesc(String bdesc) {
		this.bdesc = bdesc;
	}
	@Override
	public String toString() {
		return "BookModel [bid=" + bid + ", bname=" + bname + ", bauthor="
				+ bauthor + ", bdesc=" + bdesc + "]";
	}



}
