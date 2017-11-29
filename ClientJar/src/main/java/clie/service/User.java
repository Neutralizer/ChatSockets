package clie.service;

//port is assumed to be the same
public class User {
	String userName;
	String ip;

	public User() {

	}

	public User(String name, String ip) {
		this.userName = name;
		this.ip = ip;
	}

	public String getUserName() {
		return userName;
	}

	public String getIp() {
		return ip;
	}

}
