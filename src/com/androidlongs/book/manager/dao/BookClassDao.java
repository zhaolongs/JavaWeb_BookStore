package com.androidlongs.book.manager.dao;

import com.androidlongs.book.base.Dao;
import com.androidlongs.book.common.model.selfs.BookClassModel;

public interface BookClassDao extends Dao {

	BookClassModel queryBookClassModelFromName(String name);
}
