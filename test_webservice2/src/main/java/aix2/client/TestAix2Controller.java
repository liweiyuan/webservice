package aix2.client;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;

import aix2.server.SayHelloServiceStub;
@Controller
public class TestAix2Controller {
	private String namespace="http://axis2.soap.com";
	private String method="sayhello";
	/*http://localhost:8280/cxfdemo/cxfclient.do*/
	
	@RequestMapping("aix2client.do")
	@ResponseBody
	public String sayhelloclient(HttpServletRequest request) throws AxisFault{
        String urlpre=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        EndpointReference targetEPR = new EndpointReference(urlpre+"/services/sayHelloService");
        RPCServiceClient serviceClient = new RPCServiceClient(); 
        Options options = serviceClient.getOptions(); 
        options.setTo(targetEPR); 
        QName qname = new QName(namespace,method); 
        OMElement response = serviceClient.invokeBlocking(qname,new Object[]{"RPCServiceClient,ok"});
        return response.getFirstElement().getText();
        /*   Object[] response = serviceClient.invokeBlocking(qname, new Object[]{"aaa"}, new Class[] { String.class });
           return (String) response[0];*/
    }
	
	 @RequestMapping("aix2stub.do")
	    @ResponseBody
	    public String sayhellostubclient(HttpServletRequest request) throws Exception {
	        String urlpre=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	        SayHelloServiceStub stub = new SayHelloServiceStub(urlpre+"/services/sayHelloService.sayHelloServiceHttpSoap12Endpoint/");
	        SayHelloServiceStub.Sayhello sayhello = new SayHelloServiceStub.Sayhello();
	        sayhello.setName("stub,ok");
	        return stub.sayhello(sayhello).get_return();

	    }
}
