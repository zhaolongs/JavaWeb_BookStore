package com.androidlongs.book.mobel.common;

import java.util.List;

import com.androidlongs.book.common.model.book.BookModel;
import com.androidlongs.book.common.model.selfs.BookClassModel;
import com.androidlongs.book.common.model.user.UserModel;

public interface HomeService {

	//登录 
	UserModel login(String userName);
	//注册
	UserModel regist(UserModel userModel);
	//获取书籍列表
	List<BookModel> getBookList();
	//获取书籍分类
	List<BookClassModel> getBookClassList();
	
}
