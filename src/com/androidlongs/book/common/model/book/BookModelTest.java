package com.androidlongs.book.common.model.book;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


import com.androidlongs.book.utils.HBUtils;

public class BookModelTest {

	@Test
	public void add() {
		BookModel model = new BookModel();
		model.setBname("xiso");
		model.setBauthor("赵子龙");
		model.setBdesc("222");

		//1 加载配置文件 ,注意：调用方法
		Configuration config = new Configuration().configure("com/androidlongs/book/config/hibernate.cfg.xml");
		//2 获得SessionFactory，相当于连接池
		SessionFactory factory = config.buildSessionFactory();
		//3获得Session，相当于 jdbc 连接 Connection
		Session session = factory.openSession();
		//4 开启事务
		Transaction transaction = session.beginTransaction();

		//**** 操作
		session.save(model);

		//5 提交
		transaction.commit();
		//6 释放
		session.close();
		//7 关闭工厂
		factory.close();
	}
	@Test
	public void update(){
		BookModel model = new BookModel();
		model.setBid(2);
		model.setBname("xiso_update");
		model.setBauthor("赵子龙");
		model.setBdesc("222");

		//1 加载配置文件 ,注意：调用方法
		Configuration config = new Configuration().configure("com/androidlongs/book/config/hibernate.cfg.xml");
		//2 获得SessionFactory，相当于连接池
		SessionFactory factory = config.buildSessionFactory();
		//3获得Session，相当于 jdbc 连接 Connection
		Session session = factory.openSession();
		//4 开启事务
		Transaction transaction = session.beginTransaction();

		//**** 操作
		session.update(model);

		//5 提交
		transaction.commit();
		//6 释放
		session.close();
		//7 关闭工厂
		factory.close();
	}

	@Test
	public void queryModel(){
		//1 加载配置文件 ,注意：调用方法
		Configuration config = new Configuration().configure("com/androidlongs/book/config/hibernate.cfg.xml");
		//2 获得SessionFactory，相当于连接池
		SessionFactory factory = config.buildSessionFactory();
		//3获得Session，相当于 jdbc 连接 Connection
		Session session = factory.openSession();
		//4 开启事务
		Transaction transaction = session.beginTransaction();

		//**** 操作
		BookModel bookModel = (BookModel) session.get(BookModel.class, 2);

		System.out.println("book model is "+bookModel.toString());
		//5 提交
		transaction.commit();
		//6 释放
		session.close();
		//7 关闭工厂
		factory.close();

	}

	@Test
	public void queryAllModel(){



		//1 加载配置文件 ,注意：调用方法
		Configuration config = new Configuration().configure("com/androidlongs/book/config/hibernate.cfg.xml");
		//2 获得SessionFactory，相当于连接池
		SessionFactory factory = config.buildSessionFactory();
		//3获得Session，相当于 jdbc 连接 Connection
		Session session = factory.openSession();
		//4 开启事务
		Transaction transaction = session.beginTransaction();

		
		//**** 操作
		Query query = session.createQuery("from BookModel");
		//分页查询
		query.setFirstResult(0);
		query.setMaxResults(2);
		
		List<BookModel> bookModelList =query.list();
		for (BookModel bookModel : bookModelList) {
			System.out.println("book model is "+bookModel.toString());
		}

		//5 提交
		transaction.commit();
		//6 释放
		session.close();
		//7 关闭工厂
		factory.close();

	}

	@Test
	public void saveModel2(){
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		BookModel model = new BookModel();
		model.setBname("newX_2_3");
		session.save(model);
		beginTransaction.commit();
		session.close();
	}
	
	@Test
	public void updateModel2(){
		Session session = HBUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		BookModel model = new BookModel();
		model.setBid(2);
		model.setBname("newX_2");
		session.update(model);
		beginTransaction.commit();
		session.close();
	}
}
