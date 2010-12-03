package com.zenika.rabbitmq.management.beans.mixins;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Application;
import com.zenika.rabbitmq.management.beans.Node;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author Colin Hebert
 */
@MixIn(Node.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class NodeMixIn {
	@JsonProperty("name")
	private String name;

	@JsonProperty("type")
	private Node.NodeType type;

	@JsonProperty("running")
	private Boolean running;

	@JsonProperty("os_pid")
	private Integer osPid;

	@JsonProperty("mem_ets")
	private Long erlangTermStorageMemorySize;

	@JsonProperty("mem_binary")
	private Long erlangBinaryMemorySize;

	@JsonProperty("fd_used")
	private Long usedFileDescriptors;

	@JsonProperty("fd_total")
	private Long availableFileDescriptorsCount;

	@JsonProperty("mem_used")
	private Long usedMemory;

	@JsonProperty("mem_limit")
	private Long availableMemory;

	@JsonProperty("proc_used")
	private Long usedErlangProcesses;

	@JsonProperty("proc_total")
	private Long availableErlangProcesses;

	@JsonProperty("statistics_level")
	private String statisticsLevel;

	@JsonProperty("erlang_version")
	private String erlangVersion;

	@JsonProperty("uptime")
	private Long uptime;

	@JsonProperty("run_queue")
	private Long runQueue;

	@JsonProperty("processors")
	private Integer processors;

	@JsonProperty("applications")
	private List<Application> applications;
}
