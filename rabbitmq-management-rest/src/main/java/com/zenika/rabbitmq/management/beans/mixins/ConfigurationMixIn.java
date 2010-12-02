package com.zenika.rabbitmq.management.beans.mixins;

import java.util.List;

import com.zenika.rabbitmq.management.beans.*;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link Configuration}
 *
 * @author Colin Hebert
 */
@MixIn(Configuration.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class ConfigurationMixIn {
	/**
	 * Current Rabbit-MQ version
	 */
	@JsonProperty("rabbit_version")
	private String version;

	/**
	 * Users available on the broker
	 */
	@JsonProperty("users")
	private List<User> users;

	/**
	 * Existing virtual hosts
	 */
	@JsonProperty("vhosts")
	private List<VHost> vHosts;

	/**
	 * Granted permissions
	 */
	@JsonProperty("permissions")
	private List<Permission> permissions;

	/**
	 * Existing queues
	 */
	@JsonProperty("queues")
	private List<Queue> queues;

	/**
	 * Existing exchanges
	 */
	@JsonProperty("exchanges")
	private List<Exchange> exchanges;

	/**
	 * Existing bindings
	 */
	@JsonProperty("bindings")
	private List<BindingMixIn> bindings;

}
