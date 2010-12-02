package com.zenika.rabbitmq.management.services;

import java.util.Map;

import com.zenika.rabbitmq.management.beans.VHost;

/**
 * @author Colin Hebert
 */
public abstract class AbstractRabbitMqService implements RabbitMqService {
	public Map<String, String> testAliveness(VHost vHost) {
		return testAliveness(vHost.getName());
	}
}
