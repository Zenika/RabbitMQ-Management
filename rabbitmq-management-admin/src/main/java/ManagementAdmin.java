import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.zenika.rabbitmq.management.beans.Binding;
import com.zenika.rabbitmq.management.beans.Permission;
import com.zenika.rabbitmq.management.beans.User;
import com.zenika.rabbitmq.management.converter.toadmin.ToAdminQueue;
import com.zenika.rabbitmq.management.converter.tomanagement.ToManagementBinding;
import com.zenika.rabbitmq.management.services.*;

/**
 * @author Colin Hebert
 */
public class ManagementAdmin implements
		org.springframework.amqp.rabbit.admin.RabbitBrokerOperations {
	private final static char DESTINATION_QUEUE_CODE = com.zenika.rabbitmq.management.beans.Binding.DestinationType.queue.getCode();

	private final static char DESTINATION_EXCHANGE_CODE = com.zenika.rabbitmq.management.beans.Binding.DestinationType.exchange.getCode();

	private final static String DEFAULT_VHOST = "/";

	private BindingService bindingService;

	private ChannelService channelService;

	private ConnectionService connectionService;

	private ExchangeService exchangeService;

	private PermissionService permissionService;

	private QueueService queueService;

	private RabbitMqService rabbitMqService;

	private UserService userService;

	private VHostService vHostService;

	//TODO : What to return ?
	public com.rabbitmq.client.AMQP.Exchange.DeleteOk deleteExchange(
			String exchangeName, boolean ifUnused) {
		if (ifUnused) {
			//TODO : Check if used return null;
		}
		exchangeService.deleteExchange(DEFAULT_VHOST, exchangeName);

		return null;
	}

	public void removeBinding(org.springframework.amqp.core.Binding binding) {
		/*bindingService.deleteBinding(DEFAULT_VHOST, binding.getExchange(),
				DESTINATION_QUEUE_CODE, binding.getQueue(),
				binding.getRoutingKey());*/
	}

	public List<org.springframework.amqp.rabbit.admin.QueueInfo> getQueues() {
		List<com.zenika.rabbitmq.management.beans.Queue> queues = queueService.getQueues(
				DEFAULT_VHOST);
		List<org.springframework.amqp.rabbit.admin.QueueInfo> queueInfos = new ArrayList<org.springframework.amqp.rabbit.admin.QueueInfo>(
				queues.size());

		for (com.zenika.rabbitmq.management.beans.Queue queue : queues) {
			queueInfos.add(new ToAdminQueue(queue));
		}
		return queueInfos;
	}

	public void recoverAsync(boolean requeue) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void addUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAdmin(false);
		userService.putUser(user);
	}

	public void deleteUser(String username) {
		userService.deleteUser(username);
	}

	public void changeUserPassword(String username, String newPassword) {
		//TODO : Do I need to load previous user state ??
		User user = new User();
		user.setUsername(username);
		user.setPassword(newPassword);
		userService.putUser(user);
	}

	//TODO : Check String format
	public List<String> listUsers() {
		List<User> users = userService.getUsers();
		List<String> userAsString = new ArrayList<String>();
		for (User user : users) {
			userAsString.add(user.toString());
		}
		return userAsString;
	}

	//TODO : What does this return ?
	public int addVhost(String vhostPath) {
		com.zenika.rabbitmq.management.beans.VHost vHost = new com.zenika.rabbitmq.management.beans.VHost();
		vHost.setName(vhostPath);
		vHostService.putVHost(vHost);
		return 0;
	}

	//TODO : What does this return ?
	public int deleteVhost(String vhostPath) {
		vHostService.deleteVHost(vhostPath);
		return 0;
	}

	public void setPermissions(String username, Pattern configure, Pattern read,
			Pattern write) {
		setPermissions(username, configure, read, write, DEFAULT_VHOST);
	}

	public void setPermissions(String username, Pattern configure, Pattern read,
			Pattern write, String vhostPath) {
		Permission permission = new Permission();
		permission.setUser(username);
		permission.setConfigure(configure.pattern());
		permission.setRead(read.pattern());
		permission.setWrite(write.pattern());
		permission.setScope(Permission.Scope.all);
		permission.setvHost(vhostPath);
		permissionService.putPermission(permission);
	}

	public void clearPermissions(String username) {
		this.clearPermissions(username, DEFAULT_VHOST);
	}

	public void clearPermissions(String username, String vhostPath) {
		Permission permission = new Permission();
		permission.setUser(username);
		permission.setvHost(vhostPath);
		permissionService.deletePermission(permission);
	}

	public List<String> listPermissions() {
		return listPermissions(DEFAULT_VHOST);
	}

	public List<String> listPermissions(String vhostPath) {
		//return permissionService.getPermissions(vhostPath);
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public List<String> listUserPermissions(String username) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public void startBrokerApplication() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void stopBrokerApplication() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void startNode() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void stopNode() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void resetNode() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void forceResetNode() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public org.springframework.amqp.rabbit.admin.RabbitStatus getStatus() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public void declareExchange(
			org.springframework.amqp.core.Exchange exchange) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void deleteExchange(String exchangeName) {
		exchangeService.deleteExchange(DEFAULT_VHOST, exchangeName);
	}

	public org.springframework.amqp.core.Queue declareQueue() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public void declareQueue(org.springframework.amqp.core.Queue queue) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void deleteQueue(String queueName) {
		//Todo : Check this call
		deleteQueue(queueName, false, false);
	}

	//TODO : What are unused and empty ?
	public void deleteQueue(String queueName, boolean unused, boolean empty) {
		//queueService.deleteQueue(DEFAULT_VHOST, queueName);
	}

	//TODO : What is the noWait ?
	public void purgeQueue(String queueName, boolean noWait) {
		//queueService.deleteQueueContent(DEFAULT_VHOST, queueName);
	}

	public void declareBinding(org.springframework.amqp.core.Binding binding) {
		Binding realBinding = new ToManagementBinding(binding);
		realBinding.setvHost(DEFAULT_VHOST);
		bindingService.postBinding(realBinding);
	}
}
