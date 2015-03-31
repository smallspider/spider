package org.spider.server.service.interceptor;

import org.spider.server.service.command.CommandConfig;
import org.spider.server.service.command.SpiderCommand;

public class CommandContextInterceptor extends CommandInterceptor {

	@Override
	public <T> T execute(CommandConfig config, SpiderCommand<T> command) {
		return null;
	}

}
