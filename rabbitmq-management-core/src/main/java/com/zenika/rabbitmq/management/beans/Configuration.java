package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Broker configuration
 *
 * @author Colin Hebert
 */
public class Configuration implements Serializable {
	/**
	 * Current Rabbit-MQ version
	 */
	private String version;

	/**
	 * Users available on the broker
	 */
	private List<User> users;

	/**
	 * Existing virtual hosts
	 */
	private List<VHost> vHosts;

	/**
	 * Granted permissions
	 */
	private List<Permission> permissions;

	/**
	 * Existing queues
	 */
	private List<Queue> queues;

	/**
	 * Existing exchanges
	 */
	private List<Exchange> exchanges;

	/**
	 * Existing bindings
	 */
	private List<Binding> bindings;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<VHost> getvHosts() {
		return vHosts;
	}

	public void setvHosts(List<VHost> vHosts) {
		this.vHosts = vHosts;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<Queue> getQueues() {
		return queues;
	}

	public void setQueues(List<Queue> queues) {
		this.queues = queues;
	}

	public List<Exchange> getExchanges() {
		return exchanges;
	}

	public void setExchanges(List<Exchange> exchanges) {
		this.exchanges = exchanges;
	}

	public List<Binding> getBindings() {
		return bindings;
	}

	public void setBindings(List<Binding> bindings) {
		this.bindings = bindings;
	}
}
