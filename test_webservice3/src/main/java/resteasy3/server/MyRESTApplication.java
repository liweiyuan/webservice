package resteasy3.server;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
 

public class MyRESTApplication  extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	 
	public MyRESTApplication() {
		singletons.add(new RESTEasyHelloWorldService());
	}
 
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
