/**
 * 
 */
package org.spider.server.interceptor;

import org.spider.server.command.CommandConfig;
import org.spider.server.command.SpiderCommand;

/**
 * @author yangguangftlp
 * 
 *         2015年1月6日
 */
public class CommandInvoker extends CommandInterceptor {

	@Override
	public <T> T execute(CommandConfig config, SpiderCommand<T> command) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNext(CommandInterceptor commandInterceptor) {
		throw new IllegalArgumentException("commandInvoke必须是最后一个拦截器");
	}
}
