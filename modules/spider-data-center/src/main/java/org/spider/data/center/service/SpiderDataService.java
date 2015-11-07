/**
 * 
 */
package org.spider.data.center.service;

/**
 * @author yangguangftlp
 * 
 * @date 2015年4月6日
 */
public interface SpiderDataService {

	/**
	 * 鉴权
	 * 
	 * @param userName
	 * @param passWord
	 * @return
	 */
	boolean auth(String userName, String passWord);
}
