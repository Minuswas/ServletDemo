package com.part01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html;charset=gbk");
		PrintWriter out=arg1.getWriter();//�õ��Կͻ��˵������
		
		out.println("<h1>��һ��Servlet����</h1>");
		out.close();
	}

}
