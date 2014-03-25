package uk.co.musetech.spring4.samples.services;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

public interface DataService {

	void update(DeferredResult<List<String>> dataHolder);
}
