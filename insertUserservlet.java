package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manipal.DAO.UserDAO;
import com.manipal.DAO.jdbc.JdbcBookDAOImpl;
import com.manipal.DAO.jdbc.JdbcUserDAOImpl;
import com.manipal.model.User;

/**
 * Servlet implementation class insertUserservlet
 */
//@WebServlet("/insertUserservlet")
public class insertUserservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertUserservlet() {
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
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");
		int userId=Integer.parseInt(request.getParameter("uid"));
		int departmentId=Integer.parseInt(request.getParameter("deptid"));
		String emailId=request.getParameter("emailid");
		long contact=Long.parseLong(request.getParameter("contact"));
		String address=request.getParameter("addr");
		String password=request.getParameter("passwd");
		int roleId=Integer.parseInt(request.getParameter("roleid"));
		
		User user =new User(userId, roleId, firstName, lastName, address, emailId, contact, departmentId, password);
		JdbcUserDAOImpl jdao=new JdbcUserDAOImpl();
		try {
			String str= ((UserDAO) jdao).insertUser(user);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		HttpServletResponse res = (HttpServletResponse)response;
		res.sendRedirect("ViewUser.jsp");

		
	}

}
