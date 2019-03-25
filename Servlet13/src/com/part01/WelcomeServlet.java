package com.part01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value="/welcome")
public class WelcomeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		
		HttpSession hs=req.getSession();
		if(hs.getAttribute("abc")==null)
		{
			resp.sendRedirect("login");
			return;
		}
		String name=null!=req.getParameter("uname")?req.getParameter("uname"):"";
		pw.println("<h1>Welcome"+URLDecoder.decode(name,"utf-8")+"!!!!!!!</h1>");
		pw.println("<center><a href='login'>·µ»Ø</a></center>");
		pw.println("<center><a href='logout'>ÍË³ö</a></center>");
	}
	
}
