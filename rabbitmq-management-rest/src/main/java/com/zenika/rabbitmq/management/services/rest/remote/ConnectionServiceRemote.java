package com.zenika.rabbitmq.management.services.rest.remote;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.zenika.rabbitmq.management.beans.Channel;
import com.zenika.rabbitmq.management.beans.Connection;

@Path("connections")
public interface ConnectionServiceRemote {
	/**
	 * Get the list of all open connections.
	 *
	 * @return
	 */
	@GET
	List<Connection> getConnections();

	/**
	 * An individual connection.
	 *
	 * @param name
	 * @return
	 */
	@GET
	@Path("{name}")
	Connection getConnection(@PathParam("name") String name);

	/**
	 * Channels for an individual connection.
	 *
	 * @param name
	 * @return
	 */
	@GET
	@Path("{name}/channels")
	List<Channel> getConnectionChannels(@PathParam("name") String name);

	/**
	 * Delete and individual connection. DELETEing it will close the connection.
	 *
	 * @param name the connection name
	 */
	@DELETE
	@Path("{name}")
	void deleteConnection(@PathParam("name") String name);
}
