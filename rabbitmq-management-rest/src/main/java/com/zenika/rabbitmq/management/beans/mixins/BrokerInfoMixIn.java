package com.zenika.rabbitmq.management.beans.mixins;

import java.util.List;

import com.zenika.rabbitmq.management.beans.BrokerInfos;
import com.zenika.rabbitmq.management.beans.MessagesRates;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link com.zenika.rabbitmq.management.beans.BrokerInfos}
 *
 * @author Colin Hebert
 */
@MixIn(BrokerInfos.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class BrokerInfoMixIn {

	/**
	 * Management plugin version
	 */
	@JsonProperty("management_version")
	private String managementVersion;

	/**
	 *
	 */
	@JsonProperty("statistics_level")
	private String statisticsLevel;

	/**
	 * Statistics on messages
	 */
	@JsonProperty("message_stats")
	private List<BrokerInfos.MessageStats> messageStats;

	@JsonProperty("queue_totals")
	private Object queueTotals;

	@JsonProperty("node")
	private String node;

	@JsonProperty("statistics_db_node")
	private String statisticsDbNode;

	@JsonProperty("listeners")
	private List<BrokerInfos.Listener> listeners;

	/**
	 * MixIn annotations for {@link BrokerInfos.MessageStats}
	 *
	 * @author Colin Hebert
	 */
	@MixIn(BrokerInfos.MessageStats.class)
	@JsonAutoDetect(value = JsonMethod.NONE)
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
	public static class MessageStatsMixIn {
		/**
		 * Number of published messages
		 */
		@JsonProperty("publish")
		private Long publishedMessagesCount;

		/**
		 * Published messages rates
		 */
		@JsonProperty("publish_details")
		private MessagesRates publishedMessagesDetails;

		/**
		 * Number of delivered messages
		 */
		@JsonProperty("deliver_get")
		private Long deliveredMessagesCount;

		/**
		 * Delivered messages rates
		 */
		@JsonProperty("deliver_get_details")
		private MessagesRates deliveredMessagesRates;

		/**
		 * Number of delivered messages without Ack
		 */
		@JsonProperty("deliver_no_ack")
		private Long deliveredNoAckMessagesCount;

		/**
		 * Delivered messages without Ack rates
		 */
		@JsonProperty("deliver_no_ack_details")
		private MessagesRates deliveredNoAckMessagesRates;
	}

	/**
	 * MixIn annotations for {@link BrokerInfos.Listener}
	 *
	 * @author Colin Hebert
	 */
	@MixIn(BrokerInfos.Listener.class)
	@JsonAutoDetect(JsonMethod.NONE)
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
	public static class ListenerMixIn {
		@JsonProperty("node")
		private String node;

		@JsonProperty("protocol")
		private String protocol;

		@JsonProperty("host")
		private String host;

		@JsonProperty("ip_address")
		private String ipAddress;

		@JsonProperty("port")
		private Integer port;

	}
}
