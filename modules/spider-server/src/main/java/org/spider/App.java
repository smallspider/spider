package org.spider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		String[] configLocations = {"config\\applicationContext.xml"};
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				configLocations);
	}
}
