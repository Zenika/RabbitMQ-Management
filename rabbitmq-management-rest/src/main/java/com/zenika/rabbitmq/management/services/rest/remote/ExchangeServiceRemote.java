package com.zenika.rabbitmq.management.services.rest.remote;

import java.util.List;
import javax.ws.rs.*;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.Exchange;

@Path("exchanges")
public interface ExchangeServiceRemote {
	/**
	 * A list of all exchanges.
	 *
	 * @return All exchanges details
	 */
	@GET
	List<Exchange> getExchanges();

	/**
	 * A list of all exchanges in a given virtual host.
	 *
	 * @param vhost Virtual host on which exchanges are available
	 * @return All exchanges on a specific virtual host.
	 */
	@GET
	@Path("{vhost}")
	List<Exchange> getExchanges(@PathParam("vhost") String vhost);

	/**
	 * An individual exchange.
	 *
	 * @param vhost
	 * @param name
	 * @return
	 */
	@GET
	@Path("{vhost}/{name}")
	Exchange getExchange(@PathParam("vhost") String vhost,
			@PathParam("name") String name);

	/**
	 * To PUT an exchange, you will need a body looking something like this:
	 * {"type":"direct","auto_delete":false,"durable":true,"arguments":[]}
	 *
	 * @param vhost
	 * @param name
	 * @param exchange
	 */
	@PUT
	@Consumes("application/json")
	@Path("{vhost}/{name}")
	void putExchange(@PathParam("vhost") String vhost,
			@PathParam("name") String name, Exchange exchange);

	/**
	 * Delete an Exchange
	 *
	 * @param vhost
	 * @param name
	 */
	@DELETE
	@Path("{vhost}/{name}")
	void deleteExchange(@PathParam("vhost") String vhost,
			@PathParam("name") String name);

	/**
	 * A list of all bindings in which a given exchange is the source.
	 *
	 * @param vhost
	 * @param name
	 * @return
	 */
	@GET
	@Path("{vhost}/{name}/bindings/source")
	List<Binding> getBindingsSource(@PathParam("vhost") String vhost,
			@PathParam("name") String name);

	/**
	 * A list of all bindings in which a given exchange is the destination.
	 *
	 * @param vhost
	 * @param name
	 * @return
	 */
	@GET
	@Path("{vhost}/{name}/bindings/destination")
	List<Binding> getBindingsDestination(@PathParam("vhost") String vhost,
			@PathParam("name") String name);
}
