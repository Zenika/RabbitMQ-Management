package com.zenika.rabbitmq.management.services.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.User;
import com.zenika.rabbitmq.management.services.AbstractUserService;
import com.zenika.rabbitmq.management.services.UserService;
import com.zenika.rabbitmq.management.services.rest.remote.UserServiceRemote;

/**
 * @author Colin Hebert
 */
public class UserServiceRest extends AbstractUserService implements
		UserService {
	private final UserServiceRemote userServiceRemote;

	private Validator validator;

	public UserServiceRest(UserServiceRemote userServiceRemote) {
		this.userServiceRemote = userServiceRemote;
	}

	public List<User> getUsers() {
		return userServiceRemote.getUsers();
	}

	@Override
	public User getUser(String name) {
		return userServiceRemote.getUser(name);
	}

	public void putUser(User user) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(user));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

		userServiceRemote.putUser(user.getUsername(), user);
	}

	public void deleteUser(String name) {
		userServiceRemote.deleteUser(name);
	}

	public List<Permission> getPermissions(String userName) {
		return userServiceRemote.getPermissions(userName);
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
}
