package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Contact;
import com.entity.User;


public class ContactDao {
	private Connection con;

	public ContactDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean addContact(Contact c) {
		boolean f = false;
		try {

			String s = "insert into contact2(name,emailid,contact,about) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(s);

			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhon());
			ps.setString(4, c.getAbout());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return f;
	}

	public List<Contact> getContact() {
		List<Contact> li = new ArrayList<Contact>();
		Contact c = null;
		try {
			String s = "select * from Contact2";
			PreparedStatement ps = con.prepareStatement(s);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhon(rs.getString(4));
				c.setAbout(rs.getString(5));
				li.add(c);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return li;

	}
	
	public Contact getContactById(int id) {
		
		Contact c = null;
		try {
			String s = "select * from Contact2 where id=?";
			PreparedStatement ps = con.prepareStatement(s);
            ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhon(rs.getString(4));
				c.setAbout(rs.getString(5));
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return c;

	}
	
	public boolean updateContact(Contact c) {
		boolean f = false;
		try {

			String s = "update contact2 set name=?,emailid=?,contact=?,about=? where id=?";
			PreparedStatement ps = con.prepareStatement(s);

			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhon());
			ps.setString(4, c.getAbout());
			ps.setInt(5, c.getId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return f;
	}
	
	public boolean deleteContact(int id) {
		boolean f=false;
		try {
			String sql="delete from contact2 where id=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i=ps.executeUpdate();
			
			if (i == 1) {
				f = true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return f;
	}
}
