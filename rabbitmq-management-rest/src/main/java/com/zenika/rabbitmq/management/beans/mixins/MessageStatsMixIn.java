package com.zenika.rabbitmq.management.beans.mixins;

import com.zenika.rabbitmq.management.beans.MessageStats;
import com.zenika.rabbitmq.management.beans.MessagesRates;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link MessageStats}
 *
 * @author Colin Hebert
 */
@MixIn(MessageStats.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class MessageStatsMixIn {
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
