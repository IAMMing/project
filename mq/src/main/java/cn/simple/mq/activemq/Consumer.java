package cn.simple.mq.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.google.gson.Gson;

public class Consumer {
	public static void main(String[] args) {
		ConnectionFactory factory;
		Connection connection = null;
		Session session;
		Destination destination;

		MessageConsumer consumer;

		factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD,
				"tcp://localhost:61616");

		try {
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("first");
			consumer = session.createConsumer(destination);
			while (true) {

				TextMessage message = (TextMessage) consumer.receive(5000);
				if (message == null)
					break;
				else {
					String text = message.getText();
					System.out.println(text);
					Gson gson = new Gson();
					TransferBean fromJson = gson.fromJson(text, TransferBean.class);
					System.out.println(fromJson.getId());
					System.out.println(fromJson.getName());
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
