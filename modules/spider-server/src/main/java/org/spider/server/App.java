package org.spider.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		 new ClassPathXmlApplicationContext(new String[]{"config\\applicationContext.xml"});
	}
}
