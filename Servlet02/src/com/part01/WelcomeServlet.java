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
		System.out.println("WelcomeServlet��������������������");
	}
	
	@Override
	public void destroy() {
		System.out.println("WelcomeServlet    destory()����");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("WelcomeServlet    init()������������������");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html;charset=gbk");
		PrintWriter out=arg1.getWriter();//�õ��Կͻ��˵������
		out.println("<h1>WelcomeServlet����</h1>");
		System.out.println("WelcomeServlet    service()������������������");
		out.close();
	}

}
