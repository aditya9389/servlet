package in.dp.backend;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/googleSearch")
public class Login extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		String mySearch=req.getParameter("search1");
		resp.sendRedirect("http://www.google.com/search?q=" + mySearch);
	}
	
}
