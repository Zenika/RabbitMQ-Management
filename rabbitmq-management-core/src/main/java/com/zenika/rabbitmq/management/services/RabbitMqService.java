package com.zenika.rabbitmq.management.services;

import java.util.List;
import java.util.Map;

import com.zenika.rabbitmq.management.beans.*;

/**
 * @author Colin Hebert
 */
public interface RabbitMqService {
	/**
	 * Get various random bits of information that describe the whole system.
	 *
	 * @return Informations on the node
	 */
	NodeInfo getNodeOverview();

	/**
	 * Get all the running applications in the Erlang VM.
	 *
	 * @return A list of applications running on the node
	 */
	List<Application> getApplications();

	/**
	 * Get the complete server configuration. Everything is retrieved apart from
	 * messages.
	 *
	 * @return The rabbit-mq server configuration
	 */
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
	void postCompleteConfiguration(Configuration configuration);

	/**
	 * Get the current user logged in.
	 *
	 * @return current user
	 */
	User getCurrentUser();

	/**
	 * Get the status of the given vHost
	 *
	 * @param vHost the vHost to check
	 * @return "on" when the given vHost is alive
	 */
	//TODO : Find a better way to get this single result
	Map<String, String> testAliveness(String vHost);

	Map<String, String> testAliveness(VHost vHost);

}
