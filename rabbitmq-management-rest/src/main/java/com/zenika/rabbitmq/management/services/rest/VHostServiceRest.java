package com.zenika.rabbitmq.management.services.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.VHost;
import com.zenika.rabbitmq.management.services.AbstractVHostService;
import com.zenika.rabbitmq.management.services.VHostService;
import com.zenika.rabbitmq.management.services.rest.remote.VHostServiceRemote;

/**
 * @author Colin Hebert
 */
public class VHostServiceRest extends AbstractVHostService implements
		VHostService {
	private final VHostServiceRemote vHostServiceRemote;

	private Validator validator;

	public VHostServiceRest(VHostServiceRemote vHostServiceRemote) {
		this.vHostServiceRemote = vHostServiceRemote;
	}

	public List<VHost> getVHosts() {
		return vHostServiceRemote.getVHosts();
	}

	@Override
	public VHost getVHost(String name) {
		return vHostServiceRemote.getVHost(name);
	}

	public void putVHost(VHost vHost) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(vHost));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

		vHostServiceRemote.putVHost(vHost.getName(), vHost);
	}

	public void deleteVHost(String name) {
		vHostServiceRemote.deleteVHost(name);
	}

	public List<Permission> getPermissions(String name) {
		return vHostServiceRemote.getPermissions(name);
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
}
