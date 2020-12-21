package com.blz.firstservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		description="Login Servlet Testing",
		urlPatterns= {"/LoginController"}
)

public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		String userpwd = request.getParameter("userPassword");
		
			
		if (Validate.checkValidation(username,userpwd)){
			request.setAttribute("user", username);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
		} else {
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out=response.getWriter();
			out.println("<font color=red>Either username or password is wrong.</font>");
			rd.include(request, response);
		}
	}
}
