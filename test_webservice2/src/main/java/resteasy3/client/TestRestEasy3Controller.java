package resteasy3.client;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.core.Response;
@Controller
public class TestRestEasy3Controller {
    @RequestMapping("client.do")
    public void httpurlConnection(HttpServletRequest request,HttpServletResponse hresponse) throws Exception {
        String url=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		URL restServiceURL = new URL(
				url+"/rest/RESTEasyHelloWorld/JavaCodeGeeks?queryParameter=tingyun%20RESTEasy");
		HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL
				.openConnection();
		httpConnection.setRequestMethod("GET");
		httpConnection.setRequestProperty("Accept", "application/json");
		if (httpConnection.getResponseCode() != 200) {
			throw new RuntimeException(
					"HTTP GET Request Failed with Error code : "
							+ httpConnection.getResponseCode());
		}
		BufferedReader responseBuffer = new BufferedReader(
				new InputStreamReader((httpConnection.getInputStream())));

		String output;
		String jsonStr = "";
		while ((output = responseBuffer.readLine()) != null) {
			jsonStr = output;
			hresponse.getWriter().write("rest response : "+jsonStr);
		}
		httpConnection.disconnect();
    }
    /*
    @RequestMapping("client2.do")
    public void resteasyClient(HttpServletRequest request,HttpServletResponse hresponse) throws Exception {
       try{
//    	"http://localhost:8080/restEasy3/rest/RESTEasyHelloWorld/JavaCodeGeeks?queryParameter=Enjoy%20RESTEasy");
            String url=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    	    ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target(url+"/rest/RESTEasyHelloWorld/JavaCodeGeeks?queryParameter=tingyun%20Enjoy%20RESTEasy");
            Response response = target.request().get();
            if(response.getStatus()!=200){  
               throw new RuntimeException("Failed : HTTP error code : "+response.getStatus());  
            }  
            String responseString=response.readEntity(String.class);
            hresponse.getWriter().write(responseString);
            response.close();
        }catch(Exception e){
           e.printStackTrace();
        }   
      }
 */
}

