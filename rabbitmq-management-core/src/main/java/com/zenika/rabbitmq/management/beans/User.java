package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;

/**
 * A rabbit-mq user
 *
 * @author Colin Hebert
 */
public class User implements Serializable {
	/**
	 * The name of the user
	 */
	private String username;

	/**
	 * The password the user uses to log in to the broker
	 */
	private String password;

	/**
	 * Administrator flag
	 */
	private Boolean admin;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		User user = (User) o;

		if (username != null ? !username.equals(user.username) :
				user.username != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return username != null ? username.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "User{username='" + username + "', password='" + password
				+ "', admin=" + admin + '}';
	}
}
