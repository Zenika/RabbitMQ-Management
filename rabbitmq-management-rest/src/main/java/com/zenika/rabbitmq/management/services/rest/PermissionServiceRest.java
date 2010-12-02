package com.zenika.rabbitmq.management.services.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.services.AbstractPermissionService;
import com.zenika.rabbitmq.management.services.PermissionService;
import com.zenika.rabbitmq.management.services.rest.remote.PermissionServiceRemote;

/**
 * @author Colin Hebert
 */
public class PermissionServiceRest extends AbstractPermissionService implements
		PermissionService {

	private final PermissionServiceRemote permissionServiceRemote;

	private Validator validator;

	public PermissionServiceRest(
			PermissionServiceRemote permissionServiceRemote) {
		this.permissionServiceRemote = permissionServiceRemote;
	}

	public List<Permission> getPermissions() {
		return permissionServiceRemote.getPermissions();
	}

	@Override
	public Permission getPermission(String vHostName, String userName) {
		return permissionServiceRemote.getPermission(vHostName, userName);
	}

	public void putPermission(Permission permission) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(permission));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

		permissionServiceRemote.putPermission(permission.getvHost(),
				permission.getUser(), permission);
	}

	public void deletePermission(Permission permission) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(permission));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

		permissionServiceRemote.deletePermission(permission.getvHost(),
				permission.getUser());
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
}
