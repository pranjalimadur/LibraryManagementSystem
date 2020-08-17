package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manipal.model.RemoveUser;
import com.manipal.service.impl.RemoveUserServiceImpl;

/**
 * Servlet implementation class removeUserservlet
 */
public class removeUserservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeUserservlet() {
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
		PrintWriter out= response.getWriter();
		
		int userId=Integer.parseInt(request.getParameter("userid"));
		String userName=request.getParameter("username");
	//	int roleId = Integer.parseInt(request.getParameter("roleid"));
	/*	RemoveUser rmu=new RemoveUser(userId, userName, roleId);*/
		
		/*RemoveUser remuser=new RemoveUser(userId,userName,roleId);
		System.out.println(remuser);*/
		RemoveUserServiceImpl r1 = new RemoveUserServiceImpl();
		String str=r1.removeUser(userId);
		System.out.println("string is "+str);
		
		if(str.equals("unsuccess"))
				{
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendRedirect("RemoveUser.jsp");
				}
		else
		{
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendRedirect("welcome.jsp");
			
		}
		
		
 		
		
		
	}

}
