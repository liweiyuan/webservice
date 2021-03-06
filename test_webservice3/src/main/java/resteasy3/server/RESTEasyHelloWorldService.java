package resteasy3.server;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
 
@Path("/RESTEasyHelloWorld")
public class RESTEasyHelloWorldService {
	
	@GET
	@Path("/{pathParameter}")
	public Response responseMsg( @PathParam("pathParameter") String pathParameter,
			@DefaultValue("Nothing to say") @QueryParam("queryParameter") String queryParameter) {

		String response = "Hello from: " + pathParameter + " : " + queryParameter;

		return Response.status(200).entity(response).build();
	}
 
}
