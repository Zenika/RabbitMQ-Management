package com.zenika.rabbitmq.management.tools;

import java.util.Map;

import com.zenika.rabbitmq.management.beans.Binding;

/**
 * @author Colin Hebert
 */
public final class RestUtils {
	private RestUtils() {
	}

	public static String getBindingIdentifier(Binding binding) {
		StringBuilder sb = new StringBuilder();
		sb.append(binding.getRoutingKey());

		for (Map.Entry<String, String> entry : binding.getArguments().entrySet()) {
			sb.append('_').append(entry.getKey()).append('_').append(
					entry.getValue()); // "_key_value"
		}

		return sb.toString();
	}
}
