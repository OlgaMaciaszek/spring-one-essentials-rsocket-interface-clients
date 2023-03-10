package com.example.spring.one.essentials.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.messaging.rsocket.service.RSocketServiceProxyFactory;

@SpringBootApplication
public class CustomerServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}


	@Bean
	public VerificationClient verificationService(RSocketServiceProxyFactory httpServiceProxyFactory) {
		return httpServiceProxyFactory.createClient(VerificationClient.class);
	}

	@Bean
	public RSocketServiceProxyFactory httpServiceProxyFactory() {
		RSocketStrategies strategies = RSocketStrategies.builder()
				.encoders(encoders -> encoders.add(new Jackson2JsonEncoder()))
				.decoders(decoders -> decoders.add(new Jackson2JsonDecoder()))
				.build();
		RSocketRequester requester = RSocketRequester.builder()
				.rsocketStrategies(strategies)
				.tcp("localhost", 7000);
		return RSocketServiceProxyFactory.builder(requester).build();
	}

}
