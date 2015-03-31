package org.spider.service.model;

import java.util.List;

import org.spider.service.annotation.ElementSign;

@ElementSign(xmlEleName = "spiderConfig")
public class SpiderConfig {

	private List<CommandDefine> commandDefine;
	private List<Server> server;

	public List<CommandDefine> getCommandDefine() {
		return commandDefine;
	}

	public List<Server> getServer() {
		return server;
	}

	@ElementSign(xmlEleName = "commandDefine", beanType = CommandDefine.class)
	public void setCommandDefine(List<CommandDefine> commandDefine) {
		this.commandDefine = commandDefine;
	}

	@ElementSign(xmlEleName = "server", beanType = Server.class)
	public void setServer(List<Server> server) {
		this.server = server;
	}

}
