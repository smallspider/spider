package org.spider.data.center.interceptor;

public interface Session {

	void beforeFlush();

	void flush();

	void close();
}
