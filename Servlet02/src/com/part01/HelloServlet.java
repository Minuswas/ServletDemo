package com.part01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {

	public HelloServlet() {
		System.out.println("HelloServlet  构造方法。。。。。。。");
	}
	
	
	@Override
	public void destroy() {
		System.out.println("HelloServlet  destory()方法。。。。。。。");
	}


	@Override
	public void init() throws ServletException {
		System.out.println("HelloServlet  init()方法。。。。。。。");
	}


	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html;charset=gbk");
		PrintWriter out=arg1.getWriter();//得到对客户端的输出流
		out.println("<h1>第一个Servlet程序</h1>");
		System.out.println("HelloServlet  service()方法。。。。。。。");
		out.close();
	}

}
