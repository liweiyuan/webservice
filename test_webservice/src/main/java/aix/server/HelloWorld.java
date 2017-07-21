package aix.server;/**
 * Created by admin on 2016/7/26.
 */
public class HelloWorld {
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println("aix service:"+result);
    return result;
  }
}
