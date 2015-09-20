/**
 * 
 */
package org.spider.kernel.engine;

/**
 * 引擎
 * 
 * @author tf
 * @date 2015年9月19日下午5:41:51
 */

public interface SpiderEngine {

	/**
	 * 唯一id
	 * 
	 * @return
	 */
	String id();

	/**
	 * 名称
	 * 
	 * @return
	 */
	String name();

	/**
	 * 类型
	 * 
	 * @return
	 */
	int type();

	/**
	 * 初始化
	 */
	void init();

}