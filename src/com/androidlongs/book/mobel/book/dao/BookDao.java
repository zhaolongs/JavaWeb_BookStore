package com.androidlongs.book.mobel.book.dao;

import java.util.List;

import com.androidlongs.book.base.Dao;
import com.androidlongs.book.common.model.book.BookModel;

public interface BookDao extends Dao{
	
	List<BookModel> queryBookList();
	
	BookModel queryBookFromName(String name);
	BookModel queryBookFromId(String name);

}
