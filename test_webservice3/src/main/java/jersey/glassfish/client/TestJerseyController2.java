package jersey.glassfish.client;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Controller
public class TestJerseyController2 {
	@RequestMapping("jerseyclient2.do")
	@ResponseBody
		public String jerseyGlassfish(HttpServletRequest request,HttpServletResponse hresponse){
		    String url=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		    String baseUri = url+"/jersey/hello";
			StringBuffer sb = new StringBuffer();
        	Client client = ClientBuilder.newClient();
            WebTarget target  = client.target(baseUri);
            Response response =  target.request(MediaType.TEXT_PLAIN).get(Response.class);
           if(response.getStatus() == 200) {
              sb.append("jersey ok");
           }else{
              sb.append("jersey error");
           }
			return sb.toString();
		}
}
