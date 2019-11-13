package com.cooperativismo.ApiRest.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cooperativismo.ApiRest.models.Mensageria;

@Service
public class RabbitMQSenderService {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${cooperativismo.rabbitmq.exchange}")
	private String exchange;

	@Value("${cooperativismo.rabbitmq.routingkey}")
	private String routingkey;
	String kafkaTopic = "java_in_use_topic";

	public void send(Mensageria mensageria) {
		amqpTemplate.convertAndSend(exchange, routingkey, mensageria);
		System.out.println("Send msg = " + mensageria);
	}

}
