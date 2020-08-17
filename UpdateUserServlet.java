package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manipal.model.User;
import com.manipal.service.impl.ViewServiceImpl;
import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		int userId=Integer.parseInt(request.getParameter("uid"));
		
		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		Long contact=Long.parseLong(request.getParameter("contact"));
		
		
		String status=request.getParameter("status");
		
		System.out.println(userId+" "+" "+firstName+" "+lastName+" "+address+" "+email+" "+contact+" "+status);
		
		User user=new User(userId,firstName, lastName, address, email, contact, status);
		
		ViewServiceImpl vsi=new ViewServiceImpl();
		vsi.updateUser(user);
	
		HttpServletResponse res=(HttpServletResponse)response;
		res.sendRedirect("ViewUser.jsp");
		
	}

}
