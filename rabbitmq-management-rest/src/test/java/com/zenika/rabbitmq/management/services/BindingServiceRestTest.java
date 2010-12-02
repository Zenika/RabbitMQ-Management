package com.zenika.rabbitmq.management.services;

import java.util.HashMap;

import com.zenika.rabbitmq.management.beans.User;
import com.zenika.rabbitmq.management.beans.VHost;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Colin Hebert
 */
@ContextConfiguration("BindingServiceRestTest-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BindingServiceRestTest extends BindingServiceTest {

	@Ignore("Does this text really need to exist ?")
	@Test
	public void testGetBinding() throws Exception {
		getRabbitConnection().createChannel().queueBind(
				getDummyBinding().getDestination(),
				getDummyBinding().getSource(),
				getDummyBinding().getRoutingKey(),
				new HashMap<String, Object>(getDummyBinding().getArguments()));

		/*Binding binding = getBindingService().getBinding(
				getDummyBinding().getvHost(), getDummyBinding().getSource(),
				getDummyBinding().getDestinationType(),
				getDummyBinding().getDestination(),
				RestUtils.getBindingIdentifier(getDummyBinding()));

		assertEquals(getDummyBinding(), binding);*/
	}

	@Override
	@Autowired
	public void setBindingService(BindingService bindingService) {
		super.setBindingService(bindingService);
	}

	@Override
	@Autowired
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		super.setConnectionFactory(connectionFactory);
	}

	@Override
	@Autowired
	public void setvHostService(VHostService vHostService) {
		super.setvHostService(vHostService);
	}

	@Override
	@Autowired
	public void setPermissionService(PermissionService permissionService) {
		super.setPermissionService(permissionService);
	}

	@Override
	@Autowired
	public void setvHost(VHost vHost) {
		super.setvHost(vHost);
	}

	@Override
	@Autowired
	public void setCurrentUser(User currentUser) {
		super.setCurrentUser(currentUser);
	}
}
