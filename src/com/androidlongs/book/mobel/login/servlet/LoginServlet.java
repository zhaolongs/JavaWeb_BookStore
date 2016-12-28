package com.androidlongs.book.mobel.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

import com.androidlongs.book.common.model.user.UserModel;
import com.androidlongs.book.mobel.common.HomeServlet;
import com.androidlongs.book.mobel.common.ResponseModel;




@WebServlet("/moble/login")
public class LoginServlet extends HomeServlet {

	@Override
	public void doRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("login request ");

		try {

			String method = request.getMethod();
			System.out.println("访问 "+method);
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");

			String code="1000";
			String message = "";
			ResponseModel moResponseModel = new ResponseModel();
			UserModel userModel;

			if (userName==null||userName.equals("")) {
				System.out.println("用户名为null ");
				code ="1001";
				message = "用户名为null";
			}else if (password==null||password.equals("")) {
				System.out.println("密码为null ");
				code ="1001";
				message = "密码为null";
			}else {
				System.out.println("用户名为  "+userName);
				userModel = mHomeService.login(userName);

				if (userModel==null) {
					code ="1001";
					message = "用户不存";
				} else {
					if (!userModel.getUpassword().equals(password)) {
						code ="1001";
						message = "密码不正确";
					} else {
						moResponseModel.setContent(userModel);
					}
				}
			}

			moResponseModel.setCode(code);
			moResponseModel.setMessage(message);

			String result = JSONSerializer.toJSON(moResponseModel).toString();
			System.out.println(result);
			response.getWriter().write(result);

		} catch (Exception e) {

			System.out.println("exception "+e.getMessage());
		}
	}
}


