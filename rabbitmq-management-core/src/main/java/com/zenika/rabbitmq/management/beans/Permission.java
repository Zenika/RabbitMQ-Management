package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;

/**
 * Permission granted to one user on a specific virtual host
 *
 * @author Colin Hebert
 */
public class Permission implements Serializable {

	/**
	 * The name of the user
	 */
	private String user;

	/**
	 * The name of the virtual host on which the permissions are granted
	 */
	private String vHost;

	/**
	 * Regular expression matching resource names for which the user is granted
	 * configure permissions
	 */
	private String configure;

	/**
	 * Regular expression matching resource names for which the user is granted
	 * write permissions
	 */
	private String write;

	/**
	 * Regular expression matching resource names for which the user is granted
	 * read permissions
	 */
	private String read;

	/**
	 * Scope of the permissions
	 * <p/>
	 * This determines when permissions are checked
	 */
	private Scope scope;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getvHost() {
		return vHost;
	}

	public void setvHost(String vHost) {
		this.vHost = vHost;
	}

	public String getConfigure() {
		return configure;
	}

	public void setConfigure(String configure) {
		this.configure = configure;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public Scope getScope() {
		return scope;
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Permission that = (Permission) o;

		if (configure != null ? !configure.equals(that.configure) :
				that.configure != null)
			return false;
		if (read != null ? !read.equals(that.read) : that.read != null)
			return false;
		if (scope != that.scope)
			return false;
		if (user != null ? !user.equals(that.user) : that.user != null)
			return false;
		if (vHost != null ? !vHost.equals(that.vHost) : that.vHost != null)
			return false;
		if (write != null ? !write.equals(that.write) : that.write != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = user != null ? user.hashCode() : 0;
		result = 31 * result + (vHost != null ? vHost.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Permission{user='" + user + "', vHost='" + vHost
				+ "', configure='" + configure + "', write='" + write
				+ "', read='" + read + "', scope='" + scope + "'}";
	}

	/**
	 * Scope of the permissions
	 */
	public static enum Scope {
		/**
		 * Server-generated resource names
		 */
		all,
		/**
		 * Only for client-specified resource names
		 */
		client
	}

}
