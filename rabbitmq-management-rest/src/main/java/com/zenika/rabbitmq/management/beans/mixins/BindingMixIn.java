package com.zenika.rabbitmq.management.beans.mixins;

import java.util.Map;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link Binding}
 *
 * @author Colin Hebert
 */
@MixIn(Binding.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
@JsonIgnoreProperties("properties_key")
public class BindingMixIn {

	/**
	 * Name of the binding, defined by its routing key and arguments also known as props
	 */
	/*
	@JsonProperty("properties_key")
	private String name;
	*/

	/**
	 * Virtual host name
	 */
	@JsonProperty("vhost")
	private String vHost;

	/**
	 * The name of the source of messages to which the binding is attached
	 */
	@JsonProperty("source")
	private String source;

	/**
	 * The name of the destination of messages to which the binding is attached
	 */
	@JsonProperty("destination")
	private String destination;

	/**
	 * The kind of the destination of messages to which the binding is attached
	 */
	@JsonProperty("destination_type")
	private Binding.DestinationType destinationType;

	/**
	 * The binding's routing key also know as props
	 */
	@JsonProperty("routing_key")
	private String routingKey;

	/**
	 * The binding's arguments
	 */
	@JsonProperty("arguments")
	private Map<String, String> arguments;
}
