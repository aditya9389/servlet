package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		out.print("i am in doGet() method");
		System.out.println("i am in doget() method");
	}
}
