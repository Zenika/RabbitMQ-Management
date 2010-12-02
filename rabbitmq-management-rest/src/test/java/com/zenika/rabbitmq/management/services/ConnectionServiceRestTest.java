package com.zenika.rabbitmq.management.services;

import com.zenika.rabbitmq.management.beans.User;
import com.zenika.rabbitmq.management.beans.VHost;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Colin Hebert
 */
@ContextConfiguration("ConnectionServiceRestTest-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ConnectionServiceRestTest extends ConnectionServiceTest {
	@Override
	@Autowired
	public void setConnectionService(ConnectionService connectionService) {
		super.setConnectionService(connectionService);
	}

	@Override
	@Autowired
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		super.setConnectionFactory(connectionFactory);
	}

	@Override
	@Autowired
	public void setCurrentUser(User currentUser) {
		super.setCurrentUser(currentUser);
	}

	@Override
	@Autowired
	public void setvHost(VHost vHost) {
		super.setvHost(vHost);
	}

	@Override
	@Autowired
	public void setPermissionService(PermissionService permissionService) {
		super.setPermissionService(permissionService);
	}

	@Override
	@Autowired
	public void setvHostService(VHostService vHostService) {
		super.setvHostService(vHostService);
	}
}
