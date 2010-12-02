package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;
import java.util.Map;

/**
 * Exchanges
 *
 * @author Colin Hebert
 */
public class Exchange implements Serializable {
	/**
	 * The name of the exchange
	 */
	private String name;

	/**
	 * Virtual host name
	 */
	private String vHost;

	/**
	 * The exchange type
	 */
	private String type;

	/**
	 * Whether the exchange will be deleted automatically when no longer used
	 */
	private Boolean autoDelete;

	/**
	 * Whether or not the exchange survives server restarts
	 */
	private Boolean durable;

	/**
	 * Exchange arguments
	 */
	private Map<String, String> arguments;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getvHost() {
		return vHost;
	}

	public void setvHost(String vHost) {
		this.vHost = vHost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean isAutoDelete() {
		return autoDelete;
	}

	public void setAutoDelete(Boolean autoDelete) {
		this.autoDelete = autoDelete;
	}

	public Boolean isDurable() {
		return durable;
	}

	public void setDurable(Boolean durable) {
		this.durable = durable;
	}

	public Map<String, String> getArguments() {
		return arguments;
	}

	public void setArguments(Map<String, String> arguments) {
		this.arguments = arguments;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Exchange exchange = (Exchange) o;

		if (name != null ? !name.equals(exchange.name) : exchange.name != null)
			return false;
		if (vHost != null ? !vHost.equals(exchange.vHost) :
				exchange.vHost != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Exchange{name='" + name + "', vHost='" + vHost + "', type='"
				+ type + '\'' + ", autoDelete=" + autoDelete + ", durable="
				+ durable + '}';
	}
}

