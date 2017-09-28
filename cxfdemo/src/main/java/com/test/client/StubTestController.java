package com.test.client;

import cxf.stub.HelloWebService;
import cxf.stub.HelloWebServiceImplService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*import stubsss.HelloWebService;
import stubsss.HelloWebServiceService;*/

@Controller
public class StubTestController {

	 	@RequestMapping("StubClient.do")
	@ResponseBody
	public String cxfclientstub(){
		HelloWebService hello=new HelloWebServiceImplService().getHelloWebServiceImplPort();
		return hello.say("stub");
	}
}
