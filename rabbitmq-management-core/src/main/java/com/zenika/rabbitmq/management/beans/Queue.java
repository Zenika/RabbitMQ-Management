package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;
import java.util.Map;

/**
 * Message queue
 *
 * @author Colin Hebert
 */
public class Queue implements Serializable {
	/**
	 * The name of the queue
	 */
	private String name;

	/**
	 * Virtual host name
	 */
	private String vHost;

	/**
	 * id of the Erlang process associated with the queue
	 */
	private String pid;

	/**
	 * id of the Erlang process representing the connection which is the exclusive
	 * owner of the queue, or empty if the queue is non-exclusive
	 */
	private String connectionPid;

	/**
	 * Connection on which the queue is based
	 */
	private Connection connection;

	/**
	 * id of the Erlang process representing the channel of the exclusive consumer
	 * subscribed to this queue, or empty if there is no exclusive consumer
	 */
	private String exclusiveChannelPid;

	/**
	 * consumer tag of the exclusive consumer subscribed to this queue, or empty if
	 * there is no exclusive consumer
	 */
	private String exclusiveConsumerTag;

	/**
	 * Whether the queue will be deleted automatically when no longer used
	 */
	private Boolean autoDelete;

	/**
	 * Whether or not the queue survives server restarts
	 */
	private Boolean durable;

	/**
	 * Queue arguments
	 */
	private Map<String, String> arguments;

	/**
	 * Sum of ready, unacknowledged and uncommitted messages
	 */
	private long messages;

	/**
	 * number of messages ready to be delivered to clients
	 */
	private long messagesReady;

	/**
	 * number of messages delivered to clients but not yet acknowledged
	 */
	private long messagesUnacknowledged;

	/**
	 * Number of consumers
	 */
	private long consumers;

	/**
	 * Bytes of memory consumed by the Erlang process for the queue, including
	 * stack, heap and internal structures
	 */
	private long usedMemory;

	/**
	 *
	 */
	//TODO : Find the usage of this field
	private Object backingQueueStatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getvHost() {
		return vHost;
	}

	public void setvHost(String vHost) {
		this.vHost = vHost;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getConnectionPid() {
		return connectionPid;
	}

	public void setConnectionPid(String connectionPid) {
		this.connectionPid = connectionPid;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public String getExclusiveChannelPid() {
		return exclusiveChannelPid;
	}

	public void setExclusiveChannelPid(String exclusiveChannelPid) {
		this.exclusiveChannelPid = exclusiveChannelPid;
	}

	public String getExclusiveConsumerTag() {
		return exclusiveConsumerTag;
	}

	public void setExclusiveConsumerTag(String exclusiveConsumerTag) {
		this.exclusiveConsumerTag = exclusiveConsumerTag;
	}

	public Boolean isAutoDelete() {
		return autoDelete;
	}

	public void setAutoDelete(Boolean autoDelete) {
		this.autoDelete = autoDelete;
	}

	public Boolean isDurable() {
		return durable;
	}

	public void setDurable(Boolean durable) {
		this.durable = durable;
	}

	public Map<String, String> getArguments() {
		return arguments;
	}

	public void setArguments(Map<String, String> arguments) {
		this.arguments = arguments;
	}

	public long getMessages() {
		return messages;
	}

	public void setMessages(long messages) {
		this.messages = messages;
	}

	public long getMessagesReady() {
		return messagesReady;
	}

	public void setMessagesReady(long messagesReady) {
		this.messagesReady = messagesReady;
	}

	public long getMessagesUnacknowledged() {
		return messagesUnacknowledged;
	}

	public void setMessagesUnacknowledged(long messagesUnacknowledged) {
		this.messagesUnacknowledged = messagesUnacknowledged;
	}

	public long getConsumers() {
		return consumers;
	}

	public void setConsumers(long consumers) {
		this.consumers = consumers;
	}

	public long getUsedMemory() {
		return usedMemory;
	}

	public void setUsedMemory(long usedMemory) {
		this.usedMemory = usedMemory;
	}

	public Object getBackingQueueStatus() {
		return backingQueueStatus;
	}

	public void setBackingQueueStatus(Object backingQueueStatus) {
		this.backingQueueStatus = backingQueueStatus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Queue queue = (Queue) o;

		if (name != null ? !name.equals(queue.name) : queue.name != null)
			return false;
		if (vHost != null ? !vHost.equals(queue.vHost) : queue.vHost != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Queue{durable=" + durable + ", name='" + name + "', vHost='"
				+ vHost + "', autoDelete=" + autoDelete + ", arguments="
				+ arguments + '}';
	}
}
