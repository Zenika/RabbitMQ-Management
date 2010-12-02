package com.zenika.rabbitmq.management.services;

import java.util.List;

import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.VHost;

/**
 * @author Colin Hebert
 */
public abstract class AbstractVHostService implements VHostService {
	public void deleteVHost(VHost vHost) {
		deleteVHost(vHost.getName());
	}

	public List<Permission> getPermissions(VHost vHost) {
		return getPermissions(vHost.getName());
	}

	public VHost getVHost(String vHostName) {
		for (VHost vHost : getVHosts()) {
			if (vHostName.equals(vHost.getName())) {
				return vHost;
			}
		}
		return null;
	}
}
