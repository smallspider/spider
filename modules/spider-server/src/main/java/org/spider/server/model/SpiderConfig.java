package org.spider.server.model;

import java.util.List;

import org.spider.server.annotation.ElementSign;

@ElementSign(xmlEleName = "spiderConfig")
public class SpiderConfig {

	private List<CommandDefine> commandDefine;

	public List<CommandDefine> getCommandDefine() {
		return commandDefine;
	}

	@ElementSign(xmlEleName = "commandDefine", beanType = CommandDefine.class)
	public void setCommandDefine(List<CommandDefine> commandDefine) {
		this.commandDefine = commandDefine;
	}
}
