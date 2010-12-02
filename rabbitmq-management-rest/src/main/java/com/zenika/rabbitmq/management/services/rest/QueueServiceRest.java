package com.zenika.rabbitmq.management.services.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.Queue;
import com.zenika.rabbitmq.management.services.AbstractQueueService;
import com.zenika.rabbitmq.management.services.QueueService;
import com.zenika.rabbitmq.management.services.rest.remote.QueueServiceRemote;

/**
 * @author Colin Hebert
 */
public class QueueServiceRest extends AbstractQueueService implements
		QueueService {
	private final QueueServiceRemote queueServiceRemote;

	private Validator validator;

	public QueueServiceRest(QueueServiceRemote queueServiceRemote) {
		this.queueServiceRemote = queueServiceRemote;
	}

	public List<Queue> getQueues() {
		return queueServiceRemote.getQueues();
	}

	@Override
	public List<Queue> getQueues(String vHostName) {
		return queueServiceRemote.getQueues(vHostName);
	}

	public Queue getQueue(String vHostName, String queueName) {
		return queueServiceRemote.getQueue(vHostName, queueName);
	}

	public void putQueue(Queue queue) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(queue));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

		queueServiceRemote.putQueue(queue.getvHost(), queue.getName(), queue);
	}

	public void deleteQueue(Queue queue) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(queue));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

		queueServiceRemote.deleteQueue(queue.getvHost(), queue.getName());
	}

	public List<Binding> getBindings(Queue queue) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(queue));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

		return queueServiceRemote.getBindings(queue.getvHost(),
				queue.getName());
	}

	public void deleteQueueContent(Queue queue) {
		Set<ConstraintViolation<?>> constraintViolations = new HashSet<ConstraintViolation<?>>();
		constraintViolations.addAll(validator.validate(queue));
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

		queueServiceRemote.deleteQueueContent(queue.getvHost(),
				queue.getName());
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
}
