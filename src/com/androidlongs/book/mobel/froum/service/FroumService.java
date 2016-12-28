package com.androidlongs.book.mobel.froum.service;

import java.util.List;

import com.androidlongs.book.common.model.friend.FroumModel;

public interface FroumService {

	//新增
	void addFroumModel(FroumModel froumModel);
	//删除
	void deleteFroumModel(String frouId);
	//获取指定ID的FroumModel
	FroumModel getFroumFroumId(String froumId);
	//获取指定用户的所有的FroumModel
	List<FroumModel> getFroumListFroumUserId(String userId);
	//获取所有的FroumModel
	List<FroumModel> getAllFroumList();
	
}
