package com.zenika.rabbitmq.management.converter.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.converter.toadmin.AdminConverter;
import com.zenika.rabbitmq.management.services.AbstractBindingService;
import com.zenika.rabbitmq.management.services.BindingService;
import org.springframework.amqp.rabbit.admin.RabbitBrokerOperations;

/**
 * @author Colin Hebert
 */
public class BindingServiceAdmin extends AbstractBindingService implements
		BindingService {
	private final RabbitBrokerOperations rabbitBrokerOperations;

	public BindingServiceAdmin(RabbitBrokerOperations rabbitBrokerOperations) {
		this.rabbitBrokerOperations = rabbitBrokerOperations;
	}

	public List<Binding> getBindings() {
		throw new UnsupportedOperationException("Not implemented");
	}

	public void postBinding(Binding binding) {
		rabbitBrokerOperations.declareBinding(
				AdminConverter.convertBinding(binding));
	}

	public void putBinding(Binding binding) {
		rabbitBrokerOperations.declareBinding(
				AdminConverter.convertBinding(binding));
	}

	public void deleteBinding(Binding binding) {
		rabbitBrokerOperations.removeBinding(
				AdminConverter.convertBinding(binding));
	}
}
