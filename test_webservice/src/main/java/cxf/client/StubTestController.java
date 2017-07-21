package cxf.client;

import cxf.stub.HelloWebService;
import cxf.stub.HelloWebServiceImplService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StubTestController {

	 	@RequestMapping("StubClient.do")
	@ResponseBody
	public String cxfclientstub(){
		HelloWebService hello=new HelloWebServiceImplService().getHelloWebServiceImplPort();
		return hello.say("stub");
	}
}
