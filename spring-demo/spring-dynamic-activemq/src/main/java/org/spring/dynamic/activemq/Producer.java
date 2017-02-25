package org.spring.dynamic.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Producer {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("activemq-context.xml");
		JmsTemplate template = (JmsTemplate) applicationContext.getBean("jmsTemplate");
		MessageCreator messageCreator=new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("发送消息：Hello ActiveMQ Text Message2！");
			}
		};
		for (int i = 0; i < 20; i++) {
			
			template.send("first", messageCreator);
			System.out.println("成功发送了一条JMS消息");
			try {
				Thread.sleep(10 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
