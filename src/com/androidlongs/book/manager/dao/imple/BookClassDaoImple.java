package com.androidlongs.book.manager.dao.imple;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.book.BookModel;
import com.androidlongs.book.common.model.selfs.BookClassModel;
import com.androidlongs.book.manager.dao.BookClassDao;
import com.androidlongs.book.utils.HBUtils;

public class BookClassDaoImple  implements BookClassDao{

	@Override
	public BaseModel addModel(BaseModel model) {
		
		BookClassModel bookClassModel = (BookClassModel) model;
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.save(bookClassModel);
		beginTransaction.commit();
		session.close();
		
		//获取最新的信息
		return queryBookClassModelFromName(bookClassModel.getBcname());
	}

	@Override
	public void deleteMocel(BaseModel deleteModel) {
		BookClassModel bookClassModel = (BookClassModel) deleteModel;
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.delete(bookClassModel);
		beginTransaction.commit();
		session.close();
		
	}

	@Override
	public void updateModel(BaseModel updateModel) {
		BookClassModel bookClassModel = (BookClassModel) updateModel;
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.saveOrUpdate(bookClassModel);
		beginTransaction.commit();
		session.close();
		
	}

	@Override
	public BaseModel queryModel(String id) {
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		//通过uname来查询
		BookClassModel userModel = (BookClassModel) session.createCriteria(BookClassModel.class)
				.add(Restrictions.eq("bcuuid", id))	
				.uniqueResult();


		beginTransaction.commit();
		session.close();
		return userModel;
	}

	@Override
	public BookClassModel queryBookClassModelFromName(String name) {
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		//通过uname来查询
		List<BookClassModel> userModelList = session.createCriteria(BookClassModel.class)
				.add(Restrictions.eq("bcname", name)).list();	

		BookClassModel bookClassModel = null;
		if (userModelList!=null&&userModelList.size()>=1) {
			bookClassModel = userModelList.get(0);
		}

		beginTransaction.commit();
		session.close();
		return bookClassModel;
	}

	@Override
	public List<BaseModel> queryAllBookClassModelList() {
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		Criteria createCriteria = session.createCriteria(BookClassModel.class);
		List<BaseModel> list = createCriteria.list();
		beginTransaction.commit();
		session.close();
		return list;
	}

}
