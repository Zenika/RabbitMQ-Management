package com.zenika.rabbitmq.management.beans.mixins;

import com.zenika.rabbitmq.management.beans.VHost;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link VHost}
 *
 * @author Colin Hebert
 */
@MixIn(VHost.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class VHostMixIn {
	/**
	 * Virtual host name
	 */
	@JsonProperty("name")
	private String name;
}
