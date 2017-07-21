package jersey.sun.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestJerseyController {


	@RequestMapping("jerseyclient.do")
	@ResponseBody
		public String xx(HttpServletRequest request){
		String url=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		String PATH_NAME = "/UserInfoService/name/";
//		String PATH_AGE = "/UserInfoService/age/";
			String name = "ttt";
//			int age = 25;
			StringBuffer stringbuffer=new StringBuffer();

			ClientConfig config = new DefaultClientConfig();
			Client client = Client.create(config);
			WebResource resource = client.resource(url);

			WebResource nameResource = resource.path("jaxrs").path(PATH_NAME + name);
			stringbuffer.append("Client Response </br>"
					+ UserInfoClient.getClientResponse(nameResource));
			return stringbuffer.toString();
		}
}
