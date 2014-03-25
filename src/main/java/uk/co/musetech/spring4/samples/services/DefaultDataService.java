package uk.co.musetech.spring4.samples.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

@Service
public class DefaultDataService implements DataService {

	private ExecutorService executorService = Executors.newFixedThreadPool(10);

	@Override
	public void update(DeferredResult<List<String>> dataHolder) {

		Future<String> futureResult = executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("going to sleep");
				Thread.sleep(5 * 1000);
				return UUID.randomUUID().toString();
			}
		});

		List<String> dataList = new ArrayList<>();
		try {
			String result = futureResult.get();
			dataList.add(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		dataHolder.setResult(dataList);
	}
}
