package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.VHost;

/**
 * Binding management
 *
 * @author Colin Hebert
 */
public interface BindingService {
	/**
	 * Get all bindings from the broker
	 *
	 * @return the complete list of bindings on the server
	 */
	List<Binding> getBindings();

	/**
	 * @param vHostName
	 * @return
	 * @see #getBindings(VHost)
	 */
	List<Binding> getBindings(String vHostName);

	/**
	 * Get bindings of a specific vHost
	 *
	 * @param vHost VirtualHost
	 * @return the binding list
	 */
	List<Binding> getBindings(VHost vHost);

	/**
	 * @param vHostName
	 * @param source
	 * @param destinationType
	 * @param destination
	 * @return
	 * @see #getBindings(VHost, String, com.zenika.rabbitmq.management.beans.Binding.DestinationType,
	 *	  String)
	 */
	List<Binding> getBindings(String vHostName, String source,
			Binding.DestinationType destinationType, String destination);

	/**
	 * Get the binding list between an exchange and the destination queue or
	 * exchange
	 *
	 * @param vHost VirtualHost
	 * @param source Source name
	 * @param destinationType Kind of destination (Exchange or Queue)
	 * @param destination Destination name
	 * @return the binding list
	 */
	List<Binding> getBindings(VHost vHost, String source,
			Binding.DestinationType destinationType, String destination);

	/**
	 * Create a new Binding
	 *
	 * @param binding binding to create
	 */
	void postBinding(Binding binding);

	void putBinding(Binding binding);

	void deleteBinding(Binding binding);
}
