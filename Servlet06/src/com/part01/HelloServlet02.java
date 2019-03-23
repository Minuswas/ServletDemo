package com.part01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/hello02")
public class HelloServlet02 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();//得到对客户端的输出流
		req.setCharacterEncoding("utf-8");
		Enumeration<String> sname=req.getHeaderNames();
		out.println("<ul>");
		while(sname.hasMoreElements())
		{
			String name=sname.nextElement();
			String value=req.getHeader(name);
			out.println("<li>"+value+"</li>");
		}
		out.println("</ul>");
		out.println("getQueryString"+req.getQueryString());
		out.println("getRequestURI"+req.getRequestURI());
		out.println("getRequestURL"+req.getRequestURL());
		
	}
	
}
