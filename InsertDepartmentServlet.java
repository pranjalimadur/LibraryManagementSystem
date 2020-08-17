package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manipal.DAO.BookDAO;
import com.manipal.DAO.DepartmentDAO;
import com.manipal.DAO.jdbc.JdbcDepartmentDAOImpl;
import com.manipal.model.Department;
import com.manipal.service.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class InsertDepartmentServlet
 */
public class InsertDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDepartmentServlet() {
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
		int deptId=Integer.parseInt(request.getParameter("deptid"));
		System.out.println(deptId);
		String deptName=request.getParameter("deptname");
		System.out.println(deptName);
		
		System.out.println("now model package");
		
		Department department = new Department(deptId,deptName);
		System.out.println(department);
		//JdbcDepartmentDAOImpl ddao=new JdbcDepartmentDAOImpl();
		//ddao.insertDepartment(department);
		DepartmentServiceImpl b2 = new DepartmentServiceImpl();
		b2.insertDepartment(department);
		HttpServletResponse res = (HttpServletResponse)response;
		res.sendRedirect("welcome.jsp");
		
	}

}
