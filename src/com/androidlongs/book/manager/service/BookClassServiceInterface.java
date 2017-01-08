package com.androidlongs.book.manager.service;

import java.util.List;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.book.BookModel;
import com.androidlongs.book.common.model.selfs.BookClassModel;

public interface BookClassServiceInterface {

	//添加书籍分类 
	BaseModel addBookClass(BookClassModel bookClassModel);
	//查询书籍分类
	BaseModel queryBookClassFromName(String name);
	BaseModel queryBookClassFromId(String uuid);
	
	//更新书籍分类
	BaseModel updateBookClass(BookClassModel model);
	
	//查询所有的书籍分类 
	List<BaseModel> queryAllBookClass();
	//修改书籍分类
	BaseModel uqdateBookClass(BookClassModel bookClassModel);
	//删除书籍分类 
	void deleteBookClassFromName(String name);
	void deleteBookClassFromId(String id);
	
}
