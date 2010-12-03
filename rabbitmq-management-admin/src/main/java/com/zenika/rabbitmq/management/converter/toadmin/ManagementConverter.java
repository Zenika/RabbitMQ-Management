package com.zenika.rabbitmq.management.converter.toadmin;

import java.util.HashMap;
import java.util.Map;

import com.zenika.rabbitmq.management.beans.Queue;

/**
 * @author Colin Hebert
 */
public final class ManagementConverter {
	public static Queue convertQueue(
			org.springframework.amqp.rabbit.admin.QueueInfo adminQueue) {
		Queue queue = new Queue();

		Map<String, String> arguments = new HashMap<String, String>();
		for (String argument : adminQueue.getArguments()) {
			//TODO : Find how the argument string is formatted
			arguments.put("", argument);
		}
		queue.setArguments(arguments);
		queue.setAutoDelete(adminQueue.isAutoDelete());
		queue.setDurable(adminQueue.isDurable());
		queue.setMessages(adminQueue.getMessages());
		queue.setMessagesUnacknowledged(adminQueue.getMessagesUnacknowledged());
		queue.setName(adminQueue.getName());
		queue.setPid(adminQueue.getPid());
		queue.setMessagesReady(adminQueue.getMessagesReady());
		queue.setMemory(adminQueue.getMemory());
		queue.setConsumers(adminQueue.getConsumers());

		return queue;
	}
}
