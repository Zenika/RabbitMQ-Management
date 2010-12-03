package com.zenika.rabbitmq.management.services.rest.remote;

import java.util.Map;
import javax.ws.rs.*;

import com.zenika.rabbitmq.management.beans.BrokerInfos;
import com.zenika.rabbitmq.management.beans.Configuration;
import com.zenika.rabbitmq.management.beans.User;

public interface RabbitMqServiceRemote {
	/**
	 * Get various random bits of information that describe the whole system.
	 *
	 * @return Informations on the node
	 */
	@GET
	@Path("overview")
	BrokerInfos getOverview();

	/**
	 * Get the complete server configuration. Everything is retrieved apart from
	 * messages.
	 *
	 * @return The rabbit-mq server configuration
	 */
	@GET
	@Path("all-configuration")
	Configuration getCompleteConfiguration();

	/**
	 * Upload a configuration to the rabbit-mq server.
	 * <p/>
	 * The uploaded configuration is merged with the existing one which is leaved
	 * untouched. Any conflict will cause an error. In the event of an error, you
	 * will be left with a part-applied configuration.
	 *
	 * @param configuration the new configuration
	 */
	@POST
	@Consumes("application/json")
	@Path("all-configuration")
	void postCompleteConfiguration(Configuration configuration);

	/**
	 * Get the current user logged in.
	 *
	 * @return current user
	 */
	@GET
	@Path("whoami")
	User getCurrentUser();

	/**
	 * Get the status of the given vHost
	 *
	 * @param vHost the vHost to check
	 * @return "on" when the given vHost is alive
	 */
	//TODO : Find a better way to get this single result
	@GET
	@Path("aliveness-test/{vhost}")
	Map<String, String> testAliveness(@PathParam("vhost") String vHost);

}
