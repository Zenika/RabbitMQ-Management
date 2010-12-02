package com.zenika.rabbitmq.management.converter.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.Exchange;
import com.zenika.rabbitmq.management.converter.toadmin.AdminConverter;
import com.zenika.rabbitmq.management.services.AbstractExchangeService;
import com.zenika.rabbitmq.management.services.ExchangeService;
import org.springframework.amqp.rabbit.admin.RabbitBrokerOperations;

/**
 * @author Colin Hebert
 */
public class ExchangeServiceAdmin extends AbstractExchangeService implements
		ExchangeService {
	private final RabbitBrokerOperations rabbitBrokerOperations;

	public ExchangeServiceAdmin(RabbitBrokerOperations rabbitBrokerOperations) {
		this.rabbitBrokerOperations = rabbitBrokerOperations;
	}

	public List<Exchange> getExchanges() {
		throw new UnsupportedOperationException("Operation not supported");
	}

	public void putExchange(final Exchange exchange) {
		rabbitBrokerOperations.declareExchange(
				AdminConverter.convertExchange(exchange));
	}

	//TODO : Warning! we don't know which VHostName will be used !
	public void deleteExchange(String vHostName, String exchangeName) {
		rabbitBrokerOperations.deleteExchange(exchangeName);
	}

	public List<Binding> getBindingsSource(Exchange exchange) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	public List<Binding> getBindingsDestination(Exchange exchange) {
		throw new UnsupportedOperationException("Operation not supported");
	}
}
