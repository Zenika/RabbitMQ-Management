package com.zenika.rabbitmq.management.converter.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Channel;
import com.zenika.rabbitmq.management.beans.Connection;
import com.zenika.rabbitmq.management.services.AbstractConnectionService;
import com.zenika.rabbitmq.management.services.ConnectionService;

/**
 * @author Colin Hebert
 */
public class ConnectionServiceAdmin extends AbstractConnectionService implements
		ConnectionService {
	public List<Connection> getConnections() {
		throw new UnsupportedOperationException("Operation not supported");
	}

	public List<Channel> getConnectionChannels(String connectionName) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	public void deleteConnection(String connectionName) {
		throw new UnsupportedOperationException("Operation not supported");
	}
}
