package com.zenika.rabbitmq.management.beans.mixins;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link Permission}
 *
 * @author Colin Hebert
 */
@MixIn(Permission.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class PermissionMixIn {

	/**
	 * The name of the user
	 */
	@JsonProperty("user")
	private String user;

	/**
	 * The name of the virtual host on which the permissions are granted
	 */
	@JsonProperty("vhost")
	private String vHost;

	/**
	 * Regular expression matching resource names for which the user is granted
	 * configure permissions
	 */
	@JsonProperty("configure")
	private String configure;

	/**
	 * Regular expression matching resource names for which the user is granted
	 * write permissions
	 */
	@JsonProperty("write")
	private String write;

	/**
	 * Regular expression matching resource names for which the user is granted
	 * read permissions
	 */
	@JsonProperty("read")
	private String read;
}
