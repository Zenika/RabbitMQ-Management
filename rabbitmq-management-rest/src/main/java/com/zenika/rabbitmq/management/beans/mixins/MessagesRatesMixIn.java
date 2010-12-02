package com.zenika.rabbitmq.management.beans.mixins;

import java.util.Date;

import com.zenika.rabbitmq.management.beans.MessagesRates;
import com.zenika.rabbitmq.management.tools.MixIn;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * MixIn annotations for {@link MessagesRates}
 *
 * @author Colin Hebert
 */
@MixIn(MessagesRates.class)
@JsonAutoDetect(value = JsonMethod.NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class MessagesRatesMixIn {
	@JsonProperty("rate")
	private Long rate;

	@JsonProperty("last_event")
	private Date lastEventDate;
}
