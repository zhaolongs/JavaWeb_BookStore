package com.androidlongs.book.common.model.book;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.selfs.BookClassModel;
import com.androidlongs.book.common.model.user.UserModel;

public class BookModel extends BaseModel implements Serializable{

	private Integer bid;
	private String uuid;
	//书名
	private String bname;
	//作者
	private String bauthor;
	//书籍地址
	private String bpath;
	//书籍描述 
	private String bdesc;
	
	//书籍图片名称
	private String bpname;
	//书籍图片地址
	private String bppath;
	
	
	
	public String getBpname() {
		return bpname;
	}
	public void setBpname(String bpname) {
		this.bpname = bpname;
	}
	public String getBppath() {
		return bppath;
	}
	public void setBppath(String bppath) {
		this.bppath = bppath;
	}
	private Set<UserModel> bUserSet = new HashSet<>();

	private Set<BookClassModel> bBookClassSet = new HashSet<>();

	public void addUserModel(UserModel model){
		bUserSet.add(model);
	}
	public void addBookClassModel(BookClassModel model){
		bBookClassSet.add(model);
	}
	
	
	
	
	
	
	

	public String getBpath() {
		return bpath;
	}
	public void setBpath(String bpath) {
		this.bpath = bpath;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
