package com.zf.myhessian.myhessian.app;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import com.caucho.hessian.client.HessianProxyFactory;

/**
 * 覆盖org.springframework.remoting.caucho.HessianProxyFactoryBean中的proxyFactory
 * 在请求的Connection中加入一个请求参数auth
 * @author is_zhoufeng
 *
 */
public class AuthHessianProxyFactory extends HessianProxyFactory{

	@Override
	protected URLConnection openConnection(URL url) throws IOException {
		URLConnection conn = super.openConnection(url);
		conn.setRequestProperty("auth", "is_zhoufeng");
		return conn ;
	}
	
}
