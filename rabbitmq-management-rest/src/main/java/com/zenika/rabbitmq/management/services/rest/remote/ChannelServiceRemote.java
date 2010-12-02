package com.zenika.rabbitmq.management.services.rest.remote;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.zenika.rabbitmq.management.beans.Channel;

@Path("channels")
public interface ChannelServiceRemote {
	/**
	 * A list of all open channels.
	 *
	 * @return
	 */
	@GET
	List<Channel> getChannels();

	/**
	 * Details about an individual channel.
	 *
	 * @param channel
	 * @return
	 */
	@GET
	@Path("{channel}")
	Channel getChannel(@PathParam("channel") String channel);
}
