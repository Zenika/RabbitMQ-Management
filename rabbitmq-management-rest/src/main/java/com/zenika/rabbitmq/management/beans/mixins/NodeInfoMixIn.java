package com.zenika.rabbitmq.management.beans.mixins;

import java.util.List;

import com.zenika.rabbitmq.management.beans.MessageStats;
import com.zenika.rabbitmq.management.beans.NodeInfo;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link NodeInfo}
 *
 * @author Colin Hebert
 */
@MixIn(NodeInfo.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class NodeInfoMixIn {
	/**
	 * Bond addresses
	 */
	@JsonProperty("bound_to")
	private List<String> bounds;

	/**
	 * Number of file descriptors currently used
	 */
	@JsonProperty("fd_used")
	private Long usedFileDescriptors;

	/**
	 * Number of available file descriptors
	 */
	@JsonProperty("fd_total")
	private Long availableFileDescriptorsCount;

	/**
	 * Memory currently used (in bytes)
	 */
	@JsonProperty("mem_used")
	private Long usedMemory;

	/**
	 * Memory available (in bytes)
	 */
	@JsonProperty("mem_total")
	private Long availableMemory;

	/**
	 * Number of processes currently started
	 */
	@JsonProperty("proc_used")
	private Long usedErlangProcesses;

	/**
	 * Number of processes available
	 */
	@JsonProperty("proc_total")
	private Long availableErlangProcesses;

	/**
	 * Statistics on messages
	 */
	@JsonProperty("message_stats")
	private List<MessageStats> messageStats;

	/**
	 * Node name
	 */
	@JsonProperty("node")
	private String nodeName;

	/**
	 *
	 */
	@JsonProperty("mem_binary")
	private Long erlangBinaryMemorySize;

	/**
	 *
	 */
	@JsonProperty("mem_ets")
	private Long erlangTermStorageMemorySize;

	/**
	 * Rabbit-MQ pid on the broker OS
	 */
	@JsonProperty("os_pid")
	private Long pid;

	/**
	 *
	 */
	@JsonProperty("statistics_level")
	private String statisticsLevel;

	/**
	 * Management plugin version
	 */
	@JsonProperty("management_version")
	private String managementVersion;
}
