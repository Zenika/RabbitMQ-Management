package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;

/**
 * Virtual host on the broker
 *
 * @author Colin Hebert
 */
public class VHost implements Serializable {
	/**
	 * Virtual host name
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		VHost vHost = (VHost) o;

		if (name != null ? !name.equals(vHost.name) : vHost.name != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "VHost{name='" + name + "'}";
	}
}
