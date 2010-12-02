package com.zenika.rabbitmq.management.services.rest;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Channel;
import com.zenika.rabbitmq.management.services.AbstractChannelService;
import com.zenika.rabbitmq.management.services.ChannelService;
import com.zenika.rabbitmq.management.services.rest.remote.ChannelServiceRemote;

/**
 * @author Colin Hebert
 */
public class ChannelServiceRest extends AbstractChannelService implements
		ChannelService {
	private final ChannelServiceRemote channelServiceRemote;

	public ChannelServiceRest(ChannelServiceRemote channelServiceRemote) {
		this.channelServiceRemote = channelServiceRemote;
	}

	public List<Channel> getChannels() {
		return channelServiceRemote.getChannels();
	}

	@Override
	public Channel getChannel(String channelName) {
		return channelServiceRemote.getChannel(channelName);
	}
}
