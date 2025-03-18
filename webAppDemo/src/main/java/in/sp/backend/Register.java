package in.sp.backend;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Register extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("i am in register service method");
	}
}
