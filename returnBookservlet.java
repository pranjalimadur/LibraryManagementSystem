package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manipal.DAO.ReturnBookDAO2;
import com.manipal.DAO.jdbc.ReturnBookDAO2Impl;
import com.manipal.model.ReturnBook;
import com.manipal.service.ReturnBookService;
import com.manipal.service.impl.ReturnBookServiceImpl;

/**
 * Servlet implementation class returnBookservlet
 */
public class returnBookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public returnBookservlet() {
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
		int issueId=Integer.parseInt(request.getParameter("issueid"));
		System.out.println(issueId);
		ReturnBookServiceImpl rbsi=new ReturnBookServiceImpl();
		String str;
		
			long fine1=0;
			try {
				fine1 = rbsi.returnBook(issueId);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("in servlet :"+fine1);
			
		ReturnBook rbk=new ReturnBook(issueId, fine1);
		ReturnBookDAO2Impl rb2=new ReturnBookDAO2Impl();
		rb2.returnFine(rbk);
		
		HttpSession session=request.getSession();
		session.setAttribute("issueId",issueId);
		response.sendRedirect("Payment.jsp");
		
		
		
			
		
		
		
		
		
		
		
	}

}
