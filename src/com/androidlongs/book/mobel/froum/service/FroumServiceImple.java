package com.androidlongs.book.mobel.froum.service;

import java.util.List;
import java.util.UUID;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.friend.FroumModel;
import com.androidlongs.book.mobel.froum.dao.FroumDao;
import com.androidlongs.book.mobel.froum.dao.FroumDaoImple;

public class FroumServiceImple implements FroumService {
	private FroumDao mfFroumDao = new FroumDaoImple();

	@Override
	public void addFroumModel(FroumModel froumModel) {

		try {
			//设置UUID
			froumModel.setFuuid(UUID.randomUUID().toString());
			//保存
			mfFroumDao.addModel(froumModel);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void deleteFroumModel(String frouId) {
		try {
			FroumModel queryModel = (FroumModel) mfFroumDao.queryModel(frouId);
			if (queryModel!=null) {
				mfFroumDao.deleteMocel(queryModel);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public FroumModel getFroumFroumId(String froumId) {
		try {
			if (froumId==null||froumId.equals("")) {
				return null;
			}
			FroumModel queryModel = (FroumModel) mfFroumDao.queryModel(froumId);
			return queryModel;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<FroumModel> getFroumListFroumUserId(String userId) {
		try {
			if (userId==null||userId.equals("")) {
				return null;
			}
			List<FroumModel> froumList = mfFroumDao.queryFromUserId(userId);
			return froumList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<FroumModel> getAllFroumList() {
		try {
			
			List<FroumModel> froumList = mfFroumDao.queryAllFromList();
			return froumList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
