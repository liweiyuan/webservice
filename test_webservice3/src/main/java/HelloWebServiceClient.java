import javax.xml.soap.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class HelloWebServiceClient {
    public static final String NAMESPACE_URI = "http://mycompany.com/hr/schemas";
    
    public static final String PREFIX = "tns";
    
    private SOAPConnectionFactory connectionFactory;
    
    private MessageFactory messageFactory;
    
    private URL url;
    
    public HelloWebServiceClient(String url) throws UnsupportedOperationException, SOAPException, MalformedURLException {
        connectionFactory = SOAPConnectionFactory.newInstance();
        messageFactory = MessageFactory.newInstance();
        this.url = new URL(url);
    }
    
    private SOAPMessage createHelloRequest() throws SOAPException {
        SOAPMessage message = messageFactory.createMessage();
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        Name helloRequestName = envelope.createName("id",PREFIX,NAMESPACE_URI);
        SOAPBodyElement helloRequestElement = message.getSOAPBody().addBodyElement(helloRequestName);
        helloRequestElement.setValue("1");
        return message;
    }
    
    public void callWebService() throws SOAPException {
        SOAPMessage request = createHelloRequest();
        SOAPConnection connection = connectionFactory.createConnection();
        SOAPMessage response = connection.call(request, url);
        if(!response.getSOAPBody().hasFault()){
            writeHelloResponse(response);
        }else{
            SOAPFault fault = response.getSOAPBody().getFault();
            System.err.println("Received SOAP Fault");
            System.err.println("SOAP Fault Code : " + fault.getFaultCode());
            System.err.println("SOAP Fault String : " + fault.getFaultString());
        }
    }
    
    private void writeHelloResponse(SOAPMessage message) throws SOAPException {
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        Name helloResponseName = envelope.createName("fResponse",PREFIX,NAMESPACE_URI);
        Iterator childElements = message.getSOAPBody().getChildElements(helloResponseName);
        SOAPBodyElement helloResponseElement = (SOAPBodyElement)childElements.next();
        String value = helloResponseElement.getTextContent();
        System.out.println("Hello Response [" + value + "]");
    }
    
    public static void main(String[] args) throws UnsupportedOperationException, MalformedURLException, SOAPException {
        String url = "http://localhost:8088/SpringWS";
        HelloWebServiceClient helloClient = new HelloWebServiceClient(url);
        helloClient.callWebService();
    }
}