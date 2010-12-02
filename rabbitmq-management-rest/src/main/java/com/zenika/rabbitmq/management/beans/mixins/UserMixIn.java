package com.zenika.rabbitmq.management.beans.mixins;

import com.zenika.rabbitmq.management.beans.User;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link User}
 *
 * @author Colin Hebert
 */
@MixIn(User.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class UserMixIn {
	/**
	 * The name of the user
	 */
	@JsonProperty("name")
	private String username;

	/**
	 * The password the user uses to log in to the broker
	 */
	@JsonProperty("password")
	private String password;

	/**
	 * Administrator flag
	 */
	@JsonProperty("administrator")
	private Boolean admin;
}
