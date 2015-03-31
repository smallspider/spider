package org.spider.service.command;

public interface SpiderCommand<T> {
	T execute(CommandContext commandContext);
}
