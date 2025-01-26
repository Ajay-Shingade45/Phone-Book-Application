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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String about=req.getParameter("about");
		int id=Integer.parseInt(req.getParameter("id"));
		
		Contact c=new Contact(id,name, email, phone, about);
		ContactDao dao=new ContactDao(DbConnect.getConnection());
		
		HttpSession session=req.getSession();
		
		boolean f=dao.updateContact(c);
		
		if(f) {
			session.setAttribute("succMsg", "Update Sucessfully..");
			resp.sendRedirect("viewContact.jsp");
		}else {
			session.setAttribute("failed", "Something is wrong on server..");
			resp.sendRedirect("viewContact.jsp");
		}
	
	}
         
}
