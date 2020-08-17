package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manipal.model.Author;
import com.manipal.service.impl.AuthorServiceImpl;

/**
 * Servlet implementation class InsertAuthorServlet
 */
public class insertAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertAuthorServlet() {
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
		int authorId = Integer.parseInt(request.getParameter("aid"));
		String authorName=request.getParameter("aname");
		String description = request.getParameter("desc");
		
		Author author = new Author(authorId,authorName,description);
		
		System.out.println(author);
		
		AuthorServiceImpl a1 = new AuthorServiceImpl();
		a1.insertAuthor(author);
		HttpServletResponse res = (HttpServletResponse)response;
		res.sendRedirect("welcome.jsp");
	}

}
