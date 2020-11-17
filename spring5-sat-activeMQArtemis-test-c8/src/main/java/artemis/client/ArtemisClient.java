package artemis.client;


import java.util.Date;

import javax.jms.DeliveryMode;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;

import org.apache.activemq.artemis.api.jms.ActiveMQJMSClient;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionForContextImpl;
import org.apache.activemq.artemis.jms.client.ActiveMQSession;
import org.apache.activemq.artemis.jms.client.ActiveMQTextMessage;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import artemis.bean.Order;
import artemis.bean.User;

public class ArtemisClient {
	
	@Test
	public void sendMessageTest() throws JsonProcessingException, JMSException {
		// Instantiate the queue
	    Queue queue = ActiveMQJMSClient.createQueue("taco.message.order.queue.string");

	    // Instantiate the ConnectionFactory (Using the default URI on this case)
	    // Also instantiate the jmsContext
	    // Using closeable interface
	    try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616","sat","123456");
			JMSContext jmsContext = cf.createContext()) {
			
			Order order = new Order();
			User user = new User("sat","pwd","satfull","street1","city","1","zip1","1123424242");
			user.setId(1001L);
			
			order.setId(21111L);
			order.setName("test");
			order.setPlacedAt(new Date());
			order.setUser(user);
			
			//将object转为json String
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(order);
			
			Message message = jmsContext.createTextMessage(jsonString);
			//给消息设置_typeId属性，以便在springboot端能通过转换器转换
			//不加这个在接收端也能转换，但是会有异常导致程序终止
			message.setStringProperty("_typeId", "order");
			
			jmsContext.createProducer().setDeliveryMode(DeliveryMode.PERSISTENT).send(queue, message);
			
			
			// Create a message producer, note that we can chain all this into one statement
//			jmsContext.createProducer().setDeliveryMode(DeliveryMode.PERSISTENT).send(queue, order);
			
			// Create a Consumer and receive the payload of the message direct.
//			String payLoad = jmsContext.createConsumer(queue).receiveBody(String.class);
			
//			System.out.println("payLoad = " + payLoad);

	      }
	}
	
}
