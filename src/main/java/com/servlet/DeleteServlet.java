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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		ContactDao dao = new ContactDao(DbConnect.getConnection());
		boolean f = dao.deleteContact(id);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("succMsg", "Delete Sucessfully..");
			resp.sendRedirect("viewContact.jsp");
		} else {
			session.setAttribute("failed", "Something is wrong on server..");
			resp.sendRedirect("viewContact.jsp");
		}

	}

}
