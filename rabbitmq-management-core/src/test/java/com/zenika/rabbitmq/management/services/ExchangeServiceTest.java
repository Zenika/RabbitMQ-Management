package com.zenika.rabbitmq.management.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.Exchange;
import com.zenika.rabbitmq.management.beans.Queue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.core.ExchangeTypes;

import static junit.framework.Assert.*;

/**
 * @author Colin Hebert
 */
public abstract class ExchangeServiceTest extends ServiceTest {
	private ExchangeService exchangeService;

	private BindingService bindingService;

	private Exchange dummyExchange;

	private com.rabbitmq.client.Connection rabbitConnection;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		rabbitConnection = getConnectionFactory().createConnection();
	}

	@Before
	public void setUpQueue() throws Exception {
		dummyExchange = new Exchange();
		dummyExchange.setName("dummyExchange");
		dummyExchange.setType(ExchangeTypes.DIRECT);
		dummyExchange.setvHost(getvHost().getName());
		dummyExchange.setDurable(false);
		dummyExchange.setAutoDelete(false);
		dummyExchange.setArguments(Collections.<String, String>emptyMap());
	}

	@After
	public void tearDownConnection() throws Exception {
		rabbitConnection.abort();
	}

	@Test
	public void testGetExchanges() throws Exception {
		List<Exchange> exchanges = exchangeService.getExchanges();
		assertFalse(exchanges.contains(dummyExchange));

		rabbitConnection.createChannel().exchangeDeclare(
				dummyExchange.getName(), dummyExchange.getType(),
				dummyExchange.isDurable(), dummyExchange.isAutoDelete(),
				new HashMap<String, Object>(dummyExchange.getArguments()));

		exchanges = exchangeService.getExchanges();
		assertNotNull(exchanges);
		assertTrue(exchanges.contains(dummyExchange));
	}

	@Test
	public void testGetExchangesForVHost() throws Exception {
		List<Exchange> exchanges = exchangeService.getExchanges(
				dummyExchange.getvHost());
		assertFalse(exchanges.contains(dummyExchange));

		for (Exchange exchange : exchanges) {
			assertEquals(dummyExchange.getvHost(), exchange.getvHost());
		}

		rabbitConnection.createChannel().exchangeDeclare(
				dummyExchange.getName(), dummyExchange.getType(),
				dummyExchange.isDurable(), dummyExchange.isAutoDelete(),
				new HashMap<String, Object>(dummyExchange.getArguments()));

		exchanges = exchangeService.getExchanges(dummyExchange.getvHost());
		assertNotNull(exchanges);
		assertTrue(exchanges.contains(dummyExchange));

		for (Exchange exchange : exchanges) {
			assertEquals(dummyExchange.getvHost(), exchange.getvHost());
		}
	}

	@Test
	public void testGetExchange() throws Exception {
		rabbitConnection.createChannel().exchangeDeclare(
				dummyExchange.getName(), dummyExchange.getType(),
				dummyExchange.isDurable(), dummyExchange.isAutoDelete(),
				new HashMap<String, Object>(dummyExchange.getArguments()));

		Exchange exchange = exchangeService.getExchange(
				dummyExchange.getvHost(), dummyExchange.getName());
		assertNotNull(exchange);
		assertEquals(dummyExchange, exchange);
	}

	@Test
	public void testPutExchange() throws Exception {
		List<Exchange> exchanges = exchangeService.getExchanges();
		assertFalse(exchanges.contains(dummyExchange));

		exchangeService.putExchange(dummyExchange);

		exchanges = exchangeService.getExchanges();
		assertNotNull(exchanges);
		assertTrue(exchanges.contains(dummyExchange));
	}

	@Test
	public void testDeleteExchange() throws Exception {
		rabbitConnection.createChannel().exchangeDeclare(
				dummyExchange.getName(), dummyExchange.getType(),
				dummyExchange.isDurable(), dummyExchange.isAutoDelete(),
				new HashMap<String, Object>(dummyExchange.getArguments()));

		List<Exchange> exchanges = exchangeService.getExchanges();
		assertTrue(exchanges.contains(dummyExchange));

		exchangeService.deleteExchange(dummyExchange);

		exchanges = exchangeService.getExchanges();
		assertFalse(exchanges.contains(dummyExchange));
	}

	@Test
	public void testGetBindingsSource() throws Exception {
		Queue destinationDummyQueue = new Queue();
		destinationDummyQueue.setAutoDelete(false);
		destinationDummyQueue.setDurable(false);
		destinationDummyQueue.setName("OriginDummyQueue");
		destinationDummyQueue.setvHost(getvHost().getName());
		destinationDummyQueue.setArguments(
				Collections.<String, String>emptyMap());

		Binding dummyBinding = new Binding();
		dummyBinding.setvHost(getvHost().getName());
		dummyBinding.setRoutingKey("dummy.routing.key.*");
		dummyBinding.setSource(dummyExchange.getName());
		dummyBinding.setDestination(destinationDummyQueue.getName());
		dummyBinding.setDestinationType(Binding.DestinationType.queue);
		dummyBinding.setArguments(Collections.<String, String>emptyMap());

		List<Binding> bindings = exchangeService.getBindingsSource(
				dummyExchange);
		assertFalse(bindings.contains(dummyBinding));

		rabbitConnection.createChannel().exchangeDeclare(
				dummyExchange.getName(), dummyExchange.getType(),
				dummyExchange.isDurable(), dummyExchange.isAutoDelete(),
				new HashMap<String, Object>(dummyExchange.getArguments()));
		rabbitConnection.createChannel().queueDeclare(
				destinationDummyQueue.getName(), false,
				destinationDummyQueue.isDurable(),
				destinationDummyQueue.isAutoDelete(),
				new HashMap<String, Object>(
						destinationDummyQueue.getArguments()));
		rabbitConnection.createChannel().queueBind(
				dummyBinding.getDestination(), dummyBinding.getSource(),
				dummyBinding.getRoutingKey(),
				new HashMap<String, Object>(dummyBinding.getArguments()));

		bindings = exchangeService.getBindingsSource(dummyExchange);
		assertTrue(bindings.contains(dummyBinding));

	}

	@Test
	public void testGetBindingsDestination() throws Exception {
		Exchange sourceDummyExchange = new Exchange();
		sourceDummyExchange.setAutoDelete(false);
		sourceDummyExchange.setDurable(false);
		sourceDummyExchange.setName("OriginDummyExchange");
		sourceDummyExchange.setType(ExchangeTypes.DIRECT);
		sourceDummyExchange.setvHost(getvHost().getName());
		sourceDummyExchange.setArguments(
				Collections.<String, String>emptyMap());

		Binding dummyBinding = new Binding();
		dummyBinding.setvHost(getvHost().getName());
		dummyBinding.setRoutingKey("dummy.routing.key.*");
		dummyBinding.setSource(sourceDummyExchange.getName());
		dummyBinding.setDestination(dummyExchange.getName());
		dummyBinding.setDestinationType(Binding.DestinationType.exchange);
		dummyBinding.setArguments(Collections.<String, String>emptyMap());

		List<Binding> bindings = exchangeService.getBindingsDestination(
				dummyExchange);
		assertFalse(bindings.contains(dummyBinding));

		rabbitConnection.createChannel().exchangeDeclare(
				dummyExchange.getName(), dummyExchange.getType(),
				dummyExchange.isDurable(), dummyExchange.isAutoDelete(),
				new HashMap<String, Object>(dummyExchange.getArguments()));
		rabbitConnection.createChannel().exchangeDeclare(
				sourceDummyExchange.getName(), sourceDummyExchange.getType(),
				sourceDummyExchange.isDurable(),
				sourceDummyExchange.isAutoDelete(), new HashMap<String, Object>(
						sourceDummyExchange.getArguments()));

		bindingService.postBinding(dummyBinding);

		bindings = exchangeService.getBindingsDestination(dummyExchange);
		assertTrue(bindings.contains(dummyBinding));

	}

	public ExchangeService getExchangeService() {
		return exchangeService;
	}

	public void setExchangeService(ExchangeService exchangeService) {
		this.exchangeService = exchangeService;
	}

	public BindingService getBindingService() {
		return bindingService;
	}

	public void setBindingService(BindingService bindingService) {
		this.bindingService = bindingService;
	}
}
