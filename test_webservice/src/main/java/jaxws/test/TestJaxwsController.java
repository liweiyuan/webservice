package jaxws.test;

import jaxws.client.MyServiceImpl;
import jaxws.org.coderecord.blog.client.HelloWorldService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;


@Controller
public class TestJaxwsController {

	@RequestMapping("client.do")
	@ResponseBody
	public String helloserviceclient() throws MalformedURLException{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		URL url = new URL(basePath+"service/hello?wsdl");
		QName serviceName  = new QName("jaxws.org.coderecord.blog.server","HelloWorldServiceService");
		QName portName = new QName("jaxws.org.coderecord.blog.server", "HelloWorldServicePort");
		Service service = Service.create(url, serviceName);
		HelloWorldService hello=service.getPort(portName,HelloWorldService.class);
		return hello.sayHello("ws.Service");
	}

	@RequestMapping("client2.do")
	@ResponseBody
	public String myserviceclient2() throws MalformedURLException{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	URL url = new URL(basePath+"service/myService?wsdl");
	QName serviceName  = new QName("http://server.jaxws/","MyServiceImplService");
	QName portName = new QName("http://server.jaxws/", "MyServiceImplPort");
		Service service = Service.create(url, serviceName );
	MyServiceImpl my=service.getPort(portName,MyServiceImpl.class);
	return "myService add  "+my.add(11,100);
	}
}
