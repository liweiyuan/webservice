package resteasy.client;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class TestRestEasyController {

    @RequestMapping("resteasyclient2.do")
    public void restclient(HttpServletRequest request,HttpServletResponse hresponse) throws Exception {
        String url=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        ClientRequest clientRequest = new ClientRequest(
                url+"/rest/userservice/users");
        clientRequest.accept("application/json");
        ClientResponse<String> response = clientRequest.get(String.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                new ByteArrayInputStream(response.getEntity().getBytes())));
        String output;
        while ((output = br.readLine()) != null) {
            hresponse.getWriter().write("rest response : " + output);
        }
    }

    @RequestMapping("resteasyclient.do")
    public void xxx(HttpServletRequest request,HttpServletResponse hresponse) throws Exception {
        String url=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

        URL restServiceURL = new URL(url+"/rest/userservice/user/trans/tingyun");

        HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
        httpConnection.setRequestMethod("GET");
        httpConnection.setRequestProperty("Accept", "application/json");
        if (httpConnection.getResponseCode() != 200) {
            throw new RuntimeException("HTTP GET Request Failed with Error code : "
                    + httpConnection.getResponseCode());
        }
        BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                (httpConnection.getInputStream())));
        String output;
        while ((output = responseBuffer.readLine()) != null) {
            hresponse.getWriter().write("rest response : " + output);
        }
        httpConnection.disconnect();
    }
}

