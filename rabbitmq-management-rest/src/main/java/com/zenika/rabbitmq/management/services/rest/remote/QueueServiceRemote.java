package com.zenika.rabbitmq.management.services.rest.remote;

import java.util.List;
import javax.ws.rs.*;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.Queue;

@Path("queues")
public interface QueueServiceRemote {

	/**
	 * A list of all queues.
	 *
	 * @return
	 */
	@GET
	List<Queue> getQueues();

	/**
	 * A list of all queues in a given virtual host.
	 *
	 * @param vhost
	 * @return
	 */
	@GET
	@Path("{vhost}")
	List<Queue> getQueues(@PathParam("vhost") String vhost);

	/**
	 * An individual queue.
	 *
	 * @param vhost
	 * @param name
	 * @return
	 */
	@GET
	@Path("{vhost}/{name}")
	Queue getQueue(@PathParam("vhost") String vhost,
			@PathParam("name") String name);

	/**
	 * To PUT a queue, you will need a body looking something like this:
	 * {"auto_delete":false,"durable":true,"arguments":[]}
	 *
	 * @param vhost
	 * @param name
	 * @param queue
	 */
	@PUT
	@Consumes("application/json")
	@Path("{vhost}/{name}")
	void putQueue(@PathParam("vhost") String vhost,
			@PathParam("name") String name, Queue queue);

	@DELETE
	@Path("{vhost}/{name}")
	void deleteQueue(@PathParam("vhost") String vhost,
			@PathParam("name") String name);

	@GET
	@Path("{vhost}/{queue}/bindings")
	List<Binding> getBindings(@PathParam("vhost") String vhost,
			@PathParam("queue") String queue);

	@DELETE
	@Path("{vhost}/{name}/contents")
	void deleteQueueContent(@PathParam("vhost") String vhost,
			@PathParam("name") String name);

}
