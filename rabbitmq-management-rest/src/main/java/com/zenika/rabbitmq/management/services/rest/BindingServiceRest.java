package com.zenika.rabbitmq.management.services.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.services.AbstractBindingService;
import com.zenika.rabbitmq.management.services.BindingService;
import com.zenika.rabbitmq.management.services.rest.remote.BindingServiceRemote;
import com.zenika.rabbitmq.management.tools.RestUtils;

/**
 * @author Colin Hebert
 */
public class BindingServiceRest extends AbstractBindingService implements
		BindingService {
	private final BindingServiceRemote bindingServiceRemote;

	private Validator validator;

	public BindingServiceRest(BindingServiceRemote bindingServiceRemote) {
		this.bindingServiceRemote = bindingServiceRemote;
	}

	public List<Binding> getBindings() {
		return bindingServiceRemote.getBindings();
	}

	@Override
	public List<Binding> getBindings(String vHost) {
		return bindingServiceRemote.getBindings(vHost);
	}

	@Override
	public List<Binding> getBindings(String vHost, String source,
			Binding.DestinationType destinationType, String destination) {
		return bindingServiceRemote.getBindings(vHost, source,
				destinationType.getCode(), destination);
	}

	public void postBinding(Binding binding) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(binding));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

		bindingServiceRemote.postBinding(binding.getvHost(),
				binding.getSource(), binding.getDestinationType().getCode(),
				binding.getDestination(), binding);
	}

	public Binding getBinding(String vHost, String source,
			Binding.DestinationType destinationType, String destination,
			String props) {
		return bindingServiceRemote.getBinding(vHost, source,
				destinationType.getCode(), destination, props);
	}

	public void putBinding(Binding binding) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(binding));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

		bindingServiceRemote.putBinding(binding.getvHost(), binding.getSource(),
				binding.getDestinationType().getCode(),
				binding.getDestination(),
				RestUtils.getBindingIdentifier(binding), binding);
	}

	public void deleteBinding(Binding binding) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(binding));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

		bindingServiceRemote.deleteBinding(binding.getvHost(),
				binding.getSource(), binding.getDestinationType().getCode(),
				binding.getDestination(),
				RestUtils.getBindingIdentifier(binding));
	}

//	/**
//	 * @see #getBinding(com.zenika.rabbitmq.management.beans.VHost, String, com.zenika.rabbitmq.management.beans.Binding.DestinationType, String, String)
//	 */
//	Binding getBinding(String vHostName, String source,
//			Binding.DestinationType destinationType, String destination,
//			String props);
//
//	/**
//	 * Get a specific binding
//	 * @param vHost VirtualHost
//	 * @param source Source name
//	 * @param destinationType Kind of destination (Exchange or Queue)
//	 * @param destination Destination name
//	 * @param props
//	 * @return
//	 */
//	Binding getBinding(VHost vHost, String source,
//			Binding.DestinationType destinationType, String destination,
//			String props);

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
}
