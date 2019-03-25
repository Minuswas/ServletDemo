package com.part01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value="/login",name="loggin")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html;charset=utf-8");
		PrintWriter pw=arg1.getWriter();
		
		pw.println("<title>用户登录</title>");
		pw.println("<center>");
		
		
		pw.println("<ul>");
		HttpSession hs=arg0.getSession();
		pw.println("<li>isNew:"+hs.isNew()+"</li>");
		pw.println("<li>getCreationTime:"+new Date(hs.getCreationTime())+"</li>");
		pw.println("<li>getLastAccessedTime:"+new Date(hs.getLastAccessedTime())+"</li>");
		pw.println("<li>getMaxInactiveInterval:"+hs.getMaxInactiveInterval()+"</li>");
		pw.println("</ul>");
		pw.println("<h1>用户登录</h1>");
		pw.println("<form action='check' methed='post'>");
		Cookie []all=arg0.getCookies();
		String ckvalue=null;
		if(all!=null&&all.length>0)
		{
			for(Cookie all1:all)
			{
				if("uname".equals(all1.getName()))
				{
					ckvalue=URLDecoder.decode(all1.getValue(),"gbk");
					break;
				}
			}
		}
		if(null!=ckvalue)
		pw.println("用户名：<input type='text' name='uname' value='"+ckvalue+"'/></br>");	
		else {
			pw.println("<h1>获取失败"+ckvalue+"<h1>");
			pw.println("用户名：<input type='text' name='uname' /></br>");
		}
		pw.println("密码：<input type='password' name='pswd' /></br>");
		pw.println("<input type='submit' value='登录' /></br>");
		pw.println("</form>");
		pw.println("</center>");
	}
	
}
