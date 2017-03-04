package cn.chenzw.simple_activemq.steps;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import junit.framework.Assert;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {

	public static void main(String[] args) throws JMSException {

		// 1.建立ConnectionFactory工厂,可以配置用户名,密码以及连接地址。
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnectionFactory.DEFAULT_USER,
				ActiveMQConnectionFactory.DEFAULT_PASSWORD,
				ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL); // 等同于new
																	// ActiveMQConnectionFactory();
		// 2. 通过ConnectionFactory工厂对象创建一个Connection对象
		Connection connection = connectionFactory.createConnection();
		connection.start(); // 默认是关闭的,必须先开启

		/**
		 * @param transacted
		 *            是否启用事务
		 * @param acknowledgeMode
		 *            签收模式
		 */
		// 3. 通过Connection对象创建Session会话,用于接收消息
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		// 4. 通过Session创建Destination对象,Destination用于指定生产消息目标和消费消息来源的对象 。
		Destination destination = session.createQueue("myQueue");

		// 5.通过Session创建消息的发送和接收对象(生产者和消费者)-->此处创建消费者
		MessageConsumer messageConsumer = session.createConsumer(destination);

		while (true) {
			TextMessage tMsg = (TextMessage) messageConsumer.receive();
			if (tMsg == null)
				break;
			//tMsg.acknowledge(); //当使用Session.CLIENT_ACKNOWLEDGE模式时,必须手动签收
			Assert.assertEquals("Hello World!", tMsg.getText());
			//System.out.println(tMsg);
		}
		

		if (connection != null) {
			connection.close();
		}
	}
}
