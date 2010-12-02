package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;

/**
 * Logical connection between a client and the broker
 *
 * @author Colin Hebert
 */
public class Channel implements Serializable {
	/**
	 * The name of the channel
	 */
	private String name;

	/**
	 * Virtual host name
	 */
	private String vHost;

	/**
	 * Connection on which the channel is based
	 */
	private Connection connection;

	/**
	 * Id of the Erlang process associated with the connection
	 */
	private String pid;

	/**
	 * Id of the Erlang process associated with the connection to which the channel
	 * belongs
	 */
	private String connectionPid;

	/**
	 * The number of the channel, which uniquely identifies it within a connection
	 */
	private Long number;

	/**
	 * Username associated with the channel
	 */
	private String username;

	/**
	 * True if the channel is in transactional mode, false otherwise
	 */
	private Boolean transactional;

	/**
	 * Number of logical AMQP consumers retrieving messages via the channel
	 */
	private Long consumerCount;

	/**
	 * Number of messages delivered via this channel but not yet acknowledged.
	 */
	private Long messagesUnacknowledged;

	/**
	 * Number of acknowledgements received in an as yet uncommitted transaction
	 */
	private Long acksUncommitted;

	/**
	 * QoS prefetch count limit in force, 0 if unlimited
	 */
	private Long prefetchCount;

	/**
	 * Message deliveries from the server to the channel consumers blocked
	 */
	private Boolean clientFlowBlocked;

	/**
	 * Statistics on messages
	 */
	private MessageStats messageStats;

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

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
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

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean isTransactional() {
		return transactional;
	}

	public void setTransactional(Boolean transactional) {
		this.transactional = transactional;
	}

	public Long getConsumerCount() {
		return consumerCount;
	}

	public void setConsumerCount(Long consumerCount) {
		this.consumerCount = consumerCount;
	}

	public Long getMessagesUnacknowledged() {
		return messagesUnacknowledged;
	}

	public void setMessagesUnacknowledged(Long messagesUnacknowledged) {
		this.messagesUnacknowledged = messagesUnacknowledged;
	}

	public Long getAcksUncommitted() {
		return acksUncommitted;
	}

	public void setAcksUncommitted(Long acksUncommitted) {
		this.acksUncommitted = acksUncommitted;
	}

	public Long getPrefetchCount() {
		return prefetchCount;
	}

	public void setPrefetchCount(Long prefetchCount) {
		this.prefetchCount = prefetchCount;
	}

	public Boolean isClientFlowBlocked() {
		return clientFlowBlocked;
	}

	public void setClientFlowBlocked(Boolean clientFlowBlocked) {
		this.clientFlowBlocked = clientFlowBlocked;
	}

	public MessageStats getMessageStats() {
		return messageStats;
	}

	public void setMessageStats(MessageStats messageStats) {
		this.messageStats = messageStats;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Channel channel = (Channel) o;

		if (name != null ? !name.equals(channel.name) : channel.name != null)
			return false;
		if (vHost != null ? !vHost.equals(channel.vHost) :
				channel.vHost != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Channel{name='" + name + "', vHost='" + vHost
				+ "', connectionPid='" + connectionPid + "', username='"
				+ username + "', clientFlowBlocked=" + clientFlowBlocked + '}';
	}
}
