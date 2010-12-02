package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;
import java.util.Map;

/**
 * Binding between an exchange and a queue or another exchange
 *
 * @author Colin Hebert
 */
public class Binding implements Serializable {
	/**
	 * Name of the binding, defined by its routing key and arguments, also known as props
	 */
	/**
	 * Virtual host name
	 */
	private String vHost;

	/**
	 * The name of the source of messages to which the binding is attached
	 */
	private String source;

	/**
	 * The name of the destination of messages to which the binding is attached
	 */
	private String destination;

	/**
	 * The kind of the destination of messages to which the binding is attached
	 */
	private DestinationType destinationType;

	/**
	 * The binding's routing key also know as props
	 */
	private String routingKey;

	/**
	 * The binding's arguments
	 */
	private Map<String, String> arguments;

	public String getvHost() {
		return vHost;
	}

	public void setvHost(String vHost) {
		this.vHost = vHost;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public DestinationType getDestinationType() {
		return destinationType;
	}

	public void setDestinationType(DestinationType destinationType) {
		this.destinationType = destinationType;
	}

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
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

		Binding binding = (Binding) o;

		if (vHost != null ? !vHost.equals(binding.vHost) :
				binding.vHost != null)
			return false;
		if (source != null ? !source.equals(binding.source) :
				binding.source != null)
			return false;
		if (destination != null ? !destination.equals(binding.destination) :
				binding.destination != null)
			return false;
		if (destinationType != binding.destinationType)
			return false;
		if (routingKey != null ? !routingKey.equals(binding.routingKey) :
				binding.routingKey != null)
			return false;
		if (arguments != null ? !arguments.equals(binding.arguments) :
				binding.arguments != null)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int result = source != null ? source.hashCode() : 0;
		result = 31 * result + (destination != null ? destination.hashCode() :
				0);
		return result;
	}

	@Override
	public String toString() {
		return "Binding{vHost='" + vHost + "', source='" + source
				+ "', destination='" + destination + "', destinationType='"
				+ destinationType + "', routingKey='" + routingKey
				+ "', arguments=" + arguments + '}';
	}

	public static enum DestinationType {
		exchange('e'),
		queue('q');

		private final char code;

		private DestinationType(char code) {
			this.code = code;
		}

		public char getCode() {
			return code;
		}
	}
}
