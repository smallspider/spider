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
package org.spider.kernel.engine.impl;

import org.spider.kernel.engine.SpiderEngine;

/**
 * 默认引擎实现
 * 
 * @author tf
 * @date 2015年9月19日下午5:46:00
 */
public abstract class SystemSpiderEngine implements SpiderEngine {

	public String id() {
		return null;
	}

	public String name() {
		return null;
	}

	public int type() {
		return 0;
	}

	public void init() {

	}
}
