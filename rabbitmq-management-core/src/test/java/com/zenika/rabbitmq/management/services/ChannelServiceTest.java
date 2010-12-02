package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Channel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * @author Colin Hebert
 */
public abstract class ChannelServiceTest extends ServiceTest {
	private ChannelService channelService;

	private com.rabbitmq.client.Connection rabbitConnection;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		rabbitConnection = getConnectionFactory().createConnection();
	}

	@After
	public void tearDownConnection() throws Exception {
		rabbitConnection.abort();
	}

	@Test
	public void testGetChannels() throws Exception {
		List<Channel> channelList;
		channelList = channelService.getChannels();
		assertEquals(0, channelList.size());

		rabbitConnection.createChannel();
		rabbitConnection.createChannel();
		rabbitConnection.createChannel();

		channelList = channelService.getChannels();
		assertEquals(3, channelList.size());
	}

	@Test
	public void testGetChannel() throws Exception {
		rabbitConnection.createChannel();

		Channel originalChannel = channelService.getChannels().get(0);
		assertNotNull(originalChannel);

		Channel channel = channelService.getChannel(originalChannel.getName());
		assertEquals(originalChannel, channel);
	}

	public ChannelService getChannelService() {
		return channelService;
	}

	public void setChannelService(ChannelService channelService) {
		this.channelService = channelService;
	}

}
