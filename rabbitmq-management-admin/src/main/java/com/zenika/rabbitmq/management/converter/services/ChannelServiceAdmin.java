package com.zenika.rabbitmq.management.converter.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Channel;
import com.zenika.rabbitmq.management.services.AbstractChannelService;
import com.zenika.rabbitmq.management.services.ChannelService;

/**
 * @author Colin Hebert
 */
public class ChannelServiceAdmin extends AbstractChannelService implements
		ChannelService {
	public List<Channel> getChannels() {
		throw new UnsupportedOperationException("Operation not supported");
	}
}
