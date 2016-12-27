package com.androidlongs.book.common.model.user;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.androidlongs.book.utils.HBUtils;

public class UserTest {

	@Test
	public void test() {
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		UserModel model = new UserModel();
		model.setUname("小明--sss");
		
		session.saveOrUpdate(model);
		beginTransaction.commit();
		session.close();
	}

}
