package uk.co.musetech.spring4.samples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.async.DeferredResult;
import uk.co.musetech.spring4.samples.services.DataService;

import java.util.List;

@Controller
public class MainController {

	@Autowired
	private DataService dataService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String app() {
		System.out.println("root page");
		return "root";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		System.out.println("jsp page");
		return "jsp/index";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		System.out.println("template page");
		return "templates/main";
	}

	@RequestMapping(value = "/refresh", method = RequestMethod.GET,
			consumes={"application/json"},
			produces={"application/json"})
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public DeferredResult<List<String>> refresh(){
		System.out.println("refresh data");
		DeferredResult<List<String>> deferredResult = new DeferredResult<>();
		dataService.update(deferredResult);
		return deferredResult;
	}
}
