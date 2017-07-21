package resteasy3.client;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
@Controller
public class TestRestEasy3Controller2 {

    
    @RequestMapping("resteasy3client2.do")
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
 
}

