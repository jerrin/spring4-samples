package uk.co.musetech.spring4.samples.services;

public interface SampleService {
	default String getMessage(){
		return "Hello world";
	}

	String greeting();
}
