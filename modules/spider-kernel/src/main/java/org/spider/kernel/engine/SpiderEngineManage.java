/**
Copyright 2013-2015 Spider ORG
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
package org.spider.network.engine;
 */
package org.spider.kernel.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * 引擎管理器
 * 
 * @author tf
 * @date 2015年9月19日下午5:50:40
 */
public class SpiderEngineManage {

	private static SpiderEngineManage instance;
	/**
	 * 引擎
	 */
	private List<SpiderEngine> spiderEngineList;

	/**
	 * 
	 */
	public SpiderEngineManage() {
		super();
		spiderEngineList = new ArrayList<SpiderEngine>();
		loadSpiderEngine();
	}

	/**
	 * 加载所有引擎并启动
	 */
	public void loadSpiderEngine() {
		// java spi扫描
		ServiceLoader<SpiderEngine> seServiceLoader = ServiceLoader.load(SpiderEngine.class, this.getClass()
				.getClassLoader());
		if (null != seServiceLoader) {
			for (SpiderEngine spiderEngine : seServiceLoader) {
				spiderEngineList.add(spiderEngine);
				spiderEngine.init();
			}
		}
	}

	/**
	 * 获取引擎管理器
	 * 
	 * @return
	 */
	public static SpiderEngineManage getInstance() {

		if (null == instance) {
			synchronized (SpiderEngineManage.class) {
				if (null == instance) {
					instance = new SpiderEngineManage();
				}
			}
		}
		return instance;
	}

	/**
	 * 获取所有引擎
	 * 
	 * @return
	 */
	public List<SpiderEngine> getSpiderEngineList() {
		return spiderEngineList;
	}

}
