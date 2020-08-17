package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manipal.model.Bookissue;
import com.manipal.service.impl.BookissueserviceImpl;

/**
 * Servlet implementation class IssueBookservlet
 */
public class IssueBookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueBookservlet() {
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
		int userId=Integer.parseInt(request.getParameter("uid"));
		int bookId=Integer.parseInt(request.getParameter("bid"));
		String issueDate=request.getParameter("idate");
		
		String returnDate=request.getParameter("rdate");
		out.println(userId);
		
		out.println(bookId);
		
	out.println(issueDate);
		
		Bookissue bi=new Bookissue(userId, bookId, issueDate, returnDate);
		 
		BookissueserviceImpl bs=new BookissueserviceImpl();
		bs.issuebook(bi);
		
		HttpServletResponse res = (HttpServletResponse)response;
		res.sendRedirect("viewIssueBook.jsp");
		
	}

}
