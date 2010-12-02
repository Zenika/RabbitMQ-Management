package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.Exchange;
import com.zenika.rabbitmq.management.beans.VHost;

/**
 * @author Colin Hebert
 */
public interface ExchangeService {
	/**
	 * A list of all exchanges.
	 *
	 * @return All exchanges details
	 */
	List<Exchange> getExchanges();

	/**
	 * A list of all exchanges in a given virtual host.
	 *
	 * @param vHostName Virtual host on which exchanges are available
	 * @return All exchanges on a specific virtual host.
	 */
	List<Exchange> getExchanges(String vHostName);

	List<Exchange> getExchanges(VHost vhost);

	/**
	 * An individual exchange.
	 *
	 * @param vHostName
	 * @param exchangeName
	 * @return
	 */
	Exchange getExchange(String vHostName, String exchangeName);

	Exchange getExchange(VHost vhost, String exchangeName);

	/**
	 * To PUT an exchange, you will need a body looking something like this:
	 * {"type":"direct","auto_delete":false,"durable":true,"arguments":[]}
	 *
	 * @param exchange
	 */
	void putExchange(Exchange exchange);

	/**
	 * Delete an Exchange
	 *
	 * @param exchange exchange to delete
	 */
	void deleteExchange(Exchange exchange);

	void deleteExchange(String vHostName, String exchangeName);

	void deleteExchange(VHost vHost, String exchangeName);

	/**
	 * A list of all bindings in which a given exchange is the source.
	 *
	 * @param exchange
	 * @return
	 */
	List<Binding> getBindingsSource(Exchange exchange);

	/**
	 * A list of all bindings in which a given exchange is the destination.
	 *
	 * @param exchange
	 * @return
	 */
	List<Binding> getBindingsDestination(Exchange exchange);
}
