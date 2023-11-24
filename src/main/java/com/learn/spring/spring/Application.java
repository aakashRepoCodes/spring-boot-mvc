package com.learn.spring.spring;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@SpringBootApplication
public class Application {

	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		try {
			boolean result = isRunningUp();
		} catch (IOException ignored){

		}
	}

	private void isRunningUp() throws IOException {
		isServiceUp();
	}

	private boolean isServiceUp() throws IOException {
		String address = env.getProperty("service1.address");
		String port = env.getProperty("service1.port");
		return isServiceReachable(address, Integer.parseInt(port), 3000);
	}


	private static boolean isServiceReachable(String address, int port, int timeout) throws IOException {
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(address, port), timeout);
			return  true;
		} catch( IOException e) {
			return false;
		}finally {
			socket.close();
		}
	}
}
