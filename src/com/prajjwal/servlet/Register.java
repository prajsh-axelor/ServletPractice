package com.prajjwal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("country");
		String country = request.getParameter("country");
		String[] languages = request.getParameterValues("languages");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<div>");
		out.println("<p>User name : "+username+"</p>");
		out.println("<p>Password : "+passwd+"</p>");
		out.println("<p>gender : "+gender+"</p>");
		out.println("<p>Hobbies : </p>");
		for(String s : hobbies)
			out.println(s);
		out.println("<p>Country : "+country+"</p>");
		for(String s : languages)
			out.println(s);
		
		
		
//		System.out.println(username +" "+ passwd+" "+gender+" "+hobbies+" "+country+" "+languages);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		doGet(request, response);
		
		
	}

}
