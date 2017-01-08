package com.androidlongs.book.manager.service.imple;

import java.util.List;
import java.util.UUID;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.selfs.BookClassModel;
import com.androidlongs.book.manager.dao.BookClassDao;
import com.androidlongs.book.manager.dao.imple.BookClassDaoImple;
import com.androidlongs.book.manager.service.BookClassServiceInterface;
import com.androidlongs.book.mobel.book.dao.BookDaoImple;

public class BookClassService implements BookClassServiceInterface{

	private BookClassDao mBookClassDao = new BookClassDaoImple();
	@Override
	public BaseModel addBookClass(BookClassModel bookClassModel) {
		
		//标识 
		String uuid =  UUID.randomUUID().toString();
		bookClassModel.setBcuuid(uuid);
		
		String addTime = System.currentTimeMillis()+"";
		bookClassModel.setBcaddTime(addTime);
		//最后一次修改时间 
		bookClassModel.setBclastUpdateTime(addTime);
		//保存到数据库
		BaseModel model =  mBookClassDao.addModel(bookClassModel);
		//返回类别信息
		return model;
	}

	@Override
	public BaseModel queryBookClassFromName(String name) {
		// TODO Auto-generated method stub
		return mBookClassDao.queryBookClassModelFromName(name);
	}

	@Override
	public BaseModel queryBookClassFromId(String uuid) {
		// TODO Auto-generated method stub
		return mBookClassDao.queryModel(uuid);
	}

	@Override
	public List<BaseModel> queryAllBookClass() {
		
		return mBookClassDao.queryAllBookClassModelList();
	}

	@Override
	public BaseModel uqdateBookClass(BookClassModel updateModel) {
		// TODO Auto-generated method stub
		BookClassModel model = updateModel;
		mBookClassDao.updateModel(updateModel);
		return mBookClassDao.queryModel(model.getBcuuid());
	}

	@Override
	public void deleteBookClassFromName(String name) {
		// TODO Auto-generated method stub
		BaseModel queryModel = mBookClassDao.queryBookClassModelFromName(name);
		mBookClassDao.deleteMocel(queryModel);
	}

	@Override
	public void deleteBookClassFromId(String id) {
		BaseModel queryModel = mBookClassDao.queryModel(id);
		mBookClassDao.deleteMocel(queryModel);
	}

	@Override
	public BaseModel updateBookClass(BookClassModel model) {
		// TODO Auto-generated method stub
		return null;
	}

}
