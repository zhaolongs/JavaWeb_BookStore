package com.androidlongs.book.manager.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.selfs.BookClassModel;
import com.androidlongs.book.mobel.common.HomeServlet;
import com.androidlongs.book.mobel.common.ResponseModel;

/**
 * Servlet implementation class AddBookClassServlet
 * 添加书籍管理分类
 */
@WebServlet("/manager/addbookclass")
public class AddBookClassServlet extends HomeServlet{

	
	@Override
	public void doRequest(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("添加书籍分类 ");
		
		String title = request.getParameter("selfsTitle");
		String desc = request.getParameter("selfsDesc");
		
		if (title!=null&&!title.equals("")) {
			title =URLDecoder.decode(title);
		}
		
		if (desc!=null&&!desc.equals("")) {
			desc =URLDecoder.decode(desc);
		}
		
		BookClassModel bookClassModel = new BookClassModel();
		
		bookClassModel.setBcname(title);
		bookClassModel.setBcdesc(desc);
		
		BookClassModel addBookClass = (BookClassModel) mBookClassServiceInterface.addBookClass(bookClassModel);
		
		
		ResponseModel responseModel = new ResponseModel();
		responseModel.setCode("1000");
		responseModel.setMessage("添加成功");
		responseModel.setContent(addBookClass);
		try {
		String responseString = JSONSerializer.toJSON(responseModel).toString();
			response.getWriter().write(responseString);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
}
