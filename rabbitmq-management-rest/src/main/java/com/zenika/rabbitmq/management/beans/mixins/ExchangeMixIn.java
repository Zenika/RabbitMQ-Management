package com.zenika.rabbitmq.management.beans.mixins;

import java.util.Map;

import com.zenika.rabbitmq.management.beans.Exchange;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link Exchange}
 *
 * @author Colin Hebert
 */
@MixIn(Exchange.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class ExchangeMixIn {
	/**
	 * The name of the exchange
	 */
	@JsonProperty("name")
	private String name;

	/**
	 * Virtual host name
	 */
	@JsonProperty("vhost")
	private String vHost;

	/**
	 * The exchange type
	 */
	@JsonProperty("type")
	private String type;

	/**
	 * Whether the exchange will be deleted automatically when no longer used
	 */
	@JsonProperty("auto_delete")
	private Boolean autoDelete;

	/**
	 * Whether or not the exchange survives server restarts
	 */
	@JsonProperty("durable")
	private Boolean durable;

	/**
	 * Exchange arguments
	 */
	@JsonProperty("arguments")
	private Map<String, String> arguments;
}

