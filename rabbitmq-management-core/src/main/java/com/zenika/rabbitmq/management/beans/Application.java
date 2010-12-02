package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;

/**
 * Application running on the Erlang VM
 *
 * @author Colin Hebert
 */
public class Application implements Serializable {
	/**
	 * Application's name
	 */
	private String name;

	/**
	 * Application's description
	 */
	private String description;

	/**
	 * Application's version
	 */
	private String version;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Application that = (Application) o;

		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (version != null ? !version.equals(that.version) :
				that.version != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Application{name='" + name + "', description='" + description
				+ "', version='" + version + "'}";
	}
}
