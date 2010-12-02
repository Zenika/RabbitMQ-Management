package com.zenika.rabbitmq.management.tools;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;

/**
 * @author Colin Hebert
 */
public class WthWhyThisClassDoesntAlreadyExist {

	private HttpClient httpClient;

	public WthWhyThisClassDoesntAlreadyExist(String userId, String password) {
		httpClient = new HttpClient();

		Credentials credentials = new UsernamePasswordCredentials(userId,
				password);
		httpClient.getState().setCredentials(AuthScope.ANY, credentials);
		httpClient.getParams().setAuthenticationPreemptive(true);
	}

	public HttpClient getHttpClient() {
		return httpClient;
	}
}
