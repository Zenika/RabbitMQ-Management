package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.Queue;
import com.zenika.rabbitmq.management.beans.VHost;

/**
 * @author Colin Hebert
 */
public interface QueueService {

	/**
	 * A list of all queues.
	 *
	 * @return
	 */
	List<Queue> getQueues();

	/**
	 * A list of all queues in a given virtual host.
	 *
	 * @param vhost
	 * @return
	 */
	List<Queue> getQueues(String vhost);

	List<Queue> getQueues(VHost vhost);

	/**
	 * An individual queue.
	 *
	 * @param vhost
	 * @param name
	 * @return
	 */
	Queue getQueue(String vhost, String name);

	Queue getQueue(VHost vhost, String name);

	/**
	 * To PUT a queue, you will need a body looking something like this:
	 * {"auto_delete":false,"durable":true,"arguments":[]}
	 *
	 * @param queue
	 */
	void putQueue(Queue queue);

	void deleteQueue(Queue queue);

	List<Binding> getBindings(Queue queue);

	void deleteQueueContent(Queue queue);

}
