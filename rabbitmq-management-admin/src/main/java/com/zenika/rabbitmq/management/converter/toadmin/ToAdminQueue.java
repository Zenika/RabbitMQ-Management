package com.zenika.rabbitmq.management.converter.toadmin;

import java.util.Arrays;

import com.zenika.rabbitmq.management.beans.Queue;
import org.springframework.amqp.rabbit.admin.QueueInfo;

/**
 * @author Colin Hebert
 */
public class ToAdminQueue extends QueueInfo {
	private final Queue queue;

	public ToAdminQueue(Queue queue) {
		this.queue = queue;
	}

	@Override
	public long getConsumers() {
		return queue.getConsumers();
	}

	@Override
	public void setConsumers(long consumers) {
		queue.setConsumers(consumers);
	}

	@Override
	public String getPid() {
		return queue.getPid();
	}

	@Override
	public void setPid(String pid) {
		queue.setPid(pid);
	}

	@Override
	public boolean isDurable() {
		return queue.isDurable();
	}

	@Override
	public void setDurable(boolean durable) {
		queue.setDurable(durable);
	}

	@Override
	public long getMessages() {
		return queue.getMessages();
	}

	@Override
	public void setMessages(long messages) {
		queue.setMessages(messages);
	}

	@Override
	public long getMemory() {
		return queue.getUsedMemory();
	}

	@Override
	public void setMemory(long memory) {
		queue.setUsedMemory(memory);
	}

	@Override
	public boolean isAutoDelete() {
		return queue.isAutoDelete();
	}

	@Override
	public void setAutoDelete(boolean autoDelete) {
		queue.setAutoDelete(autoDelete);
	}

	@Override
	public long getMessagesReady() {
		return queue.getMessagesReady();
	}

	@Override
	public void setMessagesReady(long messagesReady) {
		queue.setMessagesReady(messagesReady);
	}

	@Override
	public void setArguments(String[] args) {
		super.setArguments(
				args);	//To change body of overridden methods use File | Settings | File Templates.
	}

	@Override
	public String getName() {
		return queue.getName();
	}

	@Override
	public void setName(String name) {
		queue.setName(name);
	}

	@Override
	public long getMessagesUnacknowledged() {
		return queue.getMessagesUnacknowledged();
	}

	@Override
	public void setMessagesUnacknowledged(long messagesUnacknowledged) {
		queue.setMessagesUnacknowledged(messagesUnacknowledged);
	}

	@Override
	public String toString() {
		return "QueueInfo [name=" + getName() + ", durable=" + isDurable()
				+ ", autoDelete=" + isAutoDelete() + ", arguments="
				+ Arrays.toString(getArguments()) + ", memory=" + getMemory()
				+ ", messages=" + getMessages() + ", consumers="
				+ getConsumers() + ", transations=" + getTransactions()
				+ ", acksUncommitted=" + getAcksUncommitted()
				+ ", messagesReady=" + getMessagesReady()
				+ ", messageUncommitted=" + getMessageUncommitted()
				+ ", messagesUnacknowledged=" + getMessagesUnacknowledged()
				+ ", pid=" + getPid() + "]";
	}
}
