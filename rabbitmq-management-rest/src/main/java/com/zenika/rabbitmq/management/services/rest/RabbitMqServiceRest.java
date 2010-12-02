package com.zenika.rabbitmq.management.services.rest;

import java.util.List;
import java.util.Map;

import com.zenika.rabbitmq.management.beans.Application;
import com.zenika.rabbitmq.management.beans.Configuration;
import com.zenika.rabbitmq.management.beans.NodeInfo;
import com.zenika.rabbitmq.management.beans.User;
import com.zenika.rabbitmq.management.services.AbstractRabbitMqService;
import com.zenika.rabbitmq.management.services.RabbitMqService;
import com.zenika.rabbitmq.management.services.rest.remote.RabbitMqServiceRemote;

/**
 * @author Colin Hebert
 */
public class RabbitMqServiceRest extends AbstractRabbitMqService implements
		RabbitMqService {
	private final RabbitMqServiceRemote rabbitMqServiceRemote;

	public RabbitMqServiceRest(RabbitMqServiceRemote rabbitMqServiceRemote) {
		this.rabbitMqServiceRemote = rabbitMqServiceRemote;
	}

	public NodeInfo getNodeOverview() {
		return rabbitMqServiceRemote.getNodeOverview();
	}

	public List<Application> getApplications() {
		throw new UnsupportedOperationException("Operation not supported");
	}

	public Configuration getCompleteConfiguration() {
		return rabbitMqServiceRemote.getCompleteConfiguration();
	}

	public void postCompleteConfiguration(Configuration configuration) {
		rabbitMqServiceRemote.postCompleteConfiguration(configuration);
	}

	public User getCurrentUser() {
		return rabbitMqServiceRemote.getCurrentUser();
	}

	public Map<String, String> testAliveness(String vHost) {
		return rabbitMqServiceRemote.testAliveness(vHost);
	}
}
