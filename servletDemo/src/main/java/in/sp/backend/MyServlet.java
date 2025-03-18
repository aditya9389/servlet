package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/aaa")
public class MyServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String myName=req.getParameter("name1");
		String myEmail=req.getParameter("email1");
		System.out.println("name= "+myName+" email= "+myEmail);
		PrintWriter out=res.getWriter();
		out.print("Name= "+myName);
		out.print("Email= "+myEmail);
		
	}
}
