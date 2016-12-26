package com.androidlongs.book.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.androidlongs.book.base.BaseModel;
import com.sun.org.apache.regexp.internal.recompile;

public class HBUtils {


	//提供一个工厂 (链式操作)
	private static SessionFactory factory = new Configuration().configure("com/androidlongs/book/config/hibernate.cfg.xml").buildSessionFactory();

	/**
	 * 获得新的回话
	 * @return
	 */
	public static Session openSession(){
		return factory.openSession() ;
	}

	/**
	 * 获得当前线程中绑定的session
	 * @return
	 */
	public static Session getCurrentSession(){
		return factory.getCurrentSession();
	}

}
