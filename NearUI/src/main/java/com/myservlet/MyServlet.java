package com.myservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, name = "MyServlet", urlPatterns = { "/myServlet" })
public class MyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		System.out.println("Name: "+name);
		response.getWriter().print("Hello, World! "+name);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		String name = request.getParameter("name");
		if (name == null)
			name = "World";
		request.setAttribute("user", name);
		request.getRequestDispatcher("response.jsp").forward(request, response);
	}
}
