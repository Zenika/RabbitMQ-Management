package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;

/**
 * Message statistics
 *
 * @author Colin Hebert
 */
public class MessageStats implements Serializable {
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
		return "MessageStats{publishedMessagesCount=" + publishedMessagesCount
				+ ", deliveredMessagesCount=" + deliveredMessagesCount
				+ ", deliveredNoAckMessagesCount=" + deliveredNoAckMessagesCount
				+ '}';
	}
}
