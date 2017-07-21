package jersey.glassfish.client;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Controller
public class TestJerseyController2 {
	@RequestMapping("jerseyclient2.do")
	@ResponseBody
		public String xx(){
			StringBuffer sb = new StringBuffer();
            String baseUri = "http://localhost:7001/test_webservice2/rest/hello";

			Client client = ClientBuilder.newClient();
            WebTarget target  = client.target(baseUri);
            Response response =  target.request(MediaType.TEXT_PLAIN)
                .get(Response.class);
           if(response.getStatus() == 200) {
              sb.append("jersey ok");
           }else{
              sb.append("jersey error");
           }
			return sb.toString();
		}
}
