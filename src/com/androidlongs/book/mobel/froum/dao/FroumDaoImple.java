package com.androidlongs.book.mobel.froum.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.book.BookModel;
import com.androidlongs.book.common.model.friend.FroumModel;
import com.androidlongs.book.common.model.user.UserModel;
import com.androidlongs.book.utils.HBUtils;

public class FroumDaoImple implements FroumDao {

	@Override
	public BaseModel addModel(BaseModel model) {
		FroumModel froumModel = (FroumModel) model;
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.saveOrUpdate(froumModel);
		beginTransaction.commit();
		session.close();
		return queryModel(froumModel.getFuuid());
	}

	@Override
	public void deleteMocel(BaseModel deleteModel) {
		FroumModel froumModel = (FroumModel) deleteModel;
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.delete(froumModel);
		beginTransaction.commit();
		session.close();
	}

	@Override
	public void updateModel(BaseModel updateModel) {
		FroumModel froumModel = (FroumModel) updateModel;
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.saveOrUpdate(froumModel);
		beginTransaction.commit();
		session.close();
	}

	@Override
	public BaseModel queryModel(String id) {
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		//通过uname来查询
		FroumModel userModel = (FroumModel) session.createCriteria(FroumModel.class)
				.add(Restrictions.eq("fuuid", id))	
				.uniqueResult();


		beginTransaction.commit();
		session.close();
		return userModel;
	}

	@Override
	public List<FroumModel> queryFromUserId(String userId) {

		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();

		
		Query query = session.createQuery("from FroumModel where userUuid = ? ");  
		query.setString(0, userId);  

		List<FroumModel> list = query.list();

		beginTransaction.commit();
		session.close();

		return list;
	}

	@Override
	public List<FroumModel> queryAllFromList() {
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		Criteria createCriteria = session.createCriteria(FroumModel.class);
		List<FroumModel> list = createCriteria.list();
		beginTransaction.commit();
		session.close();
		return list;
	}

}
