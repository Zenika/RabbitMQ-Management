package com.zenika.rabbitmq.management.beans.mixins;

import com.zenika.rabbitmq.management.beans.Connection;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link Connection}
 *
 * @author Colin Hebert
 */
@MixIn(Connection.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class ConnectionMixIn {
	/**
	 * The name of the connection
	 */
	@JsonProperty("name")
	private String name;

	@JsonProperty("node")
	private String node;

	/**
	 * Virtual host name
	 */
	@JsonProperty("vhost")
	private String vHost;

	/**
	 * Id of the Erlang process associated with the connection
	 */
	@JsonProperty("pid")
	private String pid;

	/**
	 * Server IP address
	 */
	@JsonProperty("address")
	private String serverAddress;

	/**
	 * Server port
	 */
	@JsonProperty("port")
	private Integer serverPort;

	/**
	 * Peer address
	 */
	@JsonProperty("peer_address")
	private String peerAddress;

	/**
	 * Peer port
	 */
	@JsonProperty("peer_port")
	private Integer peerPort;

	/**
	 * SSL activation
	 */
	@JsonProperty("ssl")
	private Boolean ssl;

	/**
	 * The subject of the peer's SSL certificate
	 */
	@JsonProperty("peer_cert_subject")
	private String peerCertSubject;

	/**
	 * The issuer of the peer's SSL certificate
	 */
	@JsonProperty("peer_cert_issuer")
	private String peerCertIssuer;

	/**
	 * The period for which the peer's SSL certificate is valid
	 */
	@JsonProperty("peer_cert_validity")
	private String peerCertValidity;

	/**
	 * Version of the AMQP protocol in use
	 */
	@JsonProperty("protocol")
	private String protocolVersion;

	/**
	 * Username associated with the connection
	 */
	@JsonProperty("user")
	private String username;

	/**
	 * Connection timeout
	 */
	@JsonProperty("timeout")
	private Long timeout;

	/**
	 * Maximum frame size (bytes)
	 */
	@JsonProperty("frame_max")
	private Long maxFrameSize;

	/**
	 * Informational properties transmitted by the client during connection
	 * establishment
	 */
	@JsonProperty("client_properties")
	private Connection.ClientProperties clientProperties;

	/**
	 * Octets received
	 */
	@JsonProperty("recv_oct")
	private Long octetsReceived;

	/**
	 * Packets received
	 */
	@JsonProperty("recv_cnt")
	private Long packetsReceived;

	/**
	 * Octets sent
	 */
	@JsonProperty("send_oct")
	private Long octetsSent;

	/**
	 * Packets sent
	 */
	@JsonProperty("send_cnt")
	private Long packetsSent;

	/**
	 * Send queue size
	 */
	@JsonProperty("send_pend")
	private Long sendQueueSize;

	/**
	 * Connection state
	 */
	@JsonProperty("state")
	private Connection.State state;

	/**
	 * Channels count
	 */
	@JsonProperty("channels")
	private Long channels;

	@MixIn(Connection.ClientProperties.class)
	public static class ClientPropertiesMixin {

		/**
		 * Client software
		 */
		@JsonProperty("product")
		private String product;

		/**
		 * Client platform
		 */
		@JsonProperty("platform")
		private String platform;

		/**
		 * Additional informations
		 */
		@JsonProperty("information")
		private String informations;

		/**
		 * Client copyright
		 */
		@JsonProperty("copyright")
		private String copyright;

		/**
		 * Client version
		 */
		@JsonProperty("version")
		private String version;
	}
}
