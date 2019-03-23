package com.part01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet(value="/regist")
public class registServlet extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html;charset=utf-8");
		PrintWriter out=arg1.getWriter();//得到对客户端的输出流
		out.println("<h1>用户注册程序</h1>");
		String uname=arg0.getParameter("uname");
		out.println("uname");
		java.util.Map<java.lang.String,java.lang.String[]>
		all=arg0.getParameterMap();
		out.println("<h1>所有结果封装成map</h1>");
		out.println("<ul>");
		Iterator<String> it=all.keySet().iterator();
		while(it.hasNext())
		{
			String key=it.next();
			out.println("<li>"+key+"="+Arrays.toString(all.get(key))+"</li>");
		}
		out.println("</ul>");
		out.println("<h1>相同参数外所有值</h1>");
		String[] all1=arg0.getParameterValues("ah");
		out.println("<h1>"+Arrays.toString(all1)+"</h1>");
		out.println("<hr/>");
		out.println("<h2>"+arg0.getLocalAddr()+"</h2>");
		out.println("<h2>"+arg0.getLocalName()+"</h2>");
		out.println("<h2>"+arg0.getLocalPort()+"</h2>");
		out.println("<h2>-----------------------------</h2>");
		out.println("<h2>"+arg0.getRemoteAddr()+"</h2>");
		out.println("<h2>"+arg0.getRemoteHost()+"</h2>");
		out.println("<h2>"+arg0.getRemotePort()+"</h2>");
		
		out.close();
	}

}
