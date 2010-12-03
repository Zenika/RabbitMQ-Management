package com.zenika.rabbitmq.management.services.rest;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Node;
import com.zenika.rabbitmq.management.services.AbstractNodeService;
import com.zenika.rabbitmq.management.services.NodeService;
import com.zenika.rabbitmq.management.services.rest.remote.NodeServiceRemote;

/**
 * @author Colin Hebert
 */
public class NodeServiceRest extends AbstractNodeService implements
		NodeService {
	private final NodeServiceRemote nodeServiceRemote;

	public NodeServiceRest(NodeServiceRemote nodeServiceRemote) {
		this.nodeServiceRemote = nodeServiceRemote;
	}

	public List<Node> getNodes() {
		return nodeServiceRemote.getNodes();
	}

	@Override
	public Node getNode(String nodeName) {
		return nodeServiceRemote.getNode(nodeName);
	}
}
