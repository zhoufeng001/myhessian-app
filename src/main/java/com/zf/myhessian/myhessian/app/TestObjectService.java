package com.zf.myhessian.myhessian.app;

import org.junit.Before;
import org.junit.Test;
import org.myhessian.client.ObjectService;
import org.myhessian.client.bean.Person;
import org.myhessian.client.exception.RemotingInvokException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestObjectService {

	ApplicationContext context = null ;
	ObjectService os = null ;
	//fdsafasd
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("remoting-client.xml");  //这里只是你声明的bean的xml文件所在的路径
		os = (ObjectService) context.getBean("objService");
	}

	@Test
	public void testGet(){
		Person person = os.getPerson(2) ;
		printPerson(person) ;
	}

	@Test
	public void testPut(){
		Person person = new Person() ;
		person.setAge(3);
		person.setMan(true);
		person.setName("is_zhoufeng");  

		int id = os.savePerson(person) ;
		System.out.println("ID:" + id);
	}

	@Test
	public void testException(){
		try{
			Person person = os.exceptionTest() ;
			printPerson(person) ;
		}catch(RemotingInvokException e){
			System.out.println("远程调用失败，错误信息：" + e.getMessage());
		}catch(Exception e){
			System.out.println("未知异常");
		}
	}

	void printPerson(Person person){
		if(person == null){
			System.out.println("Person is null");
		}else{
			System.out.printf("ID:%d,NAME:%s,ISNAM:%s,AGE:%d" , person.getId() ,
					person.getName(), person.isMan() , person.getAge());
		}
	}

}
