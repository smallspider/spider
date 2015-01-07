package org.spider.server.config;

import java.util.ArrayList;
import java.util.List;

import org.spider.server.model.DataPacketQueue;

public class SpiderConfigUtils {

	private static SpiderConfigUtils instance;
	private List<SpiderConfig> spiderConfigs = new ArrayList<SpiderConfig>();

	public SpiderConfigUtils() {
		super();
	}

	public static SpiderConfigUtils getInstance() {
		if (null == instance) {
			synchronized (DataPacketQueue.class) {
				if (null == instance) {
					instance = new SpiderConfigUtils();
				}
			}
		}
		return instance;
	}

	public void load(String[] spiderConfig) {
		if (null != spiderConfig) {
			for (String className : spiderConfig) {

			}
		}
	}
}
