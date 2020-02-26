package br.com.dojo.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.GenericMessage;

public class DojoInterceptor implements ChannelInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(DojoInterceptor.class);

	@Override
	public Message<?> preSend(final Message<?> message, final MessageChannel channel) {
		// TODO: logar passei por aqui
		return new GenericMessage<>(message.getPayload(), message.getHeaders());
	}

}
