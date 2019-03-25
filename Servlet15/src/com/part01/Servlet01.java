package com.part01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value="/servlet01")
public class Servlet01 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html;charset=gbk");
		PrintWriter pw=arg1.getWriter();
		
		ServletContext sc=arg0.getServletContext();
		Integer counter=(Integer)sc.getAttribute("counter");
		if(counter==null)
		{
			counter=1;
		}
		pw.println("<center><h1>该页面总共被访问了"+counter+"次!<h1></center>");
		counter++;
		sc.setAttribute("counter", counter);
		
		
		
		HttpSession hs=arg0.getSession();
		Integer counter1=(Integer)hs.getAttribute("counter1");
		Cookie cookie=new Cookie("name1", URLEncoder.encode("name1","gbk"));
		cookie.setMaxAge(60*60*24*7);
		arg1.addCookie(cookie);
		Cookie []all=arg0.getCookies();
		String ckvalue=null;
		if(all!=null&&all.length>0)
		{
			for(Cookie all1:all)
			{
				if("name1".equals(all1.getName()))
				{
					ckvalue=URLDecoder.decode(all1.getValue(),"gbk");
					break;
				}
			}
		}
		if(counter1==null&&ckvalue==null)
		{
			counter1=1;
		}
		pw.println("<center><h1>该页面被你访问了"+counter1+"次!<h1></center>");
		counter1++;
		sc.setAttribute("counter1", counter1);
	}
	
}
