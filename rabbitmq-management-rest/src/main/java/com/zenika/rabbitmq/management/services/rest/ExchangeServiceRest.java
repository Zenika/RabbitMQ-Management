package com.zenika.rabbitmq.management.services.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.Exchange;
import com.zenika.rabbitmq.management.services.AbstractExchangeService;
import com.zenika.rabbitmq.management.services.ExchangeService;
import com.zenika.rabbitmq.management.services.rest.remote.ExchangeServiceRemote;

/**
 * @author Colin Hebert
 */
public class ExchangeServiceRest extends AbstractExchangeService implements
		ExchangeService {
	private final ExchangeServiceRemote exchangeServiceRemote;

	private Validator validator;

	public ExchangeServiceRest(ExchangeServiceRemote exchangeServiceRemote) {
		this.exchangeServiceRemote = exchangeServiceRemote;
	}

	public List<Exchange> getExchanges() {
		return exchangeServiceRemote.getExchanges();
	}

	@Override
	public List<Exchange> getExchanges(String vHostName) {
		return exchangeServiceRemote.getExchanges(vHostName);
	}

	@Override
	public Exchange getExchange(String vHostName, String exchangeName) {
		return exchangeServiceRemote.getExchange(vHostName, exchangeName);
	}

	public void putExchange(Exchange exchange) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(exchange));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

		exchangeServiceRemote.putExchange(exchange.getvHost(),
				exchange.getName(), exchange);
	}

	public void deleteExchange(String vHostName, String exchangeName) {
		exchangeServiceRemote.deleteExchange(vHostName, exchangeName);
	}

	public List<Binding> getBindingsSource(Exchange exchange) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(exchange));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
		return exchangeServiceRemote.getBindingsSource(exchange.getvHost(),
				exchange.getName());
	}

	public List<Binding> getBindingsDestination(Exchange exchange) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(exchange));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

		return exchangeServiceRemote.getBindingsDestination(exchange.getvHost(),
				exchange.getName());
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
}
