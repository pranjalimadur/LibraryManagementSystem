package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manipal.service.UserLoginService;
import com.manipal.service.impl.UserLoginServiceImpl;

/**
 * Servlet implementation class UserLoginServlet
 */

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		PrintWriter out=response.getWriter();
		
		int username=Integer.parseInt(request.getParameter("userid"));
		String password=request.getParameter("password");
		try {
			UserLoginService loginuserservice=new UserLoginServiceImpl();
			
			boolean flag;
			HttpSession session=request.getSession();
			flag=loginuserservice.checkStaffLogin(username, password);
			if(flag){
				session.setAttribute("username", username);
				session.setAttribute("msg", "Login Successful!");
				System.out.println("success login");
				response.sendRedirect("welUser.jsp");
			}else{
				session.setAttribute("msg", "Invalid Login Credentials!");
				System.out.println("Login failed");
				response.sendRedirect("userlogin.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		


	}


