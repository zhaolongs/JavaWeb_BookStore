package com.androidlongs.book.mobel.common;

import java.util.List;
import java.util.UUID;

import com.androidlongs.book.common.model.book.BookModel;
import com.androidlongs.book.common.model.selfs.BookClassModel;
import com.androidlongs.book.common.model.user.UserModel;
import com.androidlongs.book.mobel.book.dao.BookDao;
import com.androidlongs.book.mobel.book.dao.BookDaoImple;
import com.androidlongs.book.mobel.login.dao.UserDao;
import com.androidlongs.book.mobel.login.dao.UserDaoImple;

public class HomeServiceImple  implements HomeService{

	private UserDao mUserDao = new UserDaoImple();
	private BookDao mBookDao = new BookDaoImple();
	@Override
	public UserModel login(String userName) {
		return (UserModel)mUserDao.queryModel(userName);
	}

	@Override
	public UserModel regist(UserModel userModel) {
		userModel.setUserUUID(UUID.randomUUID().toString());
		return (UserModel) mUserDao.addModel(userModel);
	}

	@Override
	public List<BookModel> getBookList() {
		List<BookModel> queryBookList = mBookDao.queryBookList();
		return queryBookList;
	}

	@Override
	public List<BookClassModel> getBookClassList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookModel getBookModelFromName(String name) {
		return mBookDao.queryBookFromName(name);
	}

}
