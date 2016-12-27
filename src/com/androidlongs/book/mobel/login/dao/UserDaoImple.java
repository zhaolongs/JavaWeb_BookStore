package com.androidlongs.book.mobel.login.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.user.UserModel;
import com.androidlongs.book.utils.HBUtils;

public class UserDaoImple implements UserDao{

	@Override
	public BaseModel addModel(BaseModel model) {
		UserModel userModel = (UserModel)model;
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.saveOrUpdate(userModel);
		beginTransaction.commit();
		session.close();
		return queryModel(userModel.getUname());
	}

	@Override
	public void deleteMocel(BaseModel deleteModel) {
		UserModel userModel = (UserModel)deleteModel;
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.delete(userModel);
		beginTransaction.commit();
		session.close();
	}

	@Override
	public void updateModel(BaseModel updateModel) {
		UserModel userModel = (UserModel)updateModel;
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.saveOrUpdate(userModel);
		beginTransaction.commit();
		session.close();
	}

	@Override
	public BaseModel queryModel(String id) {
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		//通过uname来查询
		UserModel userModel = (UserModel) session.createCriteria(UserModel.class)
				.add(Restrictions.eq("uname", id))	
				.uniqueResult();


		beginTransaction.commit();
		session.close();
		return userModel;
	}

}
