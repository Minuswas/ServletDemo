package com.part01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html;charset=utf-8");
		PrintWriter pw=arg1.getWriter();
		
		pw.println("<title>用户登录</title>");
		pw.println("<center>");
		pw.println("<h1>用户登录</h1>");
		pw.println("<form action='check' methed='post'>");
		pw.println("用户名：<input type='text' name='uname' /></br>");
		pw.println("密码：<input type='password' name='pswd' /></br>");
		pw.println("<input type='submit' value='登录' /></br>");
		pw.println("</form>");
		pw.println("</center>");
	}
	
}
