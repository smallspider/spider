package org.spider.server.service.command;

public interface SpiderCommand<T> {
	T execute(CommandContext commandContext);
}
