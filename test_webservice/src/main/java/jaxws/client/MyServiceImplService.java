
package jaxws.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "MyServiceImplService", targetNamespace = "http://server.jaxws/", wsdlLocation = "http://localhost:8080/test_webservice/service/myservice?wsdl")
public class MyServiceImplService
    extends Service
{

    private final static URL MYSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(MyServiceImplService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = MyServiceImplService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/test_webservice/service/myservice?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/test_webservice/service/myservice?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        MYSERVICEIMPLSERVICE_WSDL_LOCATION = url;
    }

    public MyServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MyServiceImplService() {
        super(MYSERVICEIMPLSERVICE_WSDL_LOCATION, new QName("http://server.jaxws/", "MyServiceImplService"));
    }

    /**
     * 
     * @return
     *     returns MyServiceImpl
     */
    @WebEndpoint(name = "MyServiceImplPort")
    public MyServiceImpl getMyServiceImplPort() {
        return super.getPort(new QName("http://server.jaxws/", "MyServiceImplPort"), MyServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MyServiceImpl
     */
    @WebEndpoint(name = "MyServiceImplPort")
    public MyServiceImpl getMyServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.jaxws/", "MyServiceImplPort"), MyServiceImpl.class, features);
    }

}
