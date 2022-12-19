package com.example.spring.one.essentials.customerservice;

import reactor.core.publisher.Mono;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.rsocket.service.RSocketExchange;

/**
 * @author Olga Maciaszek-Sharma
 */

public interface VerificationClient {

	@RSocketExchange("verify")
	Mono<CustomerVerificationResult> verify(@Payload CustomerApplication app);

}
