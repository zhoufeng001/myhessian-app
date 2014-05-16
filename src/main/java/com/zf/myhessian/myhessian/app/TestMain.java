package com.zf.myhessian.myhessian.app;

import java.net.MalformedURLException;

import org.myhessian.client.MyService;

import com.caucho.hessian.client.HessianProxyFactory;

/**
 * 客户端测试
 * @author is_zhoufeng
 *
 */
public class TestMain {

	public static void main(String[] args) throws MalformedURLException {

		HessianProxyFactory proxyFactory = new HessianProxyFactory();;  

		MyService service = (MyService)proxyFactory.create(MyService.class,  

				"http://localhost:8080/myhessian-web/myservice");

		System.out.println(service.hello());  

		System.out.println("ok!");;

	}

}