package com.zenika.rabbitmq.management.beans.mixins;

import com.zenika.rabbitmq.management.beans.Application;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link Application}
 *
 * @author Colin Hebert
 */
@MixIn(Application.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class ApplicationMixIn {
	/**
	 * ApplicationMixIn's name
	 */
	@JsonProperty("name")
	private String name;

	/**
	 * ApplicationMixIn's description
	 */
	@JsonProperty("description")
	private String description;

	/**
	 * ApplicationMixIn's version
	 */
	@JsonProperty("version")
	private String version;
}
