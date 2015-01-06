package org.spider.server.command;

public interface SpiderCommand<T> {
	T execute(CommandContext commandContext);
}
