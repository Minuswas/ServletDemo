package com.part01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/check")
public class CheckLoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		
		String uname=null!=req.getParameter("uname")?req.getParameter("uname"):"";
		String pswd=null!=req.getParameter("pswd")?req.getParameter("pswd"):"";
		System.out.println(uname+"----------"+pswd);
		if("张三".equals(uname)&&"123".equals(pswd))
		{
			//resp.sendRedirect("welcome?name="+URLEncoder.encode(URLEncoder.encode(uname,"utf-8"),"utf-8"));
			RequestDispatcher re= req.getRequestDispatcher("welcome");
			re.forward(req, resp);
		}
		else
		{
			pw.println("<h1>CheckLoginServlet开始.........<h1>");
			//resp.sendRedirect("login");
			RequestDispatcher re=req.getRequestDispatcher("login");
			re.include(req, resp);
			pw.println("<h1>CheckLoginServlet结束.........<h1>");
		}
	}
	
}
