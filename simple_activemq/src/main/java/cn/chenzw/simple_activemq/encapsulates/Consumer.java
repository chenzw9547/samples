package cn.chenzw.simple_activemq.encapsulates;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {

	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private MessageConsumer messageConsumer;
	private Destination destination;

	public Consumer() {
		try {
			this.connectionFactory = new ActiveMQConnectionFactory(
					ActiveMQConnectionFactory.DEFAULT_USER,
					ActiveMQConnectionFactory.DEFAULT_PASSWORD,
					ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);

			this.connection = this.connectionFactory.createConnection();
			this.connection.start();

			this.session = this.connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			this.destination = this.session.createQueue("myQueue2");
			//此处增加了messageSelector过滤器
			this.messageConsumer = this.session.createConsumer(
					this.destination, "color='red' and sal > 1500");

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void receive() {
		try {
			//使用监听回调方式
			this.messageConsumer.setMessageListener(new ConsumerLinster());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	class ConsumerLinster implements MessageListener {

		public void onMessage(Message message) {
			/* if (message instanceof TextMessage) {} */
			MapMessage mapMsg = null;
			if (message instanceof MapMessage) {
				mapMsg = (MapMessage) message;
				try {
					System.out.println(mapMsg.getString("name") + "@@"
							+ mapMsg.getString("age"));
					System.out.println(message);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		Consumer consumer = new Consumer();
		consumer.receive();
		// consumer.closeConnection();
	}

}
