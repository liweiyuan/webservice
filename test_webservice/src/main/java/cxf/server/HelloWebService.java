package cxf.server;

import javax.jws.WebService;

@WebService
public interface HelloWebService {
	public String say(String value);

}
