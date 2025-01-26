package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DbConnect;
import com.dao.UserDao;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		User u=new User(name,email,password);
		
		UserDao dao=new UserDao(DbConnect.getConnection());
		boolean f=dao.userRegister(u);
		
		HttpSession session=req.getSession();
		if(f)
		{
			session.setAttribute("succMsg", "Your Register sucessfully...");
			resp.sendRedirect("register.jsp");
		}
		else
		{
			session.setAttribute("failed", "Something is wrong on server....");
			resp.sendRedirect("register.jsp");
		}
		
	}
       
}
