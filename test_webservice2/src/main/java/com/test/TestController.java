package com.test;

import com.zchen.User;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

	@RequestMapping("hello.do")
	public void hello(){

	}

	@RequestMapping("spring-ws.do")
	@ResponseBody
	public String springwsclient(HttpServletRequest request){
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String url=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(User.class);
		WebServiceTemplate template = new WebServiceTemplate(marshaller);
		User user = new User(1, "WebServiceTemplate");
		User returnUser = (User)template.marshalSendAndReceive(url+"/service/user", user);
		return "springws-client : "+user.getUser();
	}
}
