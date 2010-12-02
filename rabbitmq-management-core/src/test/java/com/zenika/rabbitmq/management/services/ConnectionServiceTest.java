package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Channel;
import com.zenika.rabbitmq.management.beans.Connection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.SingleConnectionFactory;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * @author Colin Hebert
 */
public abstract class ConnectionServiceTest extends ServiceTest {
	private ConnectionService connectionService;

	private com.rabbitmq.client.Connection rabbitConnection;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		rabbitConnection = getConnectionFactory().createConnection();
	}

	@After
	public void tearDownConnection() throws Exception {
		rabbitConnection.abort();
	}

	@Test
	public void testGetConnections() throws Exception {
		List<Connection> connections = connectionService.getConnections();
		assertNotNull(connections);
		// There is already one connection from rabbitConnection
		assertEquals(1, connections.size());

		com.rabbitmq.client.Connection rabbitConnection = createConnectionFactory().createConnection();

		connections = connectionService.getConnections();
		assertEquals(2, connections.size());

		rabbitConnection.abort();

	}

	@Test
	public void testGetConnection() throws Exception {
		Connection connection = connectionService.getConnections().get(0);
		assertNotNull(connection);

		Connection connectionToCheck = connectionService.getConnection(
				connection.getName());
		assertEquals(connection, connectionToCheck);
	}

	@Test
	public void testGetConnectionChannels() throws Exception {
		List<Channel> channels;

		Connection connection = connectionService.getConnections().get(0);
		assertNotNull(connection);

		channels = connectionService.getConnectionChannels(connection);
		assertEquals(0, channels.size());

		this.rabbitConnection.createChannel();

		channels = connectionService.getConnectionChannels(connection);
		assertEquals(1, channels.size());
	}

	@Test
	public void testDeleteConnection() throws Exception {
		Connection connection = connectionService.getConnections().get(0);
		assertNotNull(connection);
		connectionService.deleteConnection(connection);
		List<Connection> connections = connectionService.getConnections();
		assertEquals(0, connections.size());
	}

	/**
	 * Only because the SingleConnectionFactory is really crappy...
	 *
	 * @return
	 */
	private ConnectionFactory createConnectionFactory() {
		SingleConnectionFactory connectionFactory = new SingleConnectionFactory(
				rabbitConnection.getHost());
		connectionFactory.setVirtualHost(getvHost().getName());
		connectionFactory.setUsername(getCurrentUser().getUsername());
		connectionFactory.setPassword(getCurrentUser().getPassword());

		return connectionFactory;
	}

	public ConnectionService getConnectionService() {
		return connectionService;
	}

	public void setConnectionService(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}
}
