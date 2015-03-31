package org.spider.service.config;

import java.util.ArrayList;
import java.util.List;

import org.spider.service.util.DataPacketUtil;

public class SpiderConfigUtils {

	private static SpiderConfigUtils instance;
	private List<SpiderConfig> spiderConfigs = new ArrayList<SpiderConfig>();

	public SpiderConfigUtils() {
		super();
	}

	public static SpiderConfigUtils getInstance() {
		if (null == instance) {
			synchronized (DataPacketUtil.class) {
				if (null == instance) {
					instance = new SpiderConfigUtils();
				}
			}
		}
		return instance;
	}

	@SuppressWarnings("unused")
	public void load(String[] spiderConfig) {
		if (null != spiderConfig) {
			for (String className : spiderConfig) {

			}
		}
	}
}
