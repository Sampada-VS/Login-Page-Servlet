package com.blz.firstservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebInitParam;

@WebServlet(
		description="Login Servlet Testing",
		urlPatterns= {"/LoginController"},
		initParams= {
				@WebInitParam(name="password",value="hello")
		}
)

public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un = request.getParameter("userName");
		String pw = request.getParameter("userPassword");
		
		String nameRegex="^[A-Z][a-z]{2,}$";
		String password=getServletConfig().getInitParameter("password");
		
		if (un.matches(nameRegex) && pw.equals(password)) {
			request.setAttribute("user", un);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
		} else {
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out=response.getWriter();
			out.println("<font color=red>Either username or password is wrong.</font>");
						rd.include(request, response);
        }
	}
}
