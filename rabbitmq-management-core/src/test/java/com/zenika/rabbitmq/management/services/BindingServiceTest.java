package com.zenika.rabbitmq.management.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.Exchange;
import com.zenika.rabbitmq.management.beans.Queue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.core.ExchangeTypes;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * @author Colin Hebert
 */
public abstract class BindingServiceTest extends ServiceTest {
	private BindingService bindingService;

	private Exchange sourceDummyExchange, destinationDummyExchange;

	private Queue destinationDummyQueue;

	private Binding dummyBinding;

	private com.rabbitmq.client.Connection rabbitConnection;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		rabbitConnection = getConnectionFactory().createConnection();

		sourceDummyExchange = new Exchange();
		sourceDummyExchange.setAutoDelete(false);
		sourceDummyExchange.setDurable(false);
		sourceDummyExchange.setName("OriginDummyExchange");
		sourceDummyExchange.setType(ExchangeTypes.DIRECT);
		sourceDummyExchange.setvHost(getvHost().getName());
		sourceDummyExchange.setArguments(
				Collections.<String, String>emptyMap());

		rabbitConnection.createChannel().exchangeDeclare(
				sourceDummyExchange.getName(), sourceDummyExchange.getType(),
				sourceDummyExchange.isDurable(),
				sourceDummyExchange.isAutoDelete(), new HashMap<String, Object>(
						sourceDummyExchange.getArguments()));

		destinationDummyExchange = new Exchange();
		destinationDummyExchange.setAutoDelete(false);
		destinationDummyExchange.setDurable(false);
		destinationDummyExchange.setName("OriginDummyExchange");
		destinationDummyExchange.setType(ExchangeTypes.DIRECT);
		destinationDummyExchange.setvHost(getvHost().getName());
		destinationDummyExchange.setArguments(
				Collections.<String, String>emptyMap());

		rabbitConnection.createChannel().exchangeDeclare(
				destinationDummyExchange.getName(),
				destinationDummyExchange.getType(),
				destinationDummyExchange.isDurable(),
				destinationDummyExchange.isAutoDelete(),
				new HashMap<String, Object>(
						destinationDummyExchange.getArguments()));

		destinationDummyQueue = new Queue();
		destinationDummyQueue.setName("OriginDummyQueue");
		destinationDummyQueue.setvHost(getvHost().getName());
		destinationDummyQueue.setAutoDelete(false);
		destinationDummyQueue.setDurable(false);
		destinationDummyQueue.setArguments(
				Collections.<String, String>emptyMap());

		rabbitConnection.createChannel().queueDeclare(
				destinationDummyQueue.getName(),
				destinationDummyQueue.isDurable(), false,
				destinationDummyQueue.isAutoDelete(),
				new HashMap<String, Object>(
						destinationDummyQueue.getArguments()));

		dummyBinding = new Binding();
		dummyBinding.setvHost(getvHost().getName());
		dummyBinding.setRoutingKey("dummy.routing.key.*");
		dummyBinding.setSource(sourceDummyExchange.getName());
		dummyBinding.setDestination(destinationDummyQueue.getName());
		dummyBinding.setDestinationType(Binding.DestinationType.queue);
		dummyBinding.setArguments(Collections.<String, String>emptyMap());
	}

	@After
	public void tearDownConnection() throws Exception {
		rabbitConnection.abort();
	}

	@Test
	public void testGetBindings() throws Exception {
		List<Binding> bindings = bindingService.getBindings();
		assertFalse(bindings.contains(dummyBinding));

		Channel channel = rabbitConnection.createChannel();
		channel.queueBind(dummyBinding.getDestination(),
				dummyBinding.getSource(), dummyBinding.getRoutingKey(),
				new HashMap<String, Object>(dummyBinding.getArguments()));

		bindings = bindingService.getBindings();
		assertTrue(bindings.contains(dummyBinding));
	}

	@Test
	public void testGetBindingsForVHost() throws Exception {
		List<Binding> bindings = bindingService.getBindings(
				dummyBinding.getvHost());
		assertFalse(bindings.contains(dummyBinding));

		rabbitConnection.createChannel().queueBind(
				dummyBinding.getDestination(), dummyBinding.getSource(),
				dummyBinding.getRoutingKey(),
				new HashMap<String, Object>(dummyBinding.getArguments()));

		bindings = bindingService.getBindings(dummyBinding.getvHost());
		assertTrue(bindings.contains(dummyBinding));
	}

	@Test
	public void testGetBindingsBetweenExchange() throws Exception {
		List<Binding> bindings = bindingService.getBindings(
				dummyBinding.getvHost(), dummyBinding.getSource(),
				dummyBinding.getDestinationType(),
				dummyBinding.getDestination());
		assertFalse(bindings.contains(dummyBinding));

		rabbitConnection.createChannel().queueBind(
				dummyBinding.getDestination(), dummyBinding.getSource(),
				dummyBinding.getRoutingKey(),
				new HashMap<String, Object>(dummyBinding.getArguments()));

		bindings = bindingService.getBindings(dummyBinding.getvHost(),
				dummyBinding.getSource(), dummyBinding.getDestinationType(),
				dummyBinding.getDestination());
		assertTrue(bindings.contains(dummyBinding));
	}

	@Test
	public void testPostBinding() throws Exception {
		List<Binding> bindings = bindingService.getBindings(
				dummyBinding.getvHost());
		assertFalse(bindings.contains(dummyBinding));

		bindingService.postBinding(dummyBinding);

		bindings = bindingService.getBindings(dummyBinding.getvHost());
		assertTrue(bindings.contains(dummyBinding));
	}

	@Test
	public void testPutBinding() throws Exception {
		List<Binding> bindings = bindingService.getBindings(
				dummyBinding.getvHost());
		assertFalse(bindings.contains(dummyBinding));

		bindingService.putBinding(dummyBinding);

		bindings = bindingService.getBindings(dummyBinding.getvHost());
		assertTrue(bindings.contains(dummyBinding));
	}

	@Test
	public void testDeleteBinding() throws Exception {
		rabbitConnection.createChannel().queueBind(
				dummyBinding.getDestination(), dummyBinding.getSource(),
				dummyBinding.getRoutingKey(),
				new HashMap<String, Object>(dummyBinding.getArguments()));

		List<Binding> bindings = bindingService.getBindings(
				dummyBinding.getvHost());
		assertTrue(bindings.contains(dummyBinding));

		bindingService.deleteBinding(dummyBinding);

		bindings = bindingService.getBindings(dummyBinding.getvHost());
		assertFalse(bindings.contains(dummyBinding));
	}

	public BindingService getBindingService() {
		return bindingService;
	}

	public void setBindingService(BindingService bindingService) {
		this.bindingService = bindingService;
	}

	public Binding getDummyBinding() {
		return dummyBinding;
	}

	public Connection getRabbitConnection() {
		return rabbitConnection;
	}
}
