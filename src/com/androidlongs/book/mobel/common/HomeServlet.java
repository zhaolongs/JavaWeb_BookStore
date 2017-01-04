package com.androidlongs.book.mobel.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.androidlongs.book.manager.service.BookClassServiceInterface;
import com.androidlongs.book.manager.service.imple.BookClassService;


/**
 * Servlet implementation class HomeServlet
 */
public abstract class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public HomeService  mHomeService = new HomeServiceImple();
	public BookClassServiceInterface mBookClassServiceInterface = new BookClassService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public abstract void doRequest(HttpServletRequest request, HttpServletResponse response);

}
