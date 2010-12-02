package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.User;

/**
 * @author Colin Hebert
 */
public abstract class AbstractUserService implements UserService {
	public List<Permission> getPermissions(User user) {
		return getPermissions(user.getUsername());
	}

	public User getUser(String username) {
		for (User user : getUsers()) {
			if (username.equals(user.getUsername())) {
				return user;
			}
		}
		return null;
	}

	public void deleteUser(User user) {
		deleteUser(user.getUsername());
	}
}
