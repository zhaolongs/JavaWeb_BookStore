package com.androidlongs.book.mobel.book.servlet;

import java.util.List;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import com.androidlongs.book.common.model.book.BookModel;
import com.androidlongs.book.mobel.common.HomeServiceImple;
import com.androidlongs.book.mobel.common.HomeServlet;
import com.androidlongs.book.mobel.common.ResponseModel;
import com.sun.media.jai.opimage.RescaleCRIF;

@WebServlet("/book/list")
public class BookListServlet extends HomeServlet{

	@Override
	public void doRequest(HttpServletRequest request,
			HttpServletResponse response) {
		System.err.println("获取书籍列表 ");
		try {
			List<BookModel> bookList = mHomeService.getBookList();

			JsonConfig config = new JsonConfig();
			config.setExcludes(new String[]{"bBookSet"});//除去emps属性
			String responseString = JSONArray.fromObject(bookList, config).toString();


			//String result = JSONSerializer.toJSON(bookList).toString();
			response.getWriter().write(responseString);
		} catch (Exception e) {
			System.out.println(" "+e.getMessage());
		}


	}

}
