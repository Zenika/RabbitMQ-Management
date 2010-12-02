package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.User;

/**
 * @author Colin Hebert
 */
public interface UserService {
	/**
	 * List all users available on the server
	 *
	 * @return the complete user list
	 */
	List<User> getUsers();

	/**
	 * Retrieve a specific user of the server
	 *
	 * @param username The name of the user to retrieve
	 * @return the required user
	 */
	User getUser(String username);

	/**
	 * Create/update a new user onto the broker
	 *
	 * @param user User to create/update
	 */
	void putUser(User user);

	/**
	 * Delete a user from the broker
	 *
	 * @param username The name of the user to delete
	 */
	void deleteUser(String username);

	void deleteUser(User user);

	/**
	 * Lists user permissions
	 *
	 * @param userName The name of the user for which to list the permissions
	 * @return
	 */
	List<Permission> getPermissions(String userName);

	List<Permission> getPermissions(User user);
}
