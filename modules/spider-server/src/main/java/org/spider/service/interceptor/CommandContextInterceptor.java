package org.spider.service.interceptor;

import org.spider.service.command.CommandConfig;
import org.spider.service.command.SpiderCommand;

public class CommandContextInterceptor extends CommandInterceptor {

	@Override
	public <T> T execute(CommandConfig config, SpiderCommand<T> command) {
		return null;
	}

}
