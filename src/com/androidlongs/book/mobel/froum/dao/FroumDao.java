package com.androidlongs.book.mobel.froum.dao;

import java.util.List;

import com.androidlongs.book.base.Dao;
import com.androidlongs.book.common.model.friend.FroumModel;

public interface FroumDao extends Dao{

	//查询指定用户对应的论坛内容
	List<FroumModel> queryFromUserId(String userId);
	//查询所有的论坛
	List<FroumModel> queryAllFromList();
	
}
