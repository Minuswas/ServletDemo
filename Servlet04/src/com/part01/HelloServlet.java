package com.part01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet(value="/hello")
public class HelloServlet extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html;charset=gbk");
		PrintWriter out=arg1.getWriter();//得到对客户端的输出流
		String uname=null!=arg0.getParameter("uname")?arg0.getParameter("uname"):"";
		out.println("<h1>Welcome"+uname+"</h1>");
		out.close();
	}

}
