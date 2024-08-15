package com.praneeth_works.learning.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@PostMapping("/test_headers")
	public void getHeaders(@RequestHeader(name="name") String name) {
		System.out.println(name);
		
	}

}
