package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Node;

/**
 * Node handling
 *
 * @author Colin Hebert
 */
public interface NodeService {
	public List<Node> getNodes();

	public Node getNode(String nodeName);
}
