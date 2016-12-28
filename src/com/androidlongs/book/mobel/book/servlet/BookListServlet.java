package com.androidlongs.book.mobel.book.servlet;

import java.util.List;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

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

			String result = JSONSerializer.toJSON(bookList).toString();
			response.getWriter().write(result);
		} catch (Exception e) {
			System.out.println(" "+e.getMessage());
		}
		
		
	}

}
