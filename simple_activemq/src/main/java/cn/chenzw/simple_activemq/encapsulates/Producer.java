package cn.chenzw.simple_activemq.encapsulates;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {

	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private MessageProducer messageProducer;

	public Producer() {

		try {
			this.connectionFactory = new ActiveMQConnectionFactory(
					ActiveMQConnectionFactory.DEFAULT_USER,
					ActiveMQConnectionFactory.DEFAULT_PASSWORD,
					ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);
			this.connection = this.connectionFactory.createConnection();
			this.connection.start();

			this.session = this.connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			this.messageProducer = this.session.createProducer(null);

		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

	public void send() {
		try {
			Destination destination = this.session.createQueue("myQueue2");
			TextMessage msg1 = this.session.createTextMessage("Hello World!");

			/*TextMessage msg2 = this.session.createTextMessage("My name is zhangsan!");
			msg2.setStringProperty("name", "zhangsan");
			msg2.setStringProperty("age", "20");
			msg2.setStringProperty("color", "red");

			TextMessage msg3 = this.session.createTextMessage("My color is red!");
			msg3.setStringProperty("color", "red");
			msg3.setStringProperty("age", "1");*/
			
			MapMessage msg2 = this.session.createMapMessage();
			msg2.setString("name", "张三");
			msg2.setString("age", "23");
			msg2.setStringProperty("color", "red");
			msg2.setDouble("sal", 2394.5);
			
			MapMessage msg3 = this.session.createMapMessage();
			msg3.setString("name", "李四");
			msg3.setString("age", "10");
			msg3.setStringProperty("color", "red");
			msg3.setDouble("sal", 1234.3);

			this.messageProducer.send(destination, msg1,
					DeliveryMode.PERSISTENT, 2, 1000 * 60);
			this.messageProducer.send(destination, msg2,
					DeliveryMode.PERSISTENT, 2, 1000 * 60);
			this.messageProducer.send(destination, msg3,
					DeliveryMode.PERSISTENT, 2, 1000 * 60);

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Producer producer = new Producer();
		producer.send();
		producer.closeConnection();
		
	}

}
