package com.androidlongs.book.manager.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.selfs.BookClassModel;
import com.androidlongs.book.mobel.common.HomeServlet;
import com.androidlongs.book.mobel.common.ResponseModel;

/**
 * Servlet implementation class AddBookClassServlet
 * 添加书籍管理分类
 */
@WebServlet("/manager/getbookclass")
public class GetBookClassServlet extends HomeServlet{

	
	@Override
	public void doRequest(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("获取书籍分类 ");
		
		
		List<BaseModel> queryAllBookClass = mBookClassServiceInterface.queryAllBookClass();
		List<BookClassModel> list = new ArrayList<BookClassModel>();
		for (int i = 0; i < queryAllBookClass.size(); i++) {
			list.add((BookClassModel)queryAllBookClass.get(i));
		}
		
		ResponseModel responseModel = new ResponseModel();
		responseModel.setCode("1000");
		responseModel.setMessage("添加成功");
		responseModel.setBookContentList(list);
		
		System.out.println(responseModel.toString());
		try {
			 JsonConfig config = new JsonConfig();
			     config.setExcludes(new String[]{"bBookClassSet"});//除去emps属性
			     String responseString = JSONArray.fromObject(list, config).toString();
			     String string = JSONObject.fromObject(responseModel, config).toString();
		//String responseString = JSONSerializer.toJSON(responseModel).toString();
			response.getWriter().write(string);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
}
