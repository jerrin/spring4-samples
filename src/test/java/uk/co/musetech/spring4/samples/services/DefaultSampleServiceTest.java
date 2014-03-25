package uk.co.musetech.spring4.samples.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class DefaultSampleServiceTest {

	@Test
	public void shouldReturnGreetingMessage() throws Exception {
		SampleService sampleService = new DefaultSampleService();
		assertEquals("hello jerrin", sampleService.greeting());
	}
}