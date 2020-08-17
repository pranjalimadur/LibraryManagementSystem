package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		

		HttpSession session = request.getSession();
		PrintWriter pw=response.getWriter();

		
			if ((username.equals("admin") && password.equals("admin"))
					|| (username.equals("atosadmin") && password.equals("atosadmin")))
			{	
		
				session.setAttribute("username", "message");
				RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
				rd.forward(request, response);
			
			}
			else{
				String Message="This is Unauthorized User";
				RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
				
				rd.include(request, response);
			}
			
			
		}


	}
