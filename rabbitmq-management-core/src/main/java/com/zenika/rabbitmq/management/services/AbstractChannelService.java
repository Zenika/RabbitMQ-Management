package com.zenika.rabbitmq.management.services;

import com.zenika.rabbitmq.management.beans.Channel;

/**
 * @author Colin Hebert
 */
public abstract class AbstractChannelService implements ChannelService {
	public Channel getChannel(String channelName) {
		for (Channel channel : getChannels()) {
			if (channelName.equals(channel.getName())) {
				return channel;
			}
		}
		return null;
	}
}
