package jaxws.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IMyService {
	@WebMethod
	public int add(int a, int b);
	@WebMethod
	public int minus(int a, int b);
}