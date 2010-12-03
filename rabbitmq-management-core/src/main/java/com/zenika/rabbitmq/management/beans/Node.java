package com.zenika.rabbitmq.management.beans;

import java.util.List;

/**
 * @author Colin Hebert
 */
public class Node {
	private String name;

	private NodeType type;

	private Boolean running;

	private Integer osPid;

	private Long erlangTermStorageMemorySize;

	private Long erlangBinaryMemorySize;

	private Long usedFileDescriptors;

	private Long availableFileDescriptorsCount;

	private Long usedMemory;

	private Long availableMemory;

	private Long usedErlangProcesses;

	private Long availableErlangProcesses;

	private String statisticsLevel;

	private String erlangVersion;

	private Long uptime;

	private Long runQueue;

	private Integer processors;

	private List<Application> applications;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NodeType getType() {
		return type;
	}

	public void setType(NodeType type) {
		this.type = type;
	}

	public Boolean getRunning() {
		return running;
	}

	public void setRunning(Boolean running) {
		this.running = running;
	}

	public Integer getOsPid() {
		return osPid;
	}

	public void setOsPid(Integer osPid) {
		this.osPid = osPid;
	}

	public Long getErlangTermStorageMemorySize() {
		return erlangTermStorageMemorySize;
	}

	public void setErlangTermStorageMemorySize(
			Long erlangTermStorageMemorySize) {
		this.erlangTermStorageMemorySize = erlangTermStorageMemorySize;
	}

	public Long getErlangBinaryMemorySize() {
		return erlangBinaryMemorySize;
	}

	public void setErlangBinaryMemorySize(Long erlangBinaryMemorySize) {
		this.erlangBinaryMemorySize = erlangBinaryMemorySize;
	}

	public Long getUsedFileDescriptors() {
		return usedFileDescriptors;
	}

	public void setUsedFileDescriptors(Long usedFileDescriptors) {
		this.usedFileDescriptors = usedFileDescriptors;
	}

	public Long getAvailableFileDescriptorsCount() {
		return availableFileDescriptorsCount;
	}

	public void setAvailableFileDescriptorsCount(
			Long availableFileDescriptorsCount) {
		this.availableFileDescriptorsCount = availableFileDescriptorsCount;
	}

	public Long getUsedMemory() {
		return usedMemory;
	}

	public void setUsedMemory(Long usedMemory) {
		this.usedMemory = usedMemory;
	}

	public Long getAvailableMemory() {
		return availableMemory;
	}

	public void setAvailableMemory(Long availableMemory) {
		this.availableMemory = availableMemory;
	}

	public Long getUsedErlangProcesses() {
		return usedErlangProcesses;
	}

	public void setUsedErlangProcesses(Long usedErlangProcesses) {
		this.usedErlangProcesses = usedErlangProcesses;
	}

	public Long getAvailableErlangProcesses() {
		return availableErlangProcesses;
	}

	public void setAvailableErlangProcesses(Long availableErlangProcesses) {
		this.availableErlangProcesses = availableErlangProcesses;
	}

	public String getStatisticsLevel() {
		return statisticsLevel;
	}

	public void setStatisticsLevel(String statisticsLevel) {
		this.statisticsLevel = statisticsLevel;
	}

	public String getErlangVersion() {
		return erlangVersion;
	}

	public void setErlangVersion(String erlangVersion) {
		this.erlangVersion = erlangVersion;
	}

	public Long getUptime() {
		return uptime;
	}

	public void setUptime(Long uptime) {
		this.uptime = uptime;
	}

	public Long getRunQueue() {
		return runQueue;
	}

	public void setRunQueue(Long runQueue) {
		this.runQueue = runQueue;
	}

	public Integer getProcessors() {
		return processors;
	}

	public void setProcessors(Integer processors) {
		this.processors = processors;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Node node = (Node) o;

		if (name != null ? !name.equals(node.name) : node.name != null)
			return false;
		if (running != null ? !running.equals(node.running) :
				node.running != null)
			return false;
		if (type != node.type)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	public static enum NodeType {
		disc, ram;
	}
}
