package com.zenika.rabbitmq.management.services;

import java.util.Iterator;
import java.util.List;

import com.zenika.rabbitmq.management.beans.Queue;
import com.zenika.rabbitmq.management.beans.VHost;

/**
 * @author Colin Hebert
 */
public abstract class AbstractQueueService implements QueueService {
	public List<Queue> getQueues(VHost vhost) {
		return getQueues(vhost.getName());
	}

	public Queue getQueue(VHost vhost, String name) {
		return getQueue(vhost.getName(), name);
	}

	public List<Queue> getQueues(String vhost) {
		List<Queue> queues = getQueues();
		for (Iterator<Queue> queueIterator = queues.iterator(); queueIterator.hasNext();) {
			Queue queue = queueIterator.next();
			if (!vhost.equals(queue.getvHost())) {
				queueIterator.remove();
			}
		}
		return queues;
	}

	public Queue getQueue(String vHostName, String queueName) {
		for (Queue queue : getQueues()) {
			if (vHostName.equals(queue.getvHost()) && queueName.equals(
					queue.getName())) {
				return queue;
			}
		}
		return null;
	}
}
