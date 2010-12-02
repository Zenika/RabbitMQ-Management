package com.zenika.rabbitmq.management.services;

import com.zenika.rabbitmq.management.beans.User;
import com.zenika.rabbitmq.management.beans.VHost;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Colin Hebert
 */
@ContextConfiguration("RabbitMqServiceRestTest-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RabbitMqServiceRestTest extends RabbitMqServiceTest {
	@Override
	@Autowired
	public void setRabbitMqService(RabbitMqService rabbitMqService) {
		super.setRabbitMqService(
				rabbitMqService);	//To change body of overridden methods use File | Settings | File Templates.
	}

	@Override
	@Autowired
	public void setCurrentUser(User currentUser) {
		super.setCurrentUser(
				currentUser);	//To change body of overridden methods use File | Settings | File Templates.
	}

	@Override
	@Autowired
	public void setvHost(VHost vHost) {
		super.setvHost(
				vHost);	//To change body of overridden methods use File | Settings | File Templates.
	}

	@Override
	@Autowired
	public void setPermissionService(PermissionService permissionService) {
		super.setPermissionService(
				permissionService);	//To change body of overridden methods use File | Settings | File Templates.
	}

	@Override
	@Autowired
	public void setvHostService(VHostService vHostService) {
		super.setvHostService(
				vHostService);	//To change body of overridden methods use File | Settings | File Templates.
	}
}
