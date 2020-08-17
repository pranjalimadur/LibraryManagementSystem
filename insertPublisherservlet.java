package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manipal.DAO.BookDAO;
import com.manipal.DAO.PublisherDAO;
import com.manipal.DAO.jdbc.JdbcPublisherDAOImpl;
import com.manipal.model.Publisher;
import com.manipal.service.impl.PublisherServiceImpl;

/**
 * Servlet implementation class insertBookservlet
 */
public class insertPublisherservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertPublisherservlet() {
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
		//String bid=(request.getParameter("bookId"));
		int publisherId=Integer.parseInt(request.getParameter("publisherid"));
		System.out.println(publisherId);
		String publisherName=request.getParameter("publishername");
		System.out.println(publisherName);
		int contact=Integer.parseInt(request.getParameter("contact"));
		String addr = request.getParameter("addr");
		System.out.println(addr);
		String emailId=request.getParameter("emailid");
		System.out.println(emailId);
		System.out.println("now Model package");
		
		//out.println(bid);
		Publisher publisher = new Publisher(publisherId, publisherName, contact, addr, emailId);
		System.out.println(publisher);
		/*JdbcPublisherDAOImpl pdao=new JdbcPublisherDAOImpl();
		try {
			String str =((PublisherDAO)pdao).insertPublisher(publisher);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		out.println(str);*/
		
		PublisherServiceImpl p1 = new PublisherServiceImpl();
		try {
			p1.insertPublisher(publisher);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpServletResponse res = (HttpServletResponse)response;
		res.sendRedirect("welcome.jsp");
	}

}
