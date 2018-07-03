package service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import service.business.Rate;

@RestController
@RequestMapping("/transaction")
public class TestController {
	
	@GetMapping("/hello")
	public String hello() {
		
		RestTemplate rest = new RestTemplate();
		Rate rate = rest.getForObject("http://localhost:8001/taux-change/rates/10001", Rate.class);
		
		return rate.toString();
	}
	
}
