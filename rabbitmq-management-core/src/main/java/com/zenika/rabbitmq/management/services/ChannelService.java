package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Channel;

/**
 * @author Colin Hebert
 */
public interface ChannelService {
	/**
	 * A list of all open channels.
	 *
	 * @return
	 */
	List<Channel> getChannels();

	/**
	 * Details about an individual channel.
	 *
	 * @param channelName
	 * @return
	 */
	Channel getChannel(String channelName);
}
