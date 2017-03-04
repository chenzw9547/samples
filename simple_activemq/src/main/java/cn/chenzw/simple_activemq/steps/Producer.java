package cn.chenzw.simple_activemq.steps;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {

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
		 *            是否启用事务,如果为true,则必须使用session.commit()提交事务
		 * @param acknowledgeMode
		 *            签收模式
		 */
		// 3. 通过Connection对象创建Session会话,用于接收消息
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		// 4. 通过Session创建Destination对象,Destination用于指定生产消息目标和消费消息来源的对象 。
		Destination destination = session.createQueue("myQueue");

		// 5.通过Session创建消息的发送和接收对象(生产者和消费者)
		MessageProducer messageProducer = session.createProducer(destination);

		// 6.设置生产者数据是否持久化
		messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		// 7.通过Session对象创建TextMessage形式数据,并发送数据
		for (int i = 0; i < 10; i++) {
			TextMessage textMessage = session.createTextMessage("Hello World!");
			// textMessage.setText("Hello World!");
			//messageProducer.send(textMessage);
			messageProducer.send(textMessage, DeliveryMode.PERSISTENT, i, 100000);
		}
		
		//session.commit();  //当session使用事务时,必须提交才能发送

		if (connection != null) {
			connection.close();
		}

	}

}
