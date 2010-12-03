package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;

/**
 * Physical connection between a client and the broker
 *
 * @author Colin Hebert
 */
public class Connection implements Serializable {
	/**
	 * The name of the connection
	 */
	private String name;

	/**
	 * Node where the connection is
	 */
	private String node;

	/**
	 * Virtual host name
	 */
	private String vHost;

	/**
	 * Id of the Erlang process associated with the connection
	 */
	private String pid;

	/**
	 * Server IP address
	 */
	private String serverAddress;

	/**
	 * Server port
	 */
	private Integer serverPort;

	/**
	 * Peer address
	 */
	private String peerAddress;

	/**
	 * Peer port
	 */
	private Integer peerPort;

	/**
	 * SSL activation
	 */
	private Boolean ssl;

	/**
	 * The subject of the peer's SSL certificate
	 */
	private String peerCertSubject;

	/**
	 * The issuer of the peer's SSL certificate
	 */
	private String peerCertIssuer;

	/**
	 * The period for which the peer's SSL certificate is valid
	 */
	private String peerCertValidity;

	/**
	 * Version of the AMQP protocol in use
	 */
	private String protocolVersion;

	/**
	 * Username associated with the connection
	 */
	private String username;

	/**
	 * Connection timeout
	 */
	private Long timeout;

	/**
	 * Maximum frame size (bytes)
	 */
	private Long maxFrameSize;

	/**
	 * Informational properties transmitted by the client during connection
	 * establishment
	 */
	private ClientProperties clientProperties;

	/**
	 * Octets received
	 */
	private Long octetsReceived;

	/**
	 * Packets received
	 */
	private Long packetsReceived;

	/**
	 * Octets sent
	 */
	private Long octetsSent;

	/**
	 * Packets sent
	 */
	private Long packetsSent;

	/**
	 * Send queue size
	 */
	private Long sendQueueSize;

	/**
	 * Connection state
	 */
	private State state;

	/**
	 * Channels count
	 */
	private Long channels;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getvHost() {
		return vHost;
	}

	public void setvHost(String vHost) {
		this.vHost = vHost;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public String getPeerAddress() {
		return peerAddress;
	}

	public void setPeerAddress(String peerAddress) {
		this.peerAddress = peerAddress;
	}

	public Integer getPeerPort() {
		return peerPort;
	}

	public void setPeerPort(Integer peerPort) {
		this.peerPort = peerPort;
	}

	public Boolean getSsl() {
		return ssl;
	}

	public void isSsl(Boolean ssl) {
		this.ssl = ssl;
	}

	public String getPeerCertSubject() {
		return peerCertSubject;
	}

	public void setPeerCertSubject(String peerCertSubject) {
		this.peerCertSubject = peerCertSubject;
	}

	public String getPeerCertIssuer() {
		return peerCertIssuer;
	}

	public void setPeerCertIssuer(String peerCertIssuer) {
		this.peerCertIssuer = peerCertIssuer;
	}

	public String getPeerCertValidity() {
		return peerCertValidity;
	}

	public void setPeerCertValidity(String peerCertValidity) {
		this.peerCertValidity = peerCertValidity;
	}

	public String getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getTimeout() {
		return timeout;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

	public Long getMaxFrameSize() {
		return maxFrameSize;
	}

	public void setMaxFrameSize(Long maxFrameSize) {
		this.maxFrameSize = maxFrameSize;
	}

	public ClientProperties getClientProperties() {
		return clientProperties;
	}

	public void setClientProperties(ClientProperties clientProperties) {
		this.clientProperties = clientProperties;
	}

	public Long getOctetsReceived() {
		return octetsReceived;
	}

	public void setOctetsReceived(Long octetsReceived) {
		this.octetsReceived = octetsReceived;
	}

	public Long getPacketsReceived() {
		return packetsReceived;
	}

	public void setPacketsReceived(Long packetsReceived) {
		this.packetsReceived = packetsReceived;
	}

	public Long getOctetsSent() {
		return octetsSent;
	}

	public void setOctetsSent(Long octetsSent) {
		this.octetsSent = octetsSent;
	}

	public Long getPacketsSent() {
		return packetsSent;
	}

	public void setPacketsSent(Long packetsSent) {
		this.packetsSent = packetsSent;
	}

	public Long getSendQueueSize() {
		return sendQueueSize;
	}

	public void setSendQueueSize(Long sendQueueSize) {
		this.sendQueueSize = sendQueueSize;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Long getChannels() {
		return channels;
	}

	public void setChannels(Long channels) {
		this.channels = channels;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Connection that = (Connection) o;

		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (vHost != null ? !vHost.equals(that.vHost) : that.vHost != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Connection{name='" + name + "', node='" + node + "', vHost='"
				+ vHost + "', serverAddress='" + serverAddress + ':'
				+ serverPort + "', peerAddress='" + peerAddress + ':' + peerPort
				+ "', state=" + state + ", username='" + username + "'}";
	}

	/**
	 * Additional properties on a client
	 */
	public static class ClientProperties implements Serializable {
		/**
		 * Client software
		 */
		private String product;

		/**
		 * Client platform
		 */
		private String platform;

		/**
		 * Additional informations
		 */
		private String informations;

		/**
		 * Client copyright
		 */
		private String copyright;

		/**
		 * Client version
		 */
		private String version;

		public String getProduct() {
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
		}

		public String getPlatform() {
			return platform;
		}

		public void setPlatform(String platform) {
			this.platform = platform;
		}

		public String getInformations() {
			return informations;
		}

		public void setInformations(String informations) {
			this.informations = informations;
		}

		public String getCopyright() {
			return copyright;
		}

		public void setCopyright(String copyright) {
			this.copyright = copyright;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			ClientProperties that = (ClientProperties) o;

			if (platform != null ? !platform.equals(that.platform) :
					that.platform != null)
				return false;
			if (product != null ? !product.equals(that.product) :
					that.product != null)
				return false;
			if (version != null ? !version.equals(that.version) :
					that.version != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			return product != null ? product.hashCode() : 0;
		}

		@Override
		public String toString() {
			return "ClientProperties{product='" + product + "', platform='"
					+ platform + "', version='" + version + "'}";
		}
	}

	/**
	 * Differents states accessible for a connection
	 */
	public static enum State {
		starting,
		tuning,
		opening,
		running,
		closing,
		closed
	}
}
