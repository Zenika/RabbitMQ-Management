package com.zenika.rabbitmq.management.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.Exchange;
import com.zenika.rabbitmq.management.beans.Queue;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.amqp.core.ExchangeTypes;

import static junit.framework.Assert.*;

/**
 * @author Colin Hebert
 */
public abstract class QueueServiceTest extends ServiceTest {
	private QueueService queueService;

	private Queue dummyQueue;

	private com.rabbitmq.client.Connection rabbitConnection;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		rabbitConnection = getConnectionFactory().createConnection();
	}

	@Before
	public void setUpQueue() throws Exception {
		dummyQueue = new Queue();
		dummyQueue.setvHost(getvHost().getName());
		dummyQueue.setName("dummyQueue");
		dummyQueue.setAutoDelete(false);
		dummyQueue.setDurable(false);
		dummyQueue.setArguments(Collections.<String, String>emptyMap());
	}

	@After
	public void tearDownConnection() throws Exception {
		rabbitConnection.abort();
	}

	@Test
	public void testGetQueues() throws Exception {
		List<Queue> queues = queueService.getQueues();
		assertFalse(queues.contains(dummyQueue));

		rabbitConnection.createChannel().queueDeclare(dummyQueue.getName(),
				dummyQueue.isDurable(), false, dummyQueue.isAutoDelete(),
				new HashMap<String, Object>(dummyQueue.getArguments()));

		queues = queueService.getQueues();
		assertNotNull(queues);
		assertTrue(queues.contains(dummyQueue));
	}

	@Test
	public void testGetQueuesForVHost() throws Exception {
		List<Queue> queues = queueService.getQueues(dummyQueue.getvHost());
		assertFalse(queues.contains(dummyQueue));

		for (Queue queue : queues) {
			assertEquals(dummyQueue.getvHost(), queue.getvHost());
		}

		rabbitConnection.createChannel().queueDeclare(dummyQueue.getName(),
				dummyQueue.isDurable(), false, dummyQueue.isAutoDelete(),
				new HashMap<String, Object>(dummyQueue.getArguments()));

		queues = queueService.getQueues(dummyQueue.getvHost());
		assertNotNull(queues);
		assertTrue(queues.contains(dummyQueue));
		for (Queue queue : queues) {
			assertEquals(dummyQueue.getvHost(), queue.getvHost());
		}
	}

	@Test
	public void testGetQueue() throws Exception {
		rabbitConnection.createChannel().queueDeclare(dummyQueue.getName(),
				dummyQueue.isDurable(), false, dummyQueue.isAutoDelete(),
				new HashMap<String, Object>(dummyQueue.getArguments()));

		Queue queue = queueService.getQueue(dummyQueue.getvHost(),
				dummyQueue.getName());
		assertNotNull(queue);
		assertEquals(dummyQueue, queue);
	}

	@Test
	public void testPutQueue() throws Exception {
		List<Queue> queues = queueService.getQueues();
		assertFalse(queues.contains(dummyQueue));

		queueService.putQueue(dummyQueue);

		queues = queueService.getQueues();
		assertTrue(queues.contains(dummyQueue));
	}

	@Test
	public void testDeleteQueue() throws Exception {
		rabbitConnection.createChannel().queueDeclare(dummyQueue.getName(),
				dummyQueue.isDurable(), false, dummyQueue.isAutoDelete(),
				new HashMap<String, Object>(dummyQueue.getArguments()));

		List<Queue> queues = queueService.getQueues();
		assertTrue(queues.contains(dummyQueue));

		queueService.deleteQueue(dummyQueue);

		queues = queueService.getQueues();
		assertFalse(queues.contains(dummyQueue));
	}

	@Test
	public void testGetBindings() throws Exception {
		Exchange dummyExchange = new Exchange();
		dummyExchange.setAutoDelete(false);
		dummyExchange.setDurable(false);
		dummyExchange.setName("OriginDummyExchange");
		dummyExchange.setType(ExchangeTypes.DIRECT);
		dummyExchange.setvHost(getvHost().getName());
		dummyExchange.setArguments(Collections.<String, String>emptyMap());

		Binding dummyBinding = new Binding();
		dummyBinding.setvHost(getvHost().getName());
		dummyBinding.setRoutingKey("dummy.routing.key.*");
		dummyBinding.setSource(dummyExchange.getName());
		dummyBinding.setDestination(dummyQueue.getName());
		dummyBinding.setDestinationType(Binding.DestinationType.queue);
		dummyBinding.setArguments(Collections.<String, String>emptyMap());

		List<Binding> bindings = queueService.getBindings(dummyQueue);
		assertFalse(bindings.contains(dummyBinding));

		rabbitConnection.createChannel().exchangeDeclare(
				dummyExchange.getName(), dummyExchange.getType(),
				dummyExchange.isDurable(), dummyExchange.isAutoDelete(),
				new HashMap<String, Object>(dummyExchange.getArguments()));
		rabbitConnection.createChannel().queueDeclare(dummyQueue.getName(),
				false, dummyQueue.isDurable(), dummyQueue.isAutoDelete(),
				new HashMap<String, Object>(dummyQueue.getArguments()));
		rabbitConnection.createChannel().queueBind(
				dummyBinding.getDestination(), dummyBinding.getSource(),
				dummyBinding.getRoutingKey(),
				new HashMap<String, Object>(dummyBinding.getArguments()));

		bindings = queueService.getBindings(dummyQueue);
		assertTrue(bindings.contains(dummyBinding));
	}

	@Ignore("Not yet supported")
	@Test
	public void testDeleteQueueContent() throws Exception {
		queueService.deleteQueueContent(dummyQueue);
	}

	public QueueService getQueueService() {
		return queueService;
	}

	public void setQueueService(QueueService queueService) {
		this.queueService = queueService;
	}
}
