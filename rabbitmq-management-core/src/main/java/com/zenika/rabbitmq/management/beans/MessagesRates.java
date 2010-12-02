package com.zenika.rabbitmq.management.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Messages rates
 *
 * @author Colin Hebert
 */
public class MessagesRates implements Serializable {
	private Long rate;

	private Date lastEventDate;

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	public Date getLastEventDate() {
		return (Date) lastEventDate.clone();
	}

	public void setLastEventDate(Date lastEventDate) {
		this.lastEventDate = (Date) lastEventDate.clone();
	}

	@Override
	public String toString() {
		return "MessagesRates{rate=" + rate + ", lastEventDate=" + lastEventDate
				+ '}';
	}
}
