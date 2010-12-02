package com.zenika.rabbitmq.management.beans.mixins;

import java.util.Map;

import com.zenika.rabbitmq.management.beans.Connection;
import com.zenika.rabbitmq.management.beans.Queue;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link Queue}
 *
 * @author Colin Hebert
 */
@MixIn(Queue.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class QueueMixIn {
	/**
	 * The name of the queue
	 */
	@JsonProperty("name")
	private String name;

	/**
	 * Virtual host name
	 */
	@JsonProperty("vhost")
	private String vHost;

	/**
	 * id of the Erlang process associated with the queue
	 */
	@JsonProperty("pid")
	private String pid;

	/**
	 * id of the Erlang process representing the connection which is the exclusive
	 * owner of the queue, or empty if the queue is non-exclusive
	 */
	@JsonProperty("owner_pid")
	private String connectionPid;

	/**
	 * Connection on which the queue is based
	 */
	@JsonProperty("owner_pid_details")
	private Connection connection;

	/**
	 * id of the Erlang process representing the channel of the exclusive consumer
	 * subscribed to this queue, or empty if there is no exclusive consumer
	 */
	@JsonProperty("exclusive_consumer_pid")
	private String exclusiveChannelPid;

	/**
	 * consumer tag of the exclusive consumer subscribed to this queue, or empty if
	 * there is no exclusive consumer
	 */
	@JsonProperty("exclusive_consumer_tag")
	private String exclusiveConsumerTag;

	/**
	 * Whether the queue will be deleted automatically when no longer used
	 */
	@JsonProperty("auto_delete")
	private Boolean autoDelete;

	/**
	 * Whether or not the queue survives server restarts
	 */
	@JsonProperty("durable")
	private Boolean durable;

	/**
	 * Queue arguments
	 */
	@JsonProperty("arguments")
	private Map<String, String> arguments;

	/**
	 * Sum of ready, unacknowledged and uncommitted messages
	 */
	@JsonProperty("messages")
	private long messages;

	/**
	 * number of messages ready to be delivered to clients
	 */
	@JsonProperty("messages_ready")
	private long messagesReady;

	/**
	 * number of messages delivered to clients but not yet acknowledged
	 */
	@JsonProperty("messages_unacknowledged")
	private long messagesUnacknowledged;

	/**
	 * Number of consumers
	 */
	@JsonProperty("consumers")
	private long consumers;

	/**
	 * Bytes of memory consumed by the Erlang process for the queue, including
	 * stack, heap and internal structures
	 */
	@JsonProperty("memory")
	private long usedMemory;

	/**
	 *
	 */
	//TODO : Find the usage of this field
	@JsonProperty("backing_queue_status")
	private Object backingQueueStatus;
}
