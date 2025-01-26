package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.entity.User;

public class UserDao {
	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean userRegister(User u) {
		boolean f = false;
		try {
			
			String s = "insert into user(name,emailid,password) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(s);
			
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());

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
}
