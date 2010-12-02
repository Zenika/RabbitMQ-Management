package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Information on the broker
 *
 * @author Colin Hebert
 */
public class NodeInfo implements Serializable {
	/**
	 * Bond addresses
	 */
	private List<String> bounds;

	/**
	 * Number of file descriptors currently used
	 */
	private Long usedFileDescriptors;

	/**
	 * Number of available file descriptors
	 */
	private Long availableFileDescriptorsCount;

	/**
	 * Memory currently used (in bytes)
	 */
	private Long usedMemory;

	/**
	 * Memory available (in bytes)
	 */
	private Long availableMemory;

	/**
	 * Number of processes currently started
	 */
	private Long usedErlangProcesses;

	/**
	 * Number of processes available
	 */
	private Long availableErlangProcesses;

	/**
	 * Statistics on messages
	 */
	private List<MessageStats> messageStats;

	/**
	 * Node name
	 */
	private String nodeName;

	/**
	 *
	 */
	private Long erlangBinaryMemorySize;

	/**
	 *
	 */
	private Long erlangTermStorageMemorySize;

	/**
	 * Rabbit-MQ pid on the broker OS
	 */
	private Long pid;

	/**
	 *
	 */
	private String statisticsLevel;

	/**
	 * Management plugin version
	 */
	private String managementVersion;

	public List<String> getBounds() {
		return bounds;
	}

	public void setBounds(List<String> bounds) {
		this.bounds = bounds;
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

	public List<MessageStats> getMessageStats() {
		return messageStats;
	}

	public void setMessageStats(List<MessageStats> messageStats) {
		this.messageStats = messageStats;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Long getErlangBinaryMemorySize() {
		return erlangBinaryMemorySize;
	}

	public void setErlangBinaryMemorySize(Long erlangBinaryMemorySize) {
		this.erlangBinaryMemorySize = erlangBinaryMemorySize;
	}

	public Long getErlangTermStorageMemorySize() {
		return erlangTermStorageMemorySize;
	}

	public void setErlangTermStorageMemorySize(
			Long erlangTermStorageMemorySize) {
		this.erlangTermStorageMemorySize = erlangTermStorageMemorySize;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getStatisticsLevel() {
		return statisticsLevel;
	}

	public void setStatisticsLevel(String statisticsLevel) {
		this.statisticsLevel = statisticsLevel;
	}

	public String getManagementVersion() {
		return managementVersion;
	}

	public void setManagementVersion(String managementVersion) {
		this.managementVersion = managementVersion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		NodeInfo that = (NodeInfo) o;

		if (nodeName != null ? !nodeName.equals(that.nodeName) :
				that.nodeName != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return nodeName != null ? nodeName.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "NodeInfo{nodeName='" + nodeName + "', bounds=" + bounds
				+ ",  pid=" + pid + '}';
	}
}
