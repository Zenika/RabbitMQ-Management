package com.zenika.rabbitmq.management.tools;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * @author Colin Hebert
 */
public class MixInSpringScanner {

	private final Logger logger = LoggerFactory.getLogger(
			MixInSpringScanner.class);

	public MixInSpringScanner(String basePackage, ObjectMapper objectMapper) {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(
				true);
		scanner.addIncludeFilter(new AnnotationTypeFilter(MixIn.class));
		for (BeanDefinition bd : scanner.findCandidateComponents(basePackage)) {
			try {
				Class<?> clazz = Class.forName(bd.getBeanClassName());
				MixInUtil.add(clazz, objectMapper);
			}
			catch (ClassNotFoundException e) {
				if (logger.isWarnEnabled())
					logger.warn("Mixin couldn't be loaded", e);
			}
		}
	}
}
