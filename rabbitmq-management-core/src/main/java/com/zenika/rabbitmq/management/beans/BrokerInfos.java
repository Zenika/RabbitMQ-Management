package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Information on the broker
 *
 * @author Colin Hebert
 */
public class BrokerInfos implements Serializable {
	private String managementVersion;

	private String statisticsLevel;

	private List<MessageStats> messageStats;

	//TODO : Define this Object
	private Object queueTotals;

	private String node;

	private String statisticsDbNode;

	/**
	 * Bound addresses
	 */
	private List<Listener> listeners;

	public String getManagementVersion() {
		return managementVersion;
	}

	public void setManagementVersion(String managementVersion) {
		this.managementVersion = managementVersion;
	}

	public String getStatisticsLevel() {
		return statisticsLevel;
	}

	public void setStatisticsLevel(String statisticsLevel) {
		this.statisticsLevel = statisticsLevel;
	}

	public List<MessageStats> getMessageStats() {
		return messageStats;
	}

	public void setMessageStats(List<MessageStats> messageStats) {
		this.messageStats = messageStats;
	}

	public Object getQueueTotals() {
		return queueTotals;
	}

	public void setQueueTotals(Object queueTotals) {
		this.queueTotals = queueTotals;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getStatisticsDbNode() {
		return statisticsDbNode;
	}

	public void setStatisticsDbNode(String statisticsDbNode) {
		this.statisticsDbNode = statisticsDbNode;
	}

	public List<Listener> getListeners() {
		return listeners;
	}

	public void setListeners(List<Listener> listeners) {
		this.listeners = listeners;
	}

	@Override
	public String toString() {
		return "BrokerInfos{" + "node='" + node + '\'' + ", managementVersion='"
				+ managementVersion + '\'' + ", statisticsLevel='"
				+ statisticsLevel + '\'' + '}';
	}

	/**
	 * Message statistics
	 *
	 * @author Colin Hebert
	 */
	public static class MessageStats implements Serializable {
		/**
		 * Number of published messages
		 */
		private Long publishedMessagesCount;

		/**
		 * Published messages rates
		 */
		private MessagesRates publishedMessagesDetails;

		/**
		 * Number of delivered messages
		 */
		private Long deliveredMessagesCount;

		/**
		 * Delivered messages rates
		 */
		private MessagesRates deliveredMessagesRates;

		/**
		 * Number of delivered messages without Ack
		 */
		private Long deliveredNoAckMessagesCount;

		/**
		 * Delivered messages without Ack rates
		 */
		private MessagesRates deliveredNoAckMessagesRates;

		public Long getPublishedMessagesCount() {
			return publishedMessagesCount;
		}

		public void setPublishedMessagesCount(Long publishedMessagesCount) {
			this.publishedMessagesCount = publishedMessagesCount;
		}

		public MessagesRates getPublishedMessagesDetails() {
			return publishedMessagesDetails;
		}

		public void setPublishedMessagesDetails(
				MessagesRates publishedMessagesDetails) {
			this.publishedMessagesDetails = publishedMessagesDetails;
		}

		public Long getDeliveredMessagesCount() {
			return deliveredMessagesCount;
		}

		public void setDeliveredMessagesCount(Long deliveredMessagesCount) {
			this.deliveredMessagesCount = deliveredMessagesCount;
		}

		public MessagesRates getDeliveredMessagesRates() {
			return deliveredMessagesRates;
		}

		public void setDeliveredMessagesRates(
				MessagesRates deliveredMessagesRates) {
			this.deliveredMessagesRates = deliveredMessagesRates;
		}

		public Long getDeliveredNoAckMessagesCount() {
			return deliveredNoAckMessagesCount;
		}

		public void setDeliveredNoAckMessagesCount(
				Long deliveredNoAckMessagesCount) {
			this.deliveredNoAckMessagesCount = deliveredNoAckMessagesCount;
		}

		public MessagesRates getDeliveredNoAckMessagesRates() {
			return deliveredNoAckMessagesRates;
		}

		public void setDeliveredNoAckMessagesRates(
				MessagesRates deliveredNoAckMessagesRates) {
			this.deliveredNoAckMessagesRates = deliveredNoAckMessagesRates;
		}

		@Override
		public String toString() {
			return "MessageStats{publishedMessagesCount="
					+ publishedMessagesCount + ", deliveredMessagesCount="
					+ deliveredMessagesCount + ", deliveredNoAckMessagesCount="
					+ deliveredNoAckMessagesCount + '}';
		}
	}

	/**
	 * Bounds
	 */
	public static class Listener implements Serializable {
		private String node;

		private String protocol;

		private String host;

		private String ipAddress;

		private Integer port;

		public String getNode() {
			return node;
		}

		public void setNode(String node) {
			this.node = node;
		}

		public String getProtocol() {
			return protocol;
		}

		public void setProtocol(String protocol) {
			this.protocol = protocol;
		}

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public String getIpAddress() {
			return ipAddress;
		}

		public void setIpAddress(String ipAddress) {
			this.ipAddress = ipAddress;
		}

		public Integer getPort() {
			return port;
		}

		public void setPort(Integer port) {
			this.port = port;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Listener listener = (Listener) o;

			if (host != null ? !host.equals(listener.host) :
					listener.host != null)
				return false;
			if (ipAddress != null ? !ipAddress.equals(listener.ipAddress) :
					listener.ipAddress != null)
				return false;
			if (node != null ? !node.equals(listener.node) :
					listener.node != null)
				return false;
			if (port != null ? !port.equals(listener.port) :
					listener.port != null)
				return false;
			if (protocol != null ? !protocol.equals(listener.protocol) :
					listener.protocol != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			return node != null ? node.hashCode() : 0;
		}
	}
}
