package org.spider.server.service.interceptor;

import org.spider.server.service.command.CommandConfig;
import org.spider.server.service.command.SpiderCommand;

/**
 * 命令拦截器
 * 
 * @author yangguangftlp
 * 
 *         2015年1月6日
 */
public abstract class CommandInterceptor {
	protected CommandInterceptor next;

	public CommandInterceptor getNext() {
		return next;
	}

	public void setNext(CommandInterceptor commandInterceptor) {
		this.next = commandInterceptor;
	}

	public abstract <T> T execute(CommandConfig config, SpiderCommand<T> command);
}
