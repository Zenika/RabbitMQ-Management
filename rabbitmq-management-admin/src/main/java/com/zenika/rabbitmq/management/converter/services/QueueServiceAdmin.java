package com.zenika.rabbitmq.management.converter.services;

import java.util.ArrayList;
import java.util.List;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.Queue;
import com.zenika.rabbitmq.management.converter.toadmin.ManagementConverter;
import com.zenika.rabbitmq.management.services.AbstractQueueService;
import com.zenika.rabbitmq.management.services.QueueService;
import org.springframework.amqp.rabbit.admin.RabbitBrokerOperations;

/**
 * @author Colin Hebert
 */
public class QueueServiceAdmin extends AbstractQueueService implements
		QueueService {
	private final RabbitBrokerOperations rabbitBrokerOperations;

	public QueueServiceAdmin(RabbitBrokerOperations rabbitBrokerOperations) {
		this.rabbitBrokerOperations = rabbitBrokerOperations;
	}

	public List<Queue> getQueues() {
		List<org.springframework.amqp.rabbit.admin.QueueInfo> adminQueues = rabbitBrokerOperations.getQueues();
		List<Queue> queues = new ArrayList<Queue>();

		for (org.springframework.amqp.rabbit.admin.QueueInfo adminQueue : adminQueues) {
			queues.add(ManagementConverter.convertQueue(adminQueue));
		}

		return queues;
	}

	public void putQueue(Queue queue) {
		rabbitBrokerOperations.declareQueue();
	}

	public void deleteQueue(Queue queue) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public List<Binding> getBindings(Queue queue) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public void deleteQueueContent(Queue queue) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
