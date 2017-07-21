package aix.client;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestAixController {
	/*http://localhost:8280/cxfdemo/cxfclient.do*/
	//客户端代理方式，需要服务端提供的接口
	@RequestMapping("AixToJava.do")
	@ResponseBody
	public String aixclient(HttpServletRequest request) throws Exception{
		 String result = "received: ";
	        try{
	            String url=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	            String endpoint = url+"/aixservices/HelloWorld?wsdl";
	            Service service = new Service();
	            Call call = (Call) service.createCall();
	            call.setTargetEndpointAddress(new java.net.URL(endpoint));
	            call.setOperationName("sayHelloWorldFrom");
	            //call.setOperationName("HelloWorld");
	            result = (String) call.invoke(new Object[]{"aaaa"});
	            System.out.println("aix client from service:"+result);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
		return result;
	}
	
}
