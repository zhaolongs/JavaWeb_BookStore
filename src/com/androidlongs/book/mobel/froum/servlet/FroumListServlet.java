package com.androidlongs.book.mobel.froum.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

import com.androidlongs.book.base.BaseModel;
import com.androidlongs.book.common.model.friend.FroumModel;
import com.androidlongs.book.mobel.common.HomeServlet;
import com.androidlongs.book.mobel.common.ResponseModel;
import com.androidlongs.book.mobel.froum.service.FroumService;
import com.androidlongs.book.mobel.froum.service.FroumServiceImple;

/**
 * Servlet implementation class FroumServlet
 */
@WebServlet("/froum/list")
public class FroumListServlet extends HomeServlet {
	private static final long serialVersionUID = 1L;

	private FroumService mFroumService = new FroumServiceImple();
	@Override
	public void doRequest(HttpServletRequest request,
			HttpServletResponse response) {

		List<FroumModel> allFroumList = mFroumService.getAllFroumList();

		try {

			ResponseModel model = new ResponseModel();

			if (allFroumList==null) {
				model.setCode("1000");
				model.setMessage("无数据");
				String result = JSONSerializer.toJSON(model).toString();
				response.getWriter().write(result);
				return;
			} else {
				List<BaseModel> list = new ArrayList<BaseModel>();
				for (int i = 0; i < allFroumList.size(); i++) {
					list.add(allFroumList.get(i));
				}
				model.setCode("1000");
				model.setMessage("成功");
				model.setContentList(list);
				String result = JSONSerializer.toJSON(model).toString();
				response.getWriter().write(result);
				return;
			}



		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
