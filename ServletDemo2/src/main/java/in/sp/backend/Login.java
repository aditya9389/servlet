package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/myLogin")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String myEmail = req.getParameter("email1");
        String myPass = req.getParameter("password1");

        if (myEmail.equals("adii@123") && myPass.equals("adii")) {
            HttpSession session = req.getSession(); 
            session.setAttribute("name_key", "aditya");
            
            RedisUtil.saveSession(session.getId(), "aditya");
            RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
            rd.forward(req, resp);
        } else {
            resp.setContentType("text/html");
            out.print("<h1 style='color:red'>Email and password didn't match</h1>");
            RequestDispatcher rd = req.getRequestDispatcher("/index.html");
            rd.include(req, resp);
        }
    }
}
