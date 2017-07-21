package cxf.client;

import cxf.server.HelloWebService;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;


@Controller
public class TestCxfController {

	/*http://localhost:8280/cxfdemo/cxfclient.do*/
	//客户端代理方式，需要服务端提供的接口
	@RequestMapping("ProxyClient.do")
	@ResponseBody
	public String cxfclient(HttpServletRequest request) throws Exception{
		String urlpre=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		String url=urlpre+"/services/HelloWebService";
		JaxWsProxyFactoryBean svr=new JaxWsProxyFactoryBean();
		svr.setServiceClass(HelloWebService.class);
		svr.setAddress(url);
		HelloWebService ws=(HelloWebService) svr.create();
		return ws.say("Proxy");
	}
	
	
	@RequestMapping("DynamicClient.do")
	@ResponseBody
	public String cxfclient2(HttpServletRequest request) throws Exception{
		String urlpre=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		String url=urlpre+"/services/HelloWebService?wsdl";
	JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
    org.apache.cxf.endpoint.Client client=dcf.createClient(url);
    //url为调用webService的wsdl地址  
    QName qname=new QName("http://server.cxf/","say");
    Object[] objects=client.invoke(qname,"Dynamic");
    return objects[0].toString();
	}
	
	@RequestMapping("DynamicClientFactoryClient.do")
	@ResponseBody
	public String cxfclient3(HttpServletRequest request) throws Exception{
		String urlpre=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		String url=urlpre+"/services/HelloWebService?wsdl";
      DynamicClientFactory factory = DynamicClientFactory.newInstance();  
      org.apache.cxf.endpoint.Client client = factory.createClient(url);
      QName qname=new QName("http://server.cxf/","say");
      Object[] results=client.invoke(qname,"DynamicClientFactory"); 
      return results[0].toString();  
     
	}

}
