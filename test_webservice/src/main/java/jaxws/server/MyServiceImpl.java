package jaxws.server;

import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("myService")
@WebService
public class MyServiceImpl implements IMyService {
	public int add(int a, int b) {
		return a + b;
	}

	public int minus(int a, int b) {
		return a - b;
	}
}