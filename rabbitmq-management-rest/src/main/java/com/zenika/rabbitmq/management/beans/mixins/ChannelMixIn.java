package com.zenika.rabbitmq.management.beans.mixins;

import com.zenika.rabbitmq.management.beans.Channel;
import com.zenika.rabbitmq.management.beans.Connection;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link Channel}
 *
 * @author Colin Hebert
 */
@MixIn(Channel.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class ChannelMixIn {
	/**
	 * The name of the channel
	 */
	@JsonProperty("name")
	private String name;

	@JsonProperty("node")
	private String node;

	/**
	 * Virtual host name
	 */
	@JsonProperty("vhost")
	private String vHost;

	/**
	 * Connection on which the channel is based
	 */
	@JsonProperty("connection_details")
	private Connection connection;

	/**
	 * Id of the Erlang process associated with the connection
	 */
	@JsonProperty("pid")
	private String pid;

	/**
	 * Id of the Erlang process associated with the connection to which the channel
	 * belongs
	 */
	@JsonProperty("connection")
	private String connectionPid;

	/**
	 * The number of the channel, which uniquely identifies it within a connection
	 */
	@JsonProperty("number")
	private Long number;

	/**
	 * Username associated with the channel
	 */
	@JsonProperty("user")
	private String username;

	/**
	 * True if the channel is in transactional mode, false otherwise
	 */
	@JsonProperty("transactional")
	private Boolean transactional;

	/**
	 * Number of logical AMQP consumers retrieving messages via the channel
	 */
	@JsonProperty("consumer_count")
	private Long consumerCount;

	/**
	 * Number of messages delivered via this channel but not yet acknowledged.
	 */
	@JsonProperty("messages_unacknowledged")
	private Long messagesUnacknowledged;

	/**
	 * Number of acknowledgements received in an as yet uncommitted transaction
	 */
	@JsonProperty("acks_uncommitted")
	private Long acksUncommitted;

	/**
	 * QoS prefetch count limit in force, 0 if unlimited
	 */
	@JsonProperty("prefetch_count")
	private Long prefetchCount;

	/**
	 * Message deliveries from the server to the channel consumers blocked
	 */
	@JsonProperty("client_flow_blocked")
	private Boolean clientFlowBlocked;
}
