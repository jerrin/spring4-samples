package uk.co.musetech.spring4.samples.services;

public class DefaultSampleService implements SampleService {

	@Override
	public String greeting() {
		return "hello jerrin";
	}
}
