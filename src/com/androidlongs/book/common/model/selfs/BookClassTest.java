package com.androidlongs.book.common.model.selfs;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.androidlongs.book.utils.HBUtils;
import com.sun.media.jai.codecimpl.util.DataBufferUtils;

public class BookClassTest {

	@Test
	public void addModel() {
		Session session = HBUtils.openSession();
		BookClassModel model = new BookClassModel();
		Transaction beginTransaction = session.beginTransaction();
		model.setBcdesc("小说是一种传奇");
		model.setBcname("小说");
		session.save(model);
		beginTransaction.commit();
		session.close();
	}

}
