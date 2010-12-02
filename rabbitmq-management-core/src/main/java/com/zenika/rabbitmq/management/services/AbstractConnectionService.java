package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Channel;
import com.zenika.rabbitmq.management.beans.Connection;

/**
 * @author Colin Hebert
 */
public abstract class AbstractConnectionService implements ConnectionService {
	public List<Channel> getConnectionChannels(Connection connection) {
		return getConnectionChannels(connection.getName());
	}

	public void deleteConnection(Connection connection) {
		deleteConnection(connection.getName());
	}

	public Connection getConnection(String connectionName) {
		for (Connection connection : getConnections()) {
			if (connectionName.equals(connection.getName())) {
				return connection;
			}
		}
		return null;
	}
}
