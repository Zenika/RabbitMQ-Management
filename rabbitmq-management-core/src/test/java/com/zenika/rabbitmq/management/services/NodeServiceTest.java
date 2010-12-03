package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Node;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Colin Hebert
 */
public abstract class NodeServiceTest extends ServiceTest {
	private NodeService nodeService;

	@Test
	public void testGetNodes() throws Exception {
		List<Node> nodes = nodeService.getNodes();
		assertNotNull(nodes);
		assertFalse(nodes.isEmpty());
	}

	@Test
	public void testGetNode() throws Exception {
		Node firstNode = nodeService.getNodes().get(0);
		Node node = nodeService.getNode(firstNode.getName());
		assertEquals(firstNode, node);
	}

	public NodeService getNodeService() {
		return nodeService;
	}

	public void setNodeService(NodeService nodeService) {
		this.nodeService = nodeService;
	}
}
