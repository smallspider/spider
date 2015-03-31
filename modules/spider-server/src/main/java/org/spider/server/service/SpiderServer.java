/**
 * Copyright 2014 smallspider ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author yangguangftlp
 */
package org.spider.server.service;

/**
 * @author yangguangftlp
 * 
 */
public interface SpiderServer extends Runnable {

	/**
	 * 初始化
	 */
	void init();

	/**
	 * 启动服务
	 */
	void start();

	/**
	 * 停止服务
	 */
	void stop();

	/**
	 * 暂停服务
	 */
	void suspend();

	/**
	 * 继续服务
	 */
	void doContinue();

	/**
	 * 状态 0:正常,1:停止,2:失败
	 * 
	 * @return
	 */
	int status();

	/**
	 * 服务名称
	 * 
	 * @return
	 */
	String name();

	/**
	 * 服务销毁
	 */
	void destroy();
}
