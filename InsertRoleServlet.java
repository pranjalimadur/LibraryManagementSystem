package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manipal.DAO.jdbc.JdbcRoleDAOimpl;
import com.manipal.model.Role;
import com.manipal.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class InsertRoleServlet
 */
public class InsertRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertRoleServlet() {
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
		int roleId=Integer.parseInt(request.getParameter("roleid"));
		String roleName=request.getParameter("rolename");
		System.out.println("now model package");
		Role role = new Role(roleId,roleName);
		System.out.println(role);
		//JdbcRoleDAOimpl rdao=new JdbcRoleDAOimpl();
		//rdao.insertRole(role);
		RoleServiceImpl r1 = new RoleServiceImpl();
		r1.insertRole(role);
		
		HttpServletResponse res = (HttpServletResponse)response;
		res.sendRedirect("welcome.jsp");
	}
	
}
