package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Channel;
import com.zenika.rabbitmq.management.beans.Connection;

/**
 * @author Colin Hebert
 */
public interface ConnectionService {
	/**
	 * Get the list of all open connections.
	 *
	 * @return
	 */
	List<Connection> getConnections();

	/**
	 * An individual connection.
	 *
	 * @param connectionName the connection name
	 * @return
	 */
	Connection getConnection(String connectionName);

	/**
	 * Channels for an individual connection.
	 *
	 * @param connectionName the connection name
	 * @return
	 */
	List<Channel> getConnectionChannels(String connectionName);

	List<Channel> getConnectionChannels(Connection connection);

	/**
	 * Delete and individual connection. DELETEing it will close the connection.
	 *
	 * @param connectionName the connection name
	 */
	void deleteConnection(String connectionName);

	void deleteConnection(Connection connection);
}
