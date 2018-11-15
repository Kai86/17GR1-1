package com.test.encity;

public class User {
	
	private String name;
	private String pwd;
	public User() {
		super();
	}
	private int age;
	private String eminl;
	
	public String getEminl() {
		return eminl;
	}
	public void setEminl(String eminl) {
		this.eminl = eminl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public User(String eminl) {
		super();
		this.eminl = eminl;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
