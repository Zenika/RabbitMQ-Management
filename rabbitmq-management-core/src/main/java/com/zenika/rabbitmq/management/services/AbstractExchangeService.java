package com.zenika.rabbitmq.management.services;

import java.util.Iterator;
import java.util.List;

import com.zenika.rabbitmq.management.beans.Exchange;
import com.zenika.rabbitmq.management.beans.VHost;

/**
 * @author Colin Hebert
 */
public abstract class AbstractExchangeService implements ExchangeService {
	public List<Exchange> getExchanges(VHost vhost) {
		return getExchanges(vhost.getName());
	}

	public List<Exchange> getExchanges(String vHostName) {
		List<Exchange> exchanges = getExchanges();

		for (Iterator<Exchange> exchangeIterator = exchanges.iterator(); exchangeIterator.hasNext();) {
			Exchange exchange = exchangeIterator.next();
			if (!vHostName.equals(exchange.getvHost())) {
				exchangeIterator.remove();
			}
		}

		return exchanges;
	}

	public Exchange getExchange(String vHostName, String exchangeName) {
		for (Exchange exchange : getExchanges()) {
			if (vHostName.equals(exchange.getvHost()) && exchangeName.equals(
					exchange.getName())) {
				return exchange;
			}
		}

		return null;
	}

	public void deleteExchange(Exchange exchange) {
		deleteExchange(exchange.getvHost(), exchange.getName());
	}

	public void deleteExchange(VHost vhost, String exchangeName) {
		deleteExchange(vhost.getName(), exchangeName);
	}

	public Exchange getExchange(VHost vhost, String exchangeName) {
		return getExchange(vhost.getName(), exchangeName);
	}
}
