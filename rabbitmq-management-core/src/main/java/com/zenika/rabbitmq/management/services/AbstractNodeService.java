package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Node;

/**
 * @author Colin Hebert
 */
public abstract class AbstractNodeService implements NodeService {
	public Node getNode(String nodeName) {
		List<Node> nodes = getNodes();
		for (Node node : nodes) {
			if (node.getName().equals(nodeName))
				return node;
		}
		return null;
	}
}
