package jaxws.org.coderecord.blog.server;

import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * 测试服务类<br>
 * Service注解为在使用Spring的packeage-scan功能进行自动装配<br>
 * WebService注解中可以不传递参数<br>
 * SOAPBinding中也可不传递参数，或者按照自己的需求进行更改
 */
@Service("helloWorldService")
@WebService(targetNamespace = "jaxws.org.coderecord.blog.server")
@SOAPBinding(style = Style.RPC)
public class HelloWorldService implements IHelloWorldService{

    /* 使用Spring来注入dao或service吧
    @Autowired
    private XXDao xxDao;*/
    
    /**
     * 接口方法必须加上WebMethod注解
     */
    @WebMethod
    public String sayHello(String name) {
        return "Service return "+name;
    }
}

