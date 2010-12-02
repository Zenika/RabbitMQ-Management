package com.zenika.rabbitmq.management.converter.tomanagement;

import java.util.HashMap;
import java.util.Map;

import com.zenika.rabbitmq.management.beans.Binding;

/**
 * @author Colin Hebert
 */
public class ToManagementBinding extends Binding {
	private final org.springframework.amqp.core.Binding binding;

	public ToManagementBinding(org.springframework.amqp.core.Binding binding) {
		this.binding = binding;
	}

	@Override
	public String getDestination() {
		return binding.getQueue();
	}

	@Override
	public String getSource() {
		return binding.getExchange();
	}

	@Override
	public String getRoutingKey() {
		return binding.getRoutingKey();
	}

	@Override
	public DestinationType getDestinationType() {
		return DestinationType.queue;
	}

	@Override
	public Map<String, String> getArguments() {
		Map<String, String> argumentsConverted = new HashMap<String, String>();

		for (Map.Entry<String, Object> entry : binding.getArguments().entrySet()) {
			argumentsConverted.put(entry.getKey(), entry.getValue().toString());
		}
		return argumentsConverted;
	}

	@Override
	public void setArguments(Map<String, String> arguments) {
		binding.setArguments(new HashMap<String, Object>(arguments));
	}

	@Override
	public void setSource(String source) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDestination(String destination) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDestinationType(DestinationType destinationType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setRoutingKey(String routingKey) {
		throw new UnsupportedOperationException();
	}
}
