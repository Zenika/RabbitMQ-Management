package com.zenika.rabbitmq.management.tools;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

/**
 * @author Colin Hebert
 */
public class RestEasyObjectMapperRetriever {
	private static ObjectMapper mapper;

	public static ObjectMapper getMapper() {
		if (mapper == null) {
			mapper = new ObjectMapper();
			//Manually add Jackson as a provider because RestEasy load the provider
			//twice and it's impossible to change the mapper each time

			JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();
			jacksonJsonProvider.setMapper(mapper);
			ResteasyProviderFactory resteasyProviderFactory = ResteasyProviderFactory.getInstance();
			//resteasyProviderFactory.getProvider(ResteasyJacksonProvider.class).setMapper(mapper);
			resteasyProviderFactory.addMessageBodyReader(jacksonJsonProvider);
			resteasyProviderFactory.addMessageBodyWriter(jacksonJsonProvider);
		}
		return mapper;
	}
}
