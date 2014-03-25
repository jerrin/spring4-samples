package uk.co.musetech.spring4.samples.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import uk.co.musetech.spring4.samples.model.Greeting;
import uk.co.musetech.spring4.samples.model.HelloMessage;


@Controller
public class GreetingController {
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(2000);
		return new Greeting("Hello, " + message.getName() + "!");
	}
}
