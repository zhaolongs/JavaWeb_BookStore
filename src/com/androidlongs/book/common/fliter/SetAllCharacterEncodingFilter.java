package com.androidlongs.book.common.fliter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;


public class SetAllCharacterEncodingFilter  implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request;
		HttpServletResponse response;
		try{
			request = (HttpServletRequest)req;
			response = (HttpServletResponse)resp;
		}catch(Exception e){
			throw new RuntimeException("non-http request or response");
		}
		System.out.println("获取用户配置的参数");
		//获取用户配置的参数
		String encoding = filterConfig.getInitParameter("encoding");
		if(encoding==null)
			encoding = "UTF-8";//默认编码
	
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		//解决POST请求参数编码
		request.setCharacterEncoding("UTF-8");
		//更改响应字符流使用的编码
		response.setCharacterEncoding("UTF-8");
		//更改响应字符流使用的编码，还能告知浏览器用什么编码进行显示
		response.setContentType("text/html;charset="+"UTF-8");
		
		
		//GetHttpServletRequest getrequest = new GetHttpServletRequest(request);
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {

	}


}
class GetHttpServletRequest extends HttpServletRequestWrapper{
	public GetHttpServletRequest(HttpServletRequest request){
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(value==null)
			return value;
		//获取请求方式
		String method = super.getMethod();
		if("get".equalsIgnoreCase(method)){
			try {
				value = new String(value.getBytes("ISO-8859-1"),super.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}


}
