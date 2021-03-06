package com.androidlongs.book.mobel.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.selfs.BookClassModel;

public class ResponseModel implements Serializable{

	/**
	 * 1000 操作成功
	 * 1001 操作失败
	 */
	private String code;
	private String message;
	private BaseModel content;
	private List<BaseModel> contentList = new ArrayList<BaseModel>();

	public String getCode() {
		return code;
	}
	public List<BaseModel> getContentList() {
		return contentList;
	}
	public void setContentList(List<BaseModel> contentList) {
		this.contentList = contentList;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BaseModel getContent() {
		return content;
	}
	public void setContent(BaseModel content) {
		this.content = content;
	}
	public void setBookContentList(List<BookClassModel> list) {
		for (int i = 0; i < list.size(); i++) {
			this.contentList.add(list.get(i));
		}
	}
	public List<BaseModel> getBookContentList() {

		return	this.contentList;

	}
	@Override
	public String toString() {
		return "ResponseModel [code=" + code + ", message=" + message
				+ ", content=" + content + ", contentList=" + contentList + "]";
	}


	


}
