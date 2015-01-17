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
package org.spider.server.model;

import org.spider.server.annotation.ElementSign;

/**
 * @author yangguangftlp
 * @date 2015年1月17日
 */
public class Server {

	private ServerConfig serverConfig;

	public ServerConfig getServerConfig() {
		return serverConfig;
	}

	@ElementSign(xmlEleName = "serverConfig", beanType = ServerConfig.class)
	public void setServerConfig(ServerConfig serverConfig) {
		this.serverConfig = serverConfig;
	}

}
