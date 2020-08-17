package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manipal.model.Book;
import com.manipal.service.impl.ViewServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		int bookId=Integer.parseInt(request.getParameter("bid"));
	
		String bookName=request.getParameter("bname");
	
		int authorId=Integer.parseInt(request.getParameter("authorid"));
	
		int publisherId=Integer.parseInt(request.getParameter("publisherid"));
		double edition = Double.parseDouble(request.getParameter("edition"));
		int noofcopies = Integer.parseInt(request.getParameter("noofcopies"));
		String category = request.getParameter("category");
		
		String status= request.getParameter("status");
		
		Book book=new Book(bookId, bookName, authorId, publisherId, edition, noofcopies, category , status);
		
		ViewServiceImpl vsi=new ViewServiceImpl();
		vsi.updateBook(book);
		out.println("Data updated");
		

		HttpServletResponse res = (HttpServletResponse)response;
		res.sendRedirect("view.jsp");
		
		
	}

}
