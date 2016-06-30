package cn.simple.service;

import org.springframework.stereotype.Service;

@Service
public class TestService implements ITestService {

	public String testService() {
		return "this is test service";
	}
}
