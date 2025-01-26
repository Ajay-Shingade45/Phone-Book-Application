package com.entity;

public class Contact {
	private int id;
	private String name, email, phon, about;
	

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(String name, String email, String phon, String about) {
		super();
		this.name = name;
		this.email = email;
		this.phon = phon;
		this.about = about;
	}

	
	public Contact(int id, String name, String email, String phon, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phon = phon;
		this.about = about;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhon() {
		return phon;
	}

	public void setPhon(String phon) {
		this.phon = phon;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	

}
