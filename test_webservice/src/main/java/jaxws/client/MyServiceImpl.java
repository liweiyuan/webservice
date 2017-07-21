
package jaxws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "MyServiceImpl", targetNamespace = "http://server.jaxws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MyServiceImpl {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://server.jaxws/", className = "jaxws.client.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://server.jaxws/", className = "jaxws.client.AddResponse")
    public int add(
            @WebParam(name = "arg0", targetNamespace = "")
                    int arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    int arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "minus", targetNamespace = "http://server.jaxws/", className = "jaxws.client.Minus")
    @ResponseWrapper(localName = "minusResponse", targetNamespace = "http://server.jaxws/", className = "jaxws.client.MinusResponse")
    public int minus(
            @WebParam(name = "arg0", targetNamespace = "")
                    int arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    int arg1);

}
