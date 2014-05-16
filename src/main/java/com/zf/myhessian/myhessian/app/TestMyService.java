package com.zf.myhessian.myhessian.app;

import java.net.MalformedURLException;

import org.myhessian.client.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyService {

	public static void main(String[] args) throws MalformedURLException {

		ApplicationContext context = new ClassPathXmlApplicationContext("remoting-client.xml");  //这里只是你声明的bean的xml文件所在的路径
		MyService b = (MyService) context.getBean("myService");
		System.out.println(b.hello());
	}

}