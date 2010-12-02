package com.zenika.rabbitmq.management.tools;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author Colin Hebert
 */
public class MixInUtil {
	public static void add(Class<?> mixInClass, ObjectMapper objectMapper) {
		Class<?> originalClass = getOriginalClass(mixInClass);

		objectMapper.getSerializationConfig().addMixInAnnotations(originalClass,
				mixInClass);
		objectMapper.getDeserializationConfig().addMixInAnnotations(
				originalClass, mixInClass);
	}

	public static Class<?> getOriginalClass(Class<?> mixInClass) {
		MixIn annotation = mixInClass.getAnnotation(MixIn.class);
		Class<?> originalClass = annotation.value();

		if (originalClass.equals(Void.class)) {
			if (mixInClass.getInterfaces().length == 1) {
				originalClass = mixInClass.getInterfaces()[0];
			}
			else {
				originalClass = mixInClass.getSuperclass();

				if (originalClass == null) {
					throw new IllegalArgumentException(
							"The annotation @MixIn used without parameters"
									+ "requires the MixIn class to either"
									+ "extends a particular class"
									+ "or implement one interface");
				}
			}
		}

		return originalClass;
	}
}
