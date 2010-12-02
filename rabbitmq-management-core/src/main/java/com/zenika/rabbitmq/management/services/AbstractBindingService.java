package com.zenika.rabbitmq.management.services;

import java.util.Iterator;
import java.util.List;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.VHost;

/**
 * @author Colin Hebert
 */
public abstract class AbstractBindingService implements BindingService {
	public List<Binding> getBindings(VHost vHost) {
		return getBindings(vHost.getName());
	}

	public List<Binding> getBindings(String vHostName) {
		List<Binding> bindings = getBindings();
		for (Iterator<Binding> bindingIterator = bindings.iterator(); bindingIterator.hasNext();) {
			Binding binding = bindingIterator.next();
			if (!vHostName.equals(binding.getvHost())) {
				bindingIterator.remove();
			}
		}
		return bindings;
	}

	public List<Binding> getBindings(String vHostName, String source,
			Binding.DestinationType destinationType, String destination) {
		List<Binding> bindings = getBindings();
		for (Iterator<Binding> bindingIterator = bindings.iterator(); bindingIterator.hasNext();) {
			Binding binding = bindingIterator.next();
			if (!vHostName.equals(binding.getvHost())
					|| !source.equals(binding.getSource())
					|| destinationType != binding.getDestinationType()
					|| !destination.equals(binding.getDestination())) {
				bindingIterator.remove();
			}
		}
		return bindings;
	}

//	public Binding getBinding(String vHostName, String source,
//			Binding.DestinationType destinationType, String destination,
//			String props) {
//		for (Binding binding : getBindings()) {
//			if (!vHostName.equals(binding.getvHost())
//					&& source.equals(binding.getSource())
//					&& destinationType == binding.getDestinationType()
//					&& destination.equals(
//					binding.getDestination()) /* TODO :  && check props */) {
//				return binding;
//			}
//		}
//		return null;
//	}

	public List<Binding> getBindings(VHost vHost, String source,
			Binding.DestinationType destinationType, String destination) {
		return getBindings(vHost.getName(), source, destinationType,
				destination);
	}

//	public Binding getBinding(VHost vHost, String source,
//			Binding.DestinationType destinationType, String destination,
//			String props) {
//		return getBinding(vHost.getName(), source, destinationType, destination,
//				props);
//	}
}
