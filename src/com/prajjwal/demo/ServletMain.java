package com.prajjwal.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.ServletModule;

/**
 * Servlet implementation class ServletMain
 */
@WebServlet("/ServletMain")
public class ServletMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Injector injector = Guice.createInjector(new ServletModule());
		Injector injector = Guice.createInjector(new DbModule());
	    InstructorDao instructorDao = injector.getInstance(InstructorDao.class);  
	    
	    
	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String email = request.getParameter("email");

	    Instructor instructor = new Instructor(firstName, lastName, email);
	    
	    InstructorDetail instructorDetail = new InstructorDetail("one two three four","four three two one");
	    
	    instructor.setInstructorDetail(instructorDetail);
	    
	    instructorDao.save(instructor);
	    
//	    response.sendRedirect("SecureServletLogin");
	    
	    PrintWriter out = response.getWriter();
	    out.println("instructor saved into database"+"\n"+instructor);
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
