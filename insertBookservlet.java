package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manipal.DAO.BookDAO;
import com.manipal.DAO.jdbc.JdbcBookDAOImpl;
import com.manipal.model.Book;

/**
 * Servlet implementation class insertBookservlet
 */
public class insertBookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertBookservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//String bid=(request.getParameter("bookId"));
		int bookId=Integer.parseInt(request.getParameter("bid"));
		System.out.println(bookId);
		String bookName=request.getParameter("bname");
		System.out.println(bookName);
		int authorId=Integer.parseInt(request.getParameter("authorid"));
		System.out.println(authorId);
		int publisherId=Integer.parseInt(request.getParameter("publisherid"));
		double edition = Double.parseDouble(request.getParameter("edition"));
		int noofcopies = Integer.parseInt(request.getParameter("noofcopies"));
		String category = request.getParameter("category");
		System.out.println("now Model package");
		
		//out.println(bid);
		Book book = new Book(bookId,bookName,authorId,publisherId,edition,noofcopies,category);
		System.out.println(book);
		JdbcBookDAOImpl bdao=new JdbcBookDAOImpl();
		try {
			String str =((BookDAO)bdao).insertBook(book);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpServletResponse res = (HttpServletResponse)response;
		res.sendRedirect("view.jsp");
		
		
		
		 
		
		
		
		
		
		
		
		
		
	}

}
