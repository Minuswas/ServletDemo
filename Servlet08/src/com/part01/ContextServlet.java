package com.part01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(value= {"/counter"},initParams={@WebInitParam(name="op",value="abc")})
public class ContextServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html");
		PrintWriter pw=arg1.getWriter();
		pw.println("<meta charset=\"UTF-8\">");
		ServletContext sc=this.getServletContext();
		//ServletConfig sc=this.getServletConfig();
		pw.println("<h1>CountextServlet:</h1>");
		pw.println("<h1>getContextPath:"+sc.getContextPath()+"</h1>");
		java.util.Enumeration<java.lang.String> all=sc.getInitParameterNames();
		while(all.hasMoreElements())
		{
			String all1=all.nextElement();
			pw.println("<h1>"+all1+":---->"+sc.getInitParameter(all1)+"<h1>");
		}
		//pw.println("<h1>getInitParameterNames:"+sc.getInitParameterNames()+"</h1>");
		pw.println("<h1>getInitParameter--:"+sc.getInitParameter("en")+"</h1>");
		pw.println("<h1>getMimeType:"+sc.getMimeType("./img/aaa.jpg")+"<h1>");
		pw.println("<h1>getMimeType:"+sc.getMimeType("./img/bbb.jpg")+"<h1>");
		pw.println("<h1>getMimeType:"+sc.getMimeType("./img/ccc.txt")+"<h1>");
		pw.println("<h1>getRealPath:"+sc.getRealPath("/img")+"</h1>");
	}
	
}
