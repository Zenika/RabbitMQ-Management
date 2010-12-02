package com.zenika.rabbitmq.management.converter.toadmin;

import java.util.HashMap;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.Exchange;
import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.Queue;
import org.springframework.amqp.core.AbstractExchange;

/**
 * @author Colin Hebert
 */
public final class AdminConverter {
	private AdminConverter() {
	}

	public static org.springframework.amqp.core.Binding convertBinding(
			Binding binding) {
		if (binding.getDestinationType() != Binding.DestinationType.queue) {
			throw new IllegalArgumentException(
					"This implementation doesn't handle destinations types other than queue");
		}

		org.springframework.amqp.core.Queue adminQueue = new org.springframework.amqp.core.Queue(
				binding.getDestination());
		//Don't really care about the implementation, but as the Binding class needs a specific type declaration...
		org.springframework.amqp.core.DirectExchange exchange = new org.springframework.amqp.core.DirectExchange(
				binding.getSource());
		org.springframework.amqp.core.Binding adminBinding = new org.springframework.amqp.core.Binding(
				adminQueue, exchange, binding.getRoutingKey());

		adminBinding.setArguments(
				new HashMap<String, Object>(binding.getArguments()));

		return adminBinding;
	}

	public static org.springframework.amqp.core.Exchange convertExchange(
			final Exchange exchange) {
		org.springframework.amqp.core.AbstractExchange adminExchange = new AbstractExchange(
				exchange.getName()) {

			@Override
			public String getType() {
				return exchange.getType();
			}
		};

		adminExchange.setArguments(
				new HashMap<String, Object>(exchange.getArguments()));
		adminExchange.setAutoDelete(exchange.isAutoDelete());
		adminExchange.setDurable(exchange.isDurable());

		return adminExchange;
	}

	public static Permission convertPermission(String adminPermission) {
		Permission permission = new Permission();
		//TODO : Find which format is used for the permission string
		return permission;
	}

	public static org.springframework.amqp.core.Queue converterQueue(
			Queue queue) {
		org.springframework.amqp.core.Queue adminQueue = new org.springframework.amqp.core.Queue(
				queue.getName());
		adminQueue.setArguments(
				new HashMap<String, Object>(queue.getArguments()));
		adminQueue.setAutoDelete(queue.isAutoDelete());
		adminQueue.setDurable(queue.isDurable());
		//TODO : find what exclusive is
		//adminQueue.setExclusive();
		return adminQueue;
	}
}
