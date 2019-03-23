package com.part01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet(value="/welcome" ,loadOnStartup=4)
public class WelcomeServlet extends GenericServlet {

	public WelcomeServlet() {
		System.out.println("WelcomeServlet构造器。。。。。。。");
	}
	
	@Override
	public void destroy() {
		System.out.println("WelcomeServlet    destory()方法");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("WelcomeServlet    init()方法。。。。。。。");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html;charset=gbk");
		PrintWriter out=arg1.getWriter();//得到对客户端的输出流
		out.println("<h1>WelcomeServlet程序</h1>");
		System.out.println("WelcomeServlet    service()方法。。。。。。。");
		out.close();
	}

}
