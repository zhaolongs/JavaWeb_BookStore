package com.androidlongs.book.mobel.book.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.base.Dao;
import com.androidlongs.book.common.model.book.BookModel;
import com.androidlongs.book.common.model.user.UserModel;
import com.androidlongs.book.utils.HBUtils;

public class BookDaoImple implements BookDao{

	@Override
	public BaseModel addModel(BaseModel model) {
		BookModel bookModel =(BookModel) model;
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.saveOrUpdate(bookModel);
		beginTransaction.commit();
		session.close();
		return queryBookFromName(bookModel.getBname());
	}

	@Override
	public void deleteMocel(BaseModel deleteModel) {
		BookModel bookModel =(BookModel) deleteModel;
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.delete(bookModel);
		beginTransaction.commit();
		session.close();
	}

	@Override
	public void updateModel(BaseModel updateModel) {
		BookModel bookModel =(BookModel) updateModel;
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.saveOrUpdate(bookModel);
		beginTransaction.commit();
		session.close();
	}

	@Override
	public BaseModel queryModel(String id) {
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		//通过uname来查询
		BookModel userModel = (BookModel) session.createCriteria(BookModel.class)
				.add(Restrictions.eq("bname", id))	
				.uniqueResult();


		beginTransaction.commit();
		session.close();
		return userModel;
	}

	@Override
	public List<BookModel> queryBookList() {
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		Criteria createCriteria = session.createCriteria(BookModel.class);
		List<BookModel> list = createCriteria.list();
		beginTransaction.commit();
		session.close();
		return list;
	}

	@Override
	public BookModel queryBookFromName(String name) {
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		//通过uname来查询
		BookModel userModel = (BookModel) session.createCriteria(BookModel.class)
				.add(Restrictions.eq("bname", name))	
				.uniqueResult();


		beginTransaction.commit();
		session.close();
		return userModel;
	}

	@Override
	public BookModel queryBookFromId(String id) {
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		//通过uname来查询
		BookModel userModel = (BookModel) session.createCriteria(BookModel.class)
				.add(Restrictions.eq("uuid", id))	
				.uniqueResult();


		beginTransaction.commit();
		session.close();
		return userModel;

	}

}
