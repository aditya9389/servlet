<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="in.sp.backend.RedisUtil" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>

<%
	System.out.println("--in profile page now--");
    session = request.getSession(false);
	String name=null;
	System.out.println("--session we get from request-->"+session);
    if (session == null) {
    	System.out.println("--session we checked is null--");
        String sessionId = request.getRequestedSessionId();
        System.out.println("--taking sessionid from req-->"+sessionId);
        if (sessionId != null) {
        	System.out.println("--checked if it not null--");
             name= RedisUtil.getSession(sessionId);
             System.out.println("--took name from Redis on behalf of id-->"+name);
            if (name != null && !name.isEmpty()) {
            	System.out.println("--creating new session with same name--");
                session = request.getSession(); // Create new session in Java
                session.setAttribute("name",name);
            }
        }
    } 
    else {
    	String sessionId = request.getRequestedSessionId();
        System.out.println("--taking sessionid from req-->"+sessionId);
        if (sessionId != null) {
        	System.out.println("--checked if it not null--");
             name= RedisUtil.getSession(sessionId);
             System.out.println("--took name from Redis on behalf of id-->"+name);
             if (name != null && !name.isEmpty() && !name.equals((String)session.getAttribute("name_key")))
     		{
     	System.out.println("--putting name in session if as its not there--");
         session.setAttribute("name",name);
         }
        }
        name = (String) session.getAttribute("name_key");
    }
%>

<h1>Welcome : <%= name %></h1>
<a href="home.jsp">Home</a> &nbsp;&nbsp;
<a href="aboutUs.jsp">About Us</a> &nbsp;&nbsp;
<a href="Logout">Logout</a>

</body>
</html>
