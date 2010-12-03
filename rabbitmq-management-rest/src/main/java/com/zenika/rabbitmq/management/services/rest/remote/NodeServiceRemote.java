package com.zenika.rabbitmq.management.services.rest.remote;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.zenika.rabbitmq.management.beans.Node;

/**
 * @author Colin Hebert
 */
@Path("nodes")
public interface NodeServiceRemote {
	/**
	 * A list of nodes in the RabbitMQ cluster.
	 *
	 * @return
	 */
	@GET
	List<Node> getNodes();

	/**
	 * An individual node in the RabbitMQ cluster.
	 *
	 * @param nodeName node name
	 * @return
	 */
	@GET
	@Path("{name}")
	Node getNode(@PathParam("name") String nodeName);
}
