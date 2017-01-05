package com.androidlongs.book.manager.dao;

import java.util.List;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.base.Dao;
import com.androidlongs.book.common.model.selfs.BookClassModel;

public interface BookClassDao extends Dao {

	BookClassModel queryBookClassModelFromName(String name);
	//查询所有的BookClassModel
	List<BaseModel> queryAllBookClassModelList();
}
