package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DbConnect;
import com.dao.ContactDao;
import com.entity.Contact;

@WebServlet("/addContact")
public class ContectServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String about=req.getParameter("about");
		
		Contact c=new Contact(name, email, phone, about);
		ContactDao dao=new ContactDao(DbConnect.getConnection());
		
		HttpSession session=req.getSession();
		boolean f=dao.addContact(c);
		
		if(f) {
			session.setAttribute("succMsg", "Your Contact Saved..");
			resp.sendRedirect("viewContact.jsp");
		}else {
			session.setAttribute("failed", "Something is wrong on server..");
			resp.sendRedirect("viewContact.jsp");
		}
	}
	
}
