package com.zenika.rabbitmq.management.services.rest;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Channel;
import com.zenika.rabbitmq.management.beans.Connection;
import com.zenika.rabbitmq.management.services.AbstractConnectionService;
import com.zenika.rabbitmq.management.services.ConnectionService;
import com.zenika.rabbitmq.management.services.rest.remote.ConnectionServiceRemote;

/**
 * @author Colin Hebert
 */
public class ConnectionServiceRest extends AbstractConnectionService implements
		ConnectionService {
	private final ConnectionServiceRemote connectionServiceRemote;

	public ConnectionServiceRest(
			ConnectionServiceRemote connectionServiceRemote) {
		this.connectionServiceRemote = connectionServiceRemote;
	}

	public List<Connection> getConnections() {
		return connectionServiceRemote.getConnections();
	}

	@Override
	public Connection getConnection(String name) {
		return connectionServiceRemote.getConnection(name);
	}

	public List<Channel> getConnectionChannels(String name) {
		return connectionServiceRemote.getConnectionChannels(name);
	}

	public void deleteConnection(String name) {
		connectionServiceRemote.deleteConnection(name);
	}
}
