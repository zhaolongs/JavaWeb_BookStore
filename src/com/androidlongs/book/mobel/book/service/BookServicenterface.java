package com.androidlongs.book.mobel.book.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.book.BookModel;

public interface BookServicenterface {
	//添加书籍
	BaseModel addBook(BookModel bookModel);
	//修改书籍
	BaseModel updateBook(BookModel bookModel);
	//删除书籍
	void deleteBookFromId(String id);
	void deleteBookFromName(String name);

	
}
