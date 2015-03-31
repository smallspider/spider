package org.spider.server.service.config;

/**
 * 配置接口
 * 
 * @author yangguangftlp
 * 
 *         2015年1月7日
 */
public interface SpiderConfig {
	Object get(String key);

	Object set(String key, Object value);

	Object add(String key, Object value);

	void update();

	void save();
}
