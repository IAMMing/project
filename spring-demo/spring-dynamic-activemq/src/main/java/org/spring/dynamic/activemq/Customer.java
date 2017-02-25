package org.spring.dynamic.activemq;

import javax.jms.Destination;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class Customer {
	private static Boolean listener = true;
	private static Integer index = 0;

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("activemq-context.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) applicationContext.getBean("jmsTemplate");

		System.out.println("初始化消息消费者");

		customerWorker(jmsTemplate);
		System.out.println(listener);
		try {
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listener = true;
		customerWorker(jmsTemplate);
	}

	private static void customerWorker(JmsTemplate jmsTemplate) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (listener) {
					if (index == 2) {
						listener = false;
					}
					System.out.println(index);
					try {
						TextMessage txtmsg = (TextMessage) jmsTemplate.receive("first");
						if (null != txtmsg) {
							System.out.println("[DB Proxy] " + txtmsg);
							System.out.println("[DB Proxy] 收到消息内容为: " + txtmsg.getText());
						} else
							break;
					} catch (Exception e) {
						e.printStackTrace();
					}
					index++;

				}
			}
		}).start();
	}

}
