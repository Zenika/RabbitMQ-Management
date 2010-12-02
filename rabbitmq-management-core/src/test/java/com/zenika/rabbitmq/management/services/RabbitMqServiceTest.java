package com.zenika.rabbitmq.management.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.zenika.rabbitmq.management.beans.*;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.amqp.core.ExchangeTypes;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * @author Colin Hebert
 */
public abstract class RabbitMqServiceTest extends ServiceTest {
	private RabbitMqService rabbitMqService;

	@Test
	public void testGetOverview() throws Exception {
		NodeInfo nodeInfo = rabbitMqService.getNodeOverview();
		assertNotNull(nodeInfo);
	}

	@Test
	public void testGetApplications() throws Exception {
		List<Application> applications = rabbitMqService.getApplications();
		assertNotNull(applications);

	}

	@Test
	public void testGetAllConfiguration() throws Exception {
		Configuration configuration = rabbitMqService.getCompleteConfiguration();
		assertNotNull(configuration);

	}

	@Ignore("Not yet supported")
	@Test
	public void testPostAllConfiguration() throws Exception {
		Configuration configuration = generateDummyConfiguration();
		rabbitMqService.postCompleteConfiguration(configuration);
	}

	public Configuration generateDummyConfiguration() {
		Configuration configuration = new Configuration();
		VHost dummyVHost = new VHost();
		dummyVHost.setName("configurationDummyVHost");
		List<VHost> vHosts = new ArrayList<VHost>();
		vHosts.add(dummyVHost);
		configuration.setvHosts(vHosts);

		User dummyUser = new User();
		dummyUser.setUsername("configurationDummyUser");
		dummyUser.setPassword("configurationDummyPassword");
		dummyUser.setAdmin(false);
		List<User> users = new ArrayList<User>();
		users.add(dummyUser);
		configuration.setUsers(users);

		Permission dummyPermission = new Permission();
		dummyPermission.setUser(dummyUser.getUsername());
		dummyPermission.setConfigure(".*");
		dummyPermission.setWrite(".*");
		dummyPermission.setRead(".*");
		dummyPermission.setScope(Permission.Scope.all);
		dummyPermission.setvHost(dummyVHost.getName());
		List<Permission> permissions = new ArrayList<Permission>();
		permissions.add(dummyPermission);
		configuration.setPermissions(permissions);

		Queue dummyQueue = new Queue();
		dummyQueue.setName("configurationDummyQueue");
		dummyQueue.setAutoDelete(false);
		dummyQueue.setArguments(Collections.<String, String>emptyMap());
		dummyQueue.setDurable(false);
		dummyQueue.setvHost(dummyVHost.getName());
		List<Queue> queues = new ArrayList<Queue>();
		queues.add(dummyQueue);
		configuration.setQueues(queues);

		Exchange dummyExchange = new Exchange();
		dummyExchange.setName("configurationDummyExchange");
		dummyExchange.setArguments(Collections.<String, String>emptyMap());
		dummyExchange.setAutoDelete(false);
		dummyExchange.setDurable(false);
		dummyExchange.setType(ExchangeTypes.DIRECT);
		dummyExchange.setvHost(dummyVHost.getName());
		List<Exchange> exchanges = new ArrayList<Exchange>();
		exchanges.add(dummyExchange);
		configuration.setExchanges(exchanges);

		Binding dummyBinding = new Binding();
		dummyBinding.setArguments(Collections.<String, String>emptyMap());
		dummyBinding.setDestination(dummyQueue.getName());
		dummyBinding.setDestinationType(Binding.DestinationType.queue);
		dummyBinding.setRoutingKey("configuration.dummy.routing.key.*");
		dummyBinding.setSource(dummyExchange.getName());
		dummyBinding.setvHost(dummyVHost.getName());
		List<Binding> bindings = new ArrayList<Binding>();
		bindings.add(dummyBinding);
		configuration.setBindings(bindings);

		return configuration;
	}

	@Test
	public void testGetCurrentUser() throws Exception {
		User currentUser = rabbitMqService.getCurrentUser();
		assertNotNull(currentUser);
		assertEquals(getCurrentUser(), currentUser);
	}

	@Test
	public void testAlivenessTest() throws Exception {
		Map<String, String> alivenessTest = rabbitMqService.testAliveness(
				getvHost().getName());
		assertEquals(1, alivenessTest.size());
		assertEquals("ok", alivenessTest.get("status"));
	}

	public RabbitMqService getRabbitMqService() {
		return rabbitMqService;
	}

	public void setRabbitMqService(RabbitMqService rabbitMqService) {
		this.rabbitMqService = rabbitMqService;
	}
}
