package com.soap.axis2;

public class ServiceServerImpl implements IServiceServer {
	public String sayhello(String name) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sleep 3000,result: " + name;
	}
}