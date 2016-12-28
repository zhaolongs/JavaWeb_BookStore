package com.androidlongs.book.common.model.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.book.BookModel;
import com.androidlongs.book.common.model.friend.FroumModel;
import com.sun.media.sound.ModelAbstractChannelMixer;

public class UserModel extends BaseModel implements Serializable{

	private Integer uid;
	private String userUUID;

	private String uname;
	private String uage;
	private String udesc;
	private String usex;
	private String upassword;
	//我的书架
	private Set<BookModel> uBookSet = new HashSet<>();
	
	
	public void addBookModel(BookModel model) {
		uBookSet.add(model);
	}
	public String getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}
	public Set<BookModel> getuBookSet() {
		return uBookSet;
	}

	public void setuBookSet(Set<BookModel> uBookSet) {
		this.uBookSet = uBookSet;
	}

	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUage() {
		return uage;
	}
	public void setUage(String uage) {
		this.uage = uage;
	}
	public String getUdesc() {
		return udesc;
	}
	public void setUdesc(String udesc) {
		this.udesc = udesc;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	@Override
	public String toString() {
		return "UserModel [uid=" + uid + ", uname=" + uname + ", uage=" + uage
				+ ", udesc=" + udesc + ", usex=" + usex + "]";
	}
	
	
	
	
	
	
}
