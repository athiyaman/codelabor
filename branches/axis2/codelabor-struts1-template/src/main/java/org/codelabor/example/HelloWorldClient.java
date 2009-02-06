package org.codelabor.example;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.codelabor.example.HelloWorldStub.SayHello;
import org.codelabor.example.HelloWorldStub.SayHelloResponse;

public class HelloWorldClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HelloWorldStub stub = new HelloWorldStub();
			SayHello sayHello = new SayHello();
			sayHello.setName("bomber");
			SayHelloResponse response = stub.sayHello(sayHello);
			String greeting = response.get_return();
			System.out.println(greeting);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
