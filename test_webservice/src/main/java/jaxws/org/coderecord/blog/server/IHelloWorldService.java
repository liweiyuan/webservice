package jaxws.org.coderecord.blog.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


@WebService(targetNamespace = "jaxws.org.coderecord.blog.server")
@SOAPBinding(style = Style.RPC)
public interface IHelloWorldService {
	
	 @WebMethod
	public String sayHello(String name);

}
