package com.androidlongs.book.mobel.login.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

import com.androidlongs.book.common.model.user.UserModel;
import com.androidlongs.book.mobel.common.HomeServlet;
import com.androidlongs.book.mobel.common.ResponseModel;

/**
 * Servlet implementation class RegisterServlete
 */
@WebServlet("/moble/regiseter")
public class RegisterServlete extends HomeServlet {

	@Override
	public void doRequest(HttpServletRequest request,
			HttpServletResponse response) {

		try {

			System.out.println("注册请求 ");


			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String sex = request.getParameter("sex");

			ResponseModel responseModel = new ResponseModel();


			if (userName==null||userName.equals("")) {
				responseModel.setCode("1001");
				responseModel.setMessage("用户名为空");
				String result = JSONSerializer.toJSON(responseModel).toString();
				response.getWriter().write(result);
				return;
			}

			if (password==null||password.equals("")) {
				responseModel.setCode("1001");
				responseModel.setMessage("密码为空");
				String result = JSONSerializer.toJSON(responseModel).toString();
				response.getWriter().write(result);
				return;
			}

			if (sex==null||sex.equals("")) {
				sex = "男";
			}

			UserModel userModel = new UserModel();
			userModel.setUname(userName);
			userModel.setUpassword(password);
			userModel.setUsex(sex);

			UserModel regist = mHomeService.regist(userModel);

			responseModel.setCode("1000");
			responseModel.setMessage("成功");
			responseModel.setContent(regist);
			String result = JSONSerializer.toJSON(responseModel).toString();
			response.getWriter().write(result);



		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
