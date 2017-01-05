package com.androidlongs.book.manager.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

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
@WebServlet("/manager/deletebookclass")
public class DeleteBookClassServlet extends HomeServlet{


	@Override
	public void doRequest(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("删除书籍分类 ");
		try {
			String id = request.getParameter("bookUuid");
			
			System.out.println("删除书籍分类 id "+id);

			ResponseModel responseModel = new ResponseModel();

			if (id!=null&&(!id.equals(""))) {

				id =URLDecoder.decode(id);
				System.out.println("删除书籍分类 id - "+id);
				mBookClassServiceInterface.deleteBookClassFromId(id);
				responseModel.setCode("1000");
				responseModel.setMessage("删除成功");
			}else {
				responseModel.setCode("1002");
				responseModel.setMessage("删除失败");
			}


			String responseString = JSONSerializer.toJSON(responseModel).toString();
			response.getWriter().write(responseString);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
