package org.spider.server.interceptor;

import org.spider.server.command.CommandConfig;
import org.spider.server.command.SpiderCommand;

public class CommandContextInterceptor extends CommandInterceptor {

	@Override
	public <T> T execute(CommandConfig config, SpiderCommand<T> command) {
		return null;
	}

}
